package com.delarosa.mybank.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delarosa.mybank.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        transaction.setOnClickListener {
            val showDetailActivityIntent = Intent(this, TransactionActivity::class.java)
            startActivity(showDetailActivityIntent)
        }
    }


}
