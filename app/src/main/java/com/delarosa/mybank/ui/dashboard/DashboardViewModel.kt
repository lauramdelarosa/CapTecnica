package com.delarosa.mybank.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.delarosa.mybank.model.Product
import com.delarosa.mybank.model.Transaction
import com.delarosa.mybank.datasource.WebAccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class DashboardViewModel : ViewModel() {

    //outputs
    private val _currentAmount = MutableLiveData<String>()
    val currentAmount: LiveData<String> get() = _currentAmount

    private val _errorMessageAmount = MutableLiveData<String>()
    val errorMessageAmount: LiveData<String> get() = _errorMessageAmount

    private val _successResponseAmount = MutableLiveData<Unit>()
    val successResponseAmount: LiveData<Unit> get() = _successResponseAmount


    private val _errorMessageTransaction = MutableLiveData<String>()
    val errorMessageTransaction: LiveData<String> get() = _errorMessageTransaction

    private val _successResponseTransaction = MutableLiveData<List<Transaction>>()
    val successResponseTransaction: LiveData<List<Transaction>> get() = _successResponseTransaction


    init {
        getLastTransactionData()
    }

    private fun getLastTransactionData() {
        getLastTransaction(5, "1012345", "1000000001")
    }


    //events
    fun getAmount() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val webResponse = WebAccess.API.getCustomerProductsAsync().await()
                if (webResponse.isSuccessful) {
                    val amount: Product? = webResponse.body()
                    _currentAmount.value = amount?.balance.toString()
                    _successResponseAmount.postValue(Unit)

                } else {
                    _errorMessageAmount.value = "Amount Error"
                }
            } catch (e: IOException) {
            }
        }

    }

    private fun getLastTransaction(limit: Int, costumerId: String, productNumber: String) {

        GlobalScope.launch(Dispatchers.Main) {
            try {
              //  val webResponse = WebAccess.API.getLastTransactionsAsync(limit, costumerId, productNumber).await()
                val webResponse = WebAccess.API.getLastTransactionsAsync().await()
                if (webResponse.isSuccessful) {
                    val postList: List<Transaction>? = webResponse.body()
                    _successResponseTransaction.value = postList

                } else {
                    _errorMessageTransaction.value = "List Transaction Error"
                }
            } catch (e: IOException) {
            }
        }

    }
}