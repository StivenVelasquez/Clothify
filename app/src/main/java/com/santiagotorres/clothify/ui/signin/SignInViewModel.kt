package com.santiagotorres.clothify.ui.signin


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santiagotorres.clothify.data.ResourceRemote
import com.santiagotorres.clothify.data.UserRepository
import kotlinx.coroutines.launch

class SignInViewModel: ViewModel() {

    private val userRepository = UserRepository()

    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg

    private val _isSuccessSignIn: MutableLiveData <Boolean> = MutableLiveData()
    val isSuccessSignIn: LiveData <Boolean> = _isSuccessSignIn


    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+[.]+[a-z]+"

    fun validateFields(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()){
            _errorMsg.value = "Digite todos los campos"
        }
        else{
            if (!email.matches(emailPattern.toRegex())){
                _errorMsg.value = "Ingrese un correo válido"
            }
            else{
                viewModelScope.launch {
                    when (val resourceRemote = userRepository.signInUser(email,password)){
                        is ResourceRemote.Success ->{
                            _isSuccessSignIn.postValue(true)
                        }
                        is ResourceRemote.Error -> {
                            var msg = resourceRemote.message
                            when (resourceRemote.message){
                                "A network error (such as timeout, interrupted connection or unreachable host) has occurred." -> msg = "Revise su conexión de internet"
                                "The password is invalid or the user does not have a password." -> msg = "Correo electrónico o contraseña inválida"
                            }
                            _errorMsg.postValue(msg!!)
                        }
                        else -> {

                        }
                    }
                }
            }
        }
    }
}