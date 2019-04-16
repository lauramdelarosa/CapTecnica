package com.delarosa.mybank.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
/**
 * process all data and show its output to view.
 */
class LoginViewModel : ViewModel() {

    //outputs
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _successResponse = MutableLiveData<Unit>()
    val successResponse: LiveData<Unit> get() = _successResponse

    //events
    /**
     * this method valid data that user entered is correct
     */
    private fun validateData(customerId: String, password: String): Boolean =
        (isValidText(customerId) && isValidText(password))

    private fun isValidText(string: String): Boolean = string.isNotEmpty()

    fun loginRequest(customerId: String, password: String) {
        if (validateData(customerId, password)) {
            requestLogin(customerId, password)
        } else (_errorMessage.postValue("Invalid Fields"))

    }
    /**
     * this method request login to the api, and show its response.
     * if response is ok, do intent to DashboardActivity
     * if not show an error
     */
    private fun requestLogin(customerId: String, password: String) {
        //se comunica con el repositorio
        if (1 == 1) {
            _successResponse.postValue(Unit)
        } else {
            _errorMessage.postValue("Login Error")
        }

    }

}