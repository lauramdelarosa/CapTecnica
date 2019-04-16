package com.delarosa.mybank.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    var customer_id: String,
    var product_name: String,
    var balance: Int,
    var product_number: String
)