package com.delarosa.mybank.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delarosa.mybank.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            val showDetailActivityIntent = Intent(this, DashboardActivity::class.java)
            startActivity(showDetailActivityIntent)
        }

        account.setOnClickListener {
            val showDetailActivityIntent = Intent(this, AccountActivity::class.java)
            startActivity(showDetailActivityIntent)
        }
    }
}
