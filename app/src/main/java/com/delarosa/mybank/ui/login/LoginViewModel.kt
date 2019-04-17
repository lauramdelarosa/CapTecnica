package com.delarosa.mybank.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.delarosa.mybank.datasource.WebAccess
import com.delarosa.mybank.model.CustomerLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * process all data and show its output to view.
 */
class LoginViewModel : ViewModel() {

    //outputs
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _successResponse = MediatorLiveData<Unit>()
    val successResponse: LiveData<Unit> get() = _successResponse

    // Internal

    private val _saveAuthorizationToken = MutableLiveData<String>()

    init {
        _successResponse.addSource(_saveAuthorizationToken) {
            //saveAutorizationToken in preferences it
            _successResponse.value = Unit
        }
    }

    //events
    /**
     * this method valid data that user entered is correct
     */
     fun validateData(customerId: String, password: String): Boolean =
        (isValidText(customerId) && isValidText(password))

     fun isValidText(string: String): Boolean = string.isNotEmpty()

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

        _successResponse.postValue(Unit)
       /* GlobalScope.launch(Dispatchers.Main) {
            try {
                val webResponse = WebAccess.API.logInAsync(CustomerLogin(customerId, password)).await()
                if (webResponse.isSuccessful) {
                    _successResponse.postValue(Unit)
                } else {
                    _errorMessage.postValue("Login Error")
                }
            } catch (e: IOException) {
                _errorMessage.postValue(e.toString())

            }
        }*/

    }

}