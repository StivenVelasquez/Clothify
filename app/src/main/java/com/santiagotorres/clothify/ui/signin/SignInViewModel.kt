package com.santiagotorres.clothify.ui.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel: ViewModel() {

    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg

    private val _isSuccessSignIn: MutableLiveData <Boolean> = MutableLiveData()
    val isSuccessSignIn: LiveData <Boolean> = _isSuccessSignIn

    val correo = "ss@gmail.com"
    val pass = "ss1234"

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
                if (email != correo || password != pass){
                    _errorMsg.value = "Correo o contraseña incorrectos"
                }
                else{
                    _isSuccessSignIn.value = true
                }
            }

        }
    }
}