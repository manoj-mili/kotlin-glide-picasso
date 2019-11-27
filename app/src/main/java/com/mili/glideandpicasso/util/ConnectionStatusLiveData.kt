package com.mili.glideandpicasso.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.lifecycle.LiveData

class ConnectionStatusLiveData(private val context: Context): LiveData<Boolean>() {

    /*
    * Syntax to create object of anonymous, abstract class
    * */
    private val internetReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (ConnectivityManager.CONNECTIVITY_ACTION == intent.action) {
                val noConnectivity =
                    intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)
                postValue(!noConnectivity)
            }
        }
    }

    override fun onActive() {
        super.onActive()
        val filter = IntentFilter();
        filter.addAction(ConnectivityManager.EXTRA_NO_CONNECTIVITY)
        context.registerReceiver(internetReceiver, filter)
    }

    override fun onInactive() {
        super.onInactive()
        context.unregisterReceiver(internetReceiver)
    }
}