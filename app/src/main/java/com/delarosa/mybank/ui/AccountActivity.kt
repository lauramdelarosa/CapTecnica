package com.delarosa.mybank.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.delarosa.mybank.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_account.account
import kotlinx.android.synthetic.main.activity_account.customerId
import kotlinx.android.synthetic.main.activity_account.password

class AccountActivity : AppCompatActivity() {

    private lateinit var viewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        viewModel = ViewModelProviders.of(this).get(AccountViewModel::class.java)

        //observables of viewmodel
        viewModel.errorMessage.observe(this, Observer {
            showMessage(it)
        })

        viewModel.successResponse.observe(this, Observer {
            startActivity(Intent(this, LoginActivity::class.java))
        })

        //listeners
        account.setOnClickListener {
            viewModel.accountRequest(
                customerId.text.toString(),
                name.text.toString(),
                surname.text.toString(),
                email.text.toString(),
                phone.text.toString(),
                mobile.text.toString(),
                password.text.toString()
                )
        }

    }

    private fun showMessage(message: String) =
        Snackbar.make(accountActivity, message, Snackbar.LENGTH_LONG).show()


    override fun onBackPressed() {
        super.onBackPressed()

        val showDetailActivityIntent = Intent(this, LoginActivity::class.java)
        startActivity(showDetailActivityIntent)
    }
}
