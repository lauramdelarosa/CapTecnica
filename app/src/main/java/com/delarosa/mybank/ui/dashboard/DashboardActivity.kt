package com.delarosa.mybank.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.delarosa.mybank.R
import com.delarosa.mybank.ui.transaction.TransactionActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_dashboard.*

/**
 * View, in this case activity, don't think, its job is show information already proccesed by viewModel
 */
class DashboardActivity : AppCompatActivity() {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var adapter: TransactionsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        initRecyclerView()

        viewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)

        //observables of viewmodel
        viewModel.errorMessageAmount.observe(this, Observer {
            showMessage(it)
        })

        viewModel.successResponseTransactionList.observe(this, Observer {
            adapter.postItemList = it ?: listOf()
            adapter.notifyDataSetChanged()
            recycler_view.scheduleLayoutAnimation()
        })


        viewModel.currentAmount.observe(this, Observer {
            amount.text = it
        })

        see_amount.setOnClickListener { viewModel.getAmountData() }
        transactionList.setOnClickListener { startActivity(Intent(this, TransactionActivity::class.java)) }
    }

    private fun showMessage(message: String) =
        Snackbar.make(dashboardActivity, message, Snackbar.LENGTH_LONG).show()

    private fun initRecyclerView() {
        val controller = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_down_to_up)
        recycler_view.layoutAnimation = controller
        recycler_view.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recycler_view.hasFixedSize()
        adapter = TransactionsAdapter(listOf())
        recycler_view.adapter = adapter

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}
