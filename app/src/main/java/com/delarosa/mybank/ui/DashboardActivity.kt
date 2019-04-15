package com.delarosa.mybank.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.delarosa.mybank.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var viewModel: DashboarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        viewModel = ViewModelProviders.of(this).get(DashboarViewModel::class.java)


        transaction.setOnClickListener {
            val showDetailActivityIntent = Intent(this, TransactionActivity::class.java)
            startActivity(showDetailActivityIntent)
        }
    }


}
