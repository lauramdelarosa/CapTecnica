package com.delarosa.mybank.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delarosa.mybank.R
import kotlinx.android.synthetic.main.activity_transaction.*

class TransactionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)


        create_transaction_button.setOnClickListener {
            val showDetailActivityIntent = Intent(this, DashboardActivity::class.java)
            startActivity(showDetailActivityIntent)
        }
    }


}
