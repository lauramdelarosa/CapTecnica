package com.delarosa.mybank.datasource


import com.delarosa.mybank.model.Product
import com.delarosa.mybank.model.Transaction
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiClient {
    /*@GET("/api/1.0/transaction/getLast/{limit}/{customerId}/{productNumber}/get")
    fun getLastTransactionsAsync(
        @Path("limit") limit: Int,
        @Path("customerId") customerId: String,
        @Path("productNumber") productNumber: String
    ):
            Deferred<Response<List<Transaction>>>*/

    /*@GET("/api/1.0/product/{customerId}/get")
    fun getCustomerProductsAsync(@Path("customerId") customerId: Int): Deferred<Response<Product>>
*/
    //estas son de prueba con Mockoon
    @GET("/api/1.0/transaction/getLast/get")
    fun getLastTransactionsAsync(

    ):
            Deferred<Response<List<Transaction>>>

    //estas son de prueba con Mockoon
    @GET("/api/1.0/product/get")
    fun getCustomerProductsAsync(): Deferred<Response<Product>>

}