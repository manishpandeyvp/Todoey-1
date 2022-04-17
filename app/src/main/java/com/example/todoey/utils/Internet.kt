package com.example.todoey.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.todoey.MyApplication


object Internet {
    fun hasInternetAccess(): Boolean {
        val connectivityManager = MyApplication.getContext()
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork) ?: return false
            return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else
            for (network in connectivityManager.allNetworks) {
                val networkInfo = connectivityManager.getNetworkInfo(network)
                if (networkInfo != null && networkInfo.isConnected) return true
            }

        return false
    }
}