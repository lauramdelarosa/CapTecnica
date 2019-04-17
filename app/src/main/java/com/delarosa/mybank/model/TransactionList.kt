package com.delarosa.mybank.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class TransactionList(
    @field:Json(name = "transaction_number") var transactionNumber: String,
    var date: String,
    var amount: String,
    var status: String
)

@JsonClass(generateAdapter = true)
data class Transaction(
    @field:Json(name = "customer_id") var customerId: String,
    @field:Json(name = "product_number") var productNumber: String,
    @field:Json(name = "channel_id") var channelId: Int,
    var amount: Int,
    var type: Int


)