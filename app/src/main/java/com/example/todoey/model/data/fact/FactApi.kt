package com.example.todoey.model.data.fact

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FactApi {

    @GET("random.json")
    suspend fun getFact(@Query("language") lang : String) : Response<Fact>

}