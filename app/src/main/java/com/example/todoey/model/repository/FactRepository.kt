package com.example.todoey.model.repository

import com.example.todoey.MyApplication
import com.example.todoey.model.data.fact.FactApi
import com.example.todoey.model.network.RetrofitHelper
import com.example.todoey.utils.Constants
import com.example.todoey.utils.Internet

class FactRepository {

    suspend fun getFact(): String? {
        if (Internet.hasInternetAccess()) {
            val factApi = RetrofitHelper.getInstance().create(FactApi::class.java)
            val res = factApi.getFact(Constants.EN)

            with(MyApplication.getSharedPrefs().edit()) {
                putString(Constants.FACT, res.body()?.text)
                apply()
            }

            return res.body()?.text
        } else {
            if (!MyApplication.getSharedPrefs().getString(Constants.FACT, Constants.EMPTY_STRING)
                    .isNullOrEmpty()
            ) {
                return MyApplication.getSharedPrefs()
                    .getString(Constants.FACT, Constants.EMPTY_STRING)
            }

            return Constants.EMPTY_STRING
        }
    }

}