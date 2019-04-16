package com.delarosa.mybank.ui.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
        channelId: String,
        product_number: String,
        amount: String,
        type: String
    ) {
        if (validateData(costumerId, channelId, product_number, amount, type)) {
            requestTransaction(costumerId, channelId, product_number, amount, type)
        } else (_errorMessage.postValue("Invalid Fields"))

    }

    /**
     * this method valid data that user entered is correct
     */
    private fun validateData(
        costumerId: String,
        channelId: String,
        product_number: String,
        amount: String,
        type: String
    ): Boolean = (
            isValidText(channelId)
                    && isValidText(costumerId)
                    && isValidText(product_number)
                    && isValidText(amount)
                    && isValidText(type))

    private fun isValidText(string: String): Boolean = string.isNotEmpty()


    /**
     * this method request transaction to the api, and show its response.
     * if response is ok, do intent to DashboardActivity
     * if not show an error
     */

    private fun requestTransaction(
        costumerId: String,
        channelId: String,
        pruduct_number: String,
        amount: String,
        type: String
    ) {
        //se comunica con el repositorio
        if (1 == 1) {
            _successResponse.postValue(Unit)
        } else {
            _errorMessage.postValue("Transaction Error")
        }

    }
}