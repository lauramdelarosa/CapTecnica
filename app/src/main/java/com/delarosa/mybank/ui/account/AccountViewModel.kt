package com.delarosa.mybank.ui.account

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.delarosa.mybank.datasource.WebAccess
import com.delarosa.mybank.model.Customer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * process all data and show its output to view.
 */
open class AccountViewModel : ViewModel() {

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
            requestAccount(Customer(costumerId, name, surname, email, phone, mobile, password))
        } else (_errorMessage.postValue("Invalid Fields"))

    }

    /**
     * this method valid data that user entered is correct
     */
    fun validateData(
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

    fun isValidEmail(email: String): Boolean = email.isNotEmpty() &&
            Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isValidText(string: String): Boolean = string.isNotEmpty()

    /**
     * this method request account to the api, and show its response.
     * if response is ok, do intent to LoginActivity
     * if not show an error
     */
   private fun requestAccount(customer: Customer) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val webResponse = WebAccess.API.signUpAsync(customer = customer).await()
                if (webResponse.isSuccessful) {
                    _successResponse.postValue(Unit)
                } else {
                    _errorMessage.value = "List TransactionList Error"
                }
            } catch (e: IOException) {
            }
        }
    }


}