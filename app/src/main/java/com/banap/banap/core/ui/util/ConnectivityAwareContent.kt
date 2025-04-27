package com.banap.banap.core.ui.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.banap.banap.app.util.hasInternetConnection

@Composable
fun ConnectivityAwareContent(
    content: @Composable (isOnline: Boolean) -> Unit
) {
    val context = LocalContext.current
    val cm = remember {
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    val isOnline = remember { mutableStateOf(context.hasInternetConnection()) }

    DisposableEffect(cm) {
        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                isOnline.value = true
            }
            override fun onLost(network: Network) {
                isOnline.value = false
            }
        }
        cm.registerDefaultNetworkCallback(callback)
        onDispose {
            cm.unregisterNetworkCallback(callback)
        }
    }

    content(isOnline.value)
}