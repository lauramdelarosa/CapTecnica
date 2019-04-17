package com.delarosa.mybank.ui.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.delarosa.mybank.datasource.WebAccess
import com.delarosa.mybank.model.Transaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * process all data and show its output to view.
 */
class TransactionViewModel : ViewModel() {

    //outputs
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _successResponse = MutableLiveData<Unit>()
    val successResponse: LiveData<Unit> get() = _successResponse

    fun accountRequest(
        costumerId: String,
        productNumber: String,
        amount: String
    ) {
        if (validateData(costumerId, productNumber, amount)) {
            requestTransaction(Transaction(costumerId, productNumber, 2, amount.toInt(), 3))
        } else (_errorMessage.postValue("Invalid Fields"))

    }

    /**
     * this method valid data that user entered is correct
     */
    fun validateData(
        costumerId: String,
        productNumber: String,
        amount: String
    ): Boolean = (isValidText(costumerId)
            && isValidText(productNumber)
            && isValidText(amount))

    fun isValidText(string: String): Boolean = string.isNotEmpty()


    /**
     * this method request transaction to the api, and show its response.
     * if response is ok, do intent to DashboardActivity
     * if not show an error
     */

    private fun requestTransaction(transaction: Transaction) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val webResponse = WebAccess.API.saveTransactionAsync("awxy", transaction).await()
                if (webResponse.isSuccessful) {

                    _successResponse.postValue(Unit)

                } else {
                    _errorMessage.value = "Transaction Error"
                }
            } catch (e: IOException) {
                _errorMessage.value = e.toString()
            }
        }
    }
}