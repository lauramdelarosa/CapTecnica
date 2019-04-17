package com.delarosa.mybank.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Customer(
    @field:Json(name = "customer_id") var customerId: String,
    var surname: String,
    var name: String,
    var email: String,
    var mobile: String,
    var phone: String,
    var password: String
)

@JsonClass(generateAdapter = true)
data class CustomerLogin(
    @field:Json(name = "customer_id") var customerId: String,
    var password: String
)