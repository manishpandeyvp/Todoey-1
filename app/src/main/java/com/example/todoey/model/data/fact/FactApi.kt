package com.example.todoey.model.data.fact

import com.example.todoey.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FactApi {

    @GET(Constants.RANDOM_JSON)
    suspend fun getFact(@Query(Constants.LANGUAGE) lang: String): Response<Fact>

}