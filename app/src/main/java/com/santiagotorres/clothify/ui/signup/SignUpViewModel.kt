package com.santiagotorres.clothify.ui.signup


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santiagotorres.clothify.data.ResourceRemote
import com.santiagotorres.clothify.data.UserRepository
import com.santiagotorres.clothify.model.User
import kotlinx.coroutines.launch


class SignUpViewModel : ViewModel() {

    private val userRepository = UserRepository()

    private val _errorMsg: MutableLiveData <String?> = MutableLiveData()
    val errorMsg: LiveData <String?> = _errorMsg

    private val _isSuccessSignUp: MutableLiveData <Boolean> = MutableLiveData()
    val isSuccessSignUp: LiveData <Boolean> = _isSuccessSignUp

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+[.]+[a-z]+"

    fun validateFields(
        user: String,
        email: String,
        password: String,
        repPassword: String,
        name: String
    ){

        if (email.isEmpty() || password.isEmpty() || repPassword.isEmpty() || user.isEmpty() || name.isEmpty()) {
            _errorMsg.value = "Debe llenar todos los campos"
        }
        else {
            if (!email.matches(emailPattern.toRegex())){
                _errorMsg.value = "Ingrese un correo electrónico válido"
            }
            else {
                if (password.length < 6) {
                    _errorMsg.value = "La contraseña debe tener mínimo 6 dígitos"
                } else {
                    if (password != repPassword) {
                        _errorMsg.value = "Las contraseñas no son iguales"
                    } else {

                        viewModelScope.launch {
                            val result = userRepository.signUpUser(email,password)
                            result.let {resourceRemote ->
                                when (resourceRemote){

                                    is ResourceRemote.Success -> {
                                        val user = User(
                                            uid = resourceRemote.data,
                                            name= name,
                                            email = email
                                        )
                                        createUser(user)
                                        //_isSuccessSignUp.postValue(true)


                                    }

                                    is ResourceRemote.Error -> {
                                        var msg = resourceRemote.message
                                        when (resourceRemote.message){
                                            "A network error (such as timeout, interrupted connection or unreachable host) has occurred." -> msg = "Revise su conexión de internet"
                                            "The email address is already in use by another account." -> msg = "Ya existe una cuenta con ese correo electrónico"
                                        }
                                        _errorMsg.postValue(msg)

                                    }

                                    else -> {

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun createUser(user: User) {

        viewModelScope.launch {

            val result = userRepository.createUser(user)
            result.let{resourceRemote ->
                when (resourceRemote){
                    is ResourceRemote.Success -> {
                        _isSuccessSignUp.postValue(true)
                        _errorMsg.postValue("Registro Exitoso")
                    }
                    is ResourceRemote.Error -> {
                        val msg = result.message
                        _errorMsg.postValue(msg)

                    }
                    else -> {

                    }
                }
            }
        }
    }
}














