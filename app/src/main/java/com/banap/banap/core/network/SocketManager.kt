package com.banap.banap.core.network

import android.util.Log
import com.banap.banap.common.Constants.WEB_SOCKET_URL
import dev.icerock.moko.socket.Socket
import dev.icerock.moko.socket.SocketEvent
import dev.icerock.moko.socket.SocketOptions

class SocketManager (
    private val userID: String,
    private val token: String
) {
    private val socket = Socket(
        endpoint = WEB_SOCKET_URL,
        config = SocketOptions(
            queryParams = mapOf(
                "UserID" to userID,
                "token" to token
            ),
            transport = SocketOptions.Transport.WEBSOCKET
        )
    ) {
        on(SocketEvent.Connect) {
            Log.d("CONNECT", "Conectado...")
        }

        on(SocketEvent.Connecting) {
            Log.d("CONNECTING", "Conectando...")
        }

        on(SocketEvent.Error) {
            Log.d("ERROR", it.toString())
        }

        on("message") { data ->
            println(data)
        }
    }

    init {
        connect()
    }

    private fun connect() {
        socket.connect()
    }
}