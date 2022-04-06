package com.example.todoey.model.repository

import com.example.todoey.MyApplication
import com.example.todoey.model.data.fact.FactApi
import com.example.todoey.model.network.Internet
import com.example.todoey.model.network.RetrofitHelper

class FactRepository {

    suspend fun getFact(): String? {
        if (Internet.hasInternetAccess()) {
            val factApi = RetrofitHelper.getInstance().create(FactApi::class.java)
            val res = factApi.getFact("en")
            with(MyApplication.getSharedPrefs().edit()) {
                putString("fact", res.body()?.text)
                apply()
            }
            return res.body()?.text
        } else {
            if (!MyApplication.getSharedPrefs().getString("fact", "").isNullOrEmpty()) {
                return MyApplication.getSharedPrefs().getString("fact", "")
            }
            return ""
        }
    }

}