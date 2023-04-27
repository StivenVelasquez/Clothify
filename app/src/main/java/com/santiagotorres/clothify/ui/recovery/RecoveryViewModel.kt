package com.santiagotorres.clothify.ui.recovery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecoveryViewModel : ViewModel() {

    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg

    private val _itscorrect: MutableLiveData <Boolean> = MutableLiveData()
    val isCorrect: LiveData <Boolean> = _itscorrect

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+[.]+[a-z]+"

    fun validateFields(email: String) {
        if (email.isEmpty()){
            _errorMsg.value = "Digite su correo"
        }
        else{
            if (!email.matches(emailPattern.toRegex())){
                _errorMsg.value = "Ingrese un correo válido"
            }
            else{
                _itscorrect.value = true
            }
        }
    }
}
