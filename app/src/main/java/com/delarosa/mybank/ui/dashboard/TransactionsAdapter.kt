package com.delarosa.mybank.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.delarosa.mybank.R
import com.delarosa.mybank.model.Transaction
import kotlinx.android.synthetic.main.transaction_item_list.view.*


class TransactionsAdapter(var postItemList: List<Transaction>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): androidx.recyclerview.widget.RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.transaction_item_list, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {

        (holder as PartViewHolder).bind(postItemList[position])
    }

    override fun getItemCount() = postItemList.size

    class PartViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bind(transaction: Transaction) {
            itemView.transaction_number.text = transaction.transactionNumber

            itemView.date.text =transaction.date.substring(0,10)
            itemView.status.text = transaction.status
            itemView.amount.text = transaction.amount
        }
    }
}
