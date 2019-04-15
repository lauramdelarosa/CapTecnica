package com.delarosa.mybank.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delarosa.mybank.R
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        account.setOnClickListener {
            val showDetailActivityIntent = Intent(this, LoginActivity::class.java)
            startActivity(showDetailActivityIntent)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()

        val showDetailActivityIntent = Intent(this, LoginActivity::class.java)
        startActivity(showDetailActivityIntent)
    }
}
