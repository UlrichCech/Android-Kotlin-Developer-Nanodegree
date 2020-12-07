package com.udacity.shoestore.login.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var email = MutableLiveData("")

    var password = MutableLiveData("")


    private val _signInPressed = MutableLiveData(false)
    val signInPressed : LiveData<Boolean>
        get() = _signInPressed

    private val _signUpPressed = MutableLiveData(false)
    val signUpPressed : LiveData<Boolean>
        get() = _signUpPressed




    fun signIn() {
        _signInPressed.value = true
    }

    fun signUp() {
        _signUpPressed.value = true
    }

    fun onSignInComplete() { // be prepared for different navigation targets
        _signInPressed.value = false
    }

    fun onSignUpComplete() { // be prepared for different navigation targets
        _signUpPressed.value = false
    }


}