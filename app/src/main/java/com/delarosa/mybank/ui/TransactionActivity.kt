package com.delarosa.mybank.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.delarosa.mybank.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_transaction.*

class TransactionActivity : AppCompatActivity() {

    private lateinit var viewModel: TransactionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        viewModel = ViewModelProviders.of(this).get(TransactionViewModel::class.java)

        //observables of viewmodel
        viewModel.errorMessage.observe(this, Observer {
            showMessage(it)
        })

        viewModel.successResponse.observe(this, Observer {
            startActivity(Intent(this, DashboardActivity::class.java))
        })

        //listeners
        create_transaction_button.setOnClickListener {
            viewModel.accountRequest(
                customer_id.text.toString(),
                channel_id.text.toString(),
                pruduct_number.text.toString(),
                amount.text.toString(),
                type.text.toString()
            )
        }
    }


    private fun showMessage(message: String) =
        Snackbar.make(transactionActivity, message, Snackbar.LENGTH_LONG).show()




}
