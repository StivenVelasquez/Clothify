package com.santiagotorres.clothify.ui.signup


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SignUpViewModel : ViewModel() {

    private val _errorMsg: MutableLiveData <String> = MutableLiveData()
    val errorMsg: LiveData <String> = _errorMsg

    private val _isSuccessSignUp: MutableLiveData <Boolean> = MutableLiveData()
    val isSuccessSignUp: LiveData <Boolean> = _isSuccessSignUp


    fun validateFields(user: String, email: String, password: String, repPassword: String){

        if (email.isEmpty() || password.isEmpty() || repPassword.isEmpty() || user.isEmpty()){
            _errorMsg.value = "Debe llenar todos los campos"
        }
        else {
            if (password.length < 6) {
                _errorMsg.value = "La contraseña debe tener mínimo 6 dígitos"
            }
            else{
                if (password != repPassword){
                    _errorMsg.value = "Las contraseñas no son iguales"
                }
                else {
                    _isSuccessSignUp.value = true
                }
            }
        }




    }

}