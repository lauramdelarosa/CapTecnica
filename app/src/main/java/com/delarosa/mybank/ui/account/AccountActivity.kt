package com.delarosa.mybank.ui.account

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.delarosa.mybank.R
import com.delarosa.mybank.ui.login.LoginActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_account.account
import kotlinx.android.synthetic.main.activity_account.customerId
import kotlinx.android.synthetic.main.activity_account.password

/**
 * View, in this case activity, don't think, its job is show information already proccesed by viewModel
 */
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

        //listeners. this: pass all the data to viewmodel to evaluate
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

    /**
     * this method show messages with a snackbar.. in this case just errors
     */
    private fun showMessage(message: String) =
        Snackbar.make(accountActivity, message, Snackbar.LENGTH_LONG).show()

    /**
     * when user press back button, returns to LoginActivity. I do this, because I have nohistory at manifest
     */
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity( Intent(this, LoginActivity::class.java))
    }
}
