package com.santiagotorres.clothify.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santiagotorres.clothify.data.UserRepository
import kotlinx.coroutines.launch

class PerfilViewModel: ViewModel () {


    private var userRepository = UserRepository()




    fun signOut(){

        userRepository.signOut()

    }
}