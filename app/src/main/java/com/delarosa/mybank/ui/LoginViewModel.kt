package com.delarosa.mybank.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    //outputs
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _successResponse = MutableLiveData<Unit>()
    val successResponse: LiveData<Unit> get() = _successResponse

    //events
    private fun validateData(customerId: String, password: String): Boolean =
        (isValidText(customerId) && isValidText(password))

    private fun isValidText(string: String): Boolean = string.isNotEmpty()

    fun loginRequest(customerId: String, password: String) {
        if (validateData(customerId, password)) {
            requestLogin(customerId, password)
        } else (_errorMessage.postValue("Invalid Fields"))

    }

    private fun requestLogin(customerId: String, password: String) {
        //se comunica con el repositorio
        if (1 == 1) {
            _successResponse.postValue(Unit)
        } else {
            _errorMessage.postValue("Login Error")
        }

    }

}