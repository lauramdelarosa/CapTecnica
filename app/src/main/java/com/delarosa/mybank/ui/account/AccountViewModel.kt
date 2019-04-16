package com.delarosa.mybank.ui.account

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * process all data and show its output to view.
 */
class AccountViewModel : ViewModel() {

    //outputs
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _successResponse = MutableLiveData<Unit>()
    val successResponse: LiveData<Unit> get() = _successResponse


    fun accountRequest(
        costumerId: String,
        name: String,
        surname: String,
        email: String,
        phone: String,
        mobile: String,
        password: String
    ) {
        if (validateData(costumerId, name, surname, email, mobile, password)) {
            requestAccount(costumerId, name, surname, email, phone, mobile, password)
        } else (_errorMessage.postValue("Invalid Fields"))

    }

    /**
     * this method valid data that user entered is correct
     */
    private fun validateData(
        costumerId: String,
        name: String,
        surname: String,
        email: String,
        mobile: String,
        password: String
    ): Boolean = (
            isValidEmail(email)
                    && isValidText(costumerId)
                    && isValidText(name)
                    && isValidText(surname)
                    && isValidText(mobile)
                    && isValidText(password))

    private fun isValidEmail(email: String): Boolean = email.isNotEmpty() &&
            Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidText(string: String): Boolean = string.isNotEmpty()

    /**
     * this method request account to the api, and show its response.
     * if response is ok, do intent to LoginActivity
     * if not show an error
     */
    private fun requestAccount(
        costumerId: String,
        name: String,
        surname: String,
        email: String,
        phone: String,
        mobile: String,
        password: String
    ) {
        //se comunica con el repositorio
        if (1 == 1) {
            _successResponse.postValue(Unit)
        } else {
            _errorMessage.postValue("Account Error")
        }

    }


}