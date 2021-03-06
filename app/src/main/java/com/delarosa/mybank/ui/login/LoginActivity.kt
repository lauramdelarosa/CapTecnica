package com.delarosa.mybank.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.delarosa.mybank.R
import com.delarosa.mybank.ui.account.AccountActivity
import com.delarosa.mybank.ui.dashboard.DashboardActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

/**
 * View, in this case activity, don't think, its job is show information already proccesed by viewModel
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        //observables of viewmodel
        viewModel.errorMessage.observe(this, Observer {
            showMessage(it)
        })

        viewModel.successResponse.observe(this, Observer {
            startActivity(Intent(this, DashboardActivity::class.java))
        })

        //listeners
        login.setOnClickListener {
            viewModel.loginRequest(customerId.text.toString(), password.text.toString())
        }

        account.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }

    }

    private fun showMessage(message: String) =
        Snackbar.make(loginActivity, message, Snackbar.LENGTH_LONG).show()


}
