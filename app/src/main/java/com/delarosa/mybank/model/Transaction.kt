package com.delarosa.mybank.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Transaction(
    @field:Json(name = "transaction_number") var transactionNumber: String,
    var date: String,
    var amount: String,
    var status: String
)