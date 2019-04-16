package com.delarosa.mybank.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.delarosa.mybank.datasource.WebAccess
import com.delarosa.mybank.model.Product
import com.delarosa.mybank.model.Transaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * process all data and show its output to view.
 */
class DashboardViewModel : ViewModel() {

    //outputs
    private val _currentAmount = MutableLiveData<String>()
    val currentAmount: LiveData<String> get() = _currentAmount

    private val _errorMessage = MutableLiveData<String>()
    val errorMessageAmount: LiveData<String> get() = _errorMessage


    private val _successResponseTransaction = MutableLiveData<List<Transaction>>()
    val successResponseTransaction: LiveData<List<Transaction>> get() = _successResponseTransaction


    init {
        getLastTransactionData()
    }

    private fun getLastTransactionData() {
        getLastTransaction(5, "1012345", "1000000001")
    }


    //events
    /**
     * this method request amount to the api, and show its response.
     * if response is ok, show the current amount
     * if not show an error
     */
    fun getAmount() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val webResponse = WebAccess.API.getCustomerProductsAsync().await()
                if (webResponse.isSuccessful) {
                    val amount: Product? = webResponse.body()
                    _currentAmount.value = amount?.balance.toString()


                } else {
                    _errorMessage.value = "Amount Error"
                }
            } catch (e: IOException) {
            }
        }

    }

    /**
     * this method request lastTransactions to the api, and show its response.
     * if response is ok, show list of last transaction
     * if not show an error
     */
    private fun getLastTransaction(limit: Int, costumerId: String, productNumber: String) {

        GlobalScope.launch(Dispatchers.Main) {
            try {
                //  val webResponse = WebAccess.API.getLastTransactionsAsync(limit, costumerId, productNumber).await()
                val webResponse = WebAccess.API.getLastTransactionsAsync().await()
                if (webResponse.isSuccessful) {
                    val postList: List<Transaction>? = webResponse.body()
                    _successResponseTransaction.value = postList

                } else {
                    _errorMessage.value = "List Transaction Error"
                }
            } catch (e: IOException) {
            }
        }

    }
}