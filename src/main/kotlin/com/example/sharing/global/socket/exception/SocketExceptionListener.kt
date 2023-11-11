package com.example.sharing.global.socket.exception

import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.listener.ExceptionListener
import com.example.sharing.global.error.ErrorResponse
import com.example.sharing.global.error.exception.ErrorCode
import com.example.sharing.global.error.exception.SharingException
import io.netty.channel.ChannelHandlerContext
import java.util.*

class SocketExceptionListener : ExceptionListener {
    override fun onEventException(e: Exception, args: MutableList<Any>?, client: SocketIOClient) {
        runException(e, client)
    }

    override fun onDisconnectException(e: Exception, client: SocketIOClient) {
        runException(e, client)
    }

    override fun onConnectException(e: Exception, client: SocketIOClient) {
        runException(e, client)
        client.disconnect()
    }

    override fun onPingException(e: Exception, client: SocketIOClient) {
        runException(e, client)
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext?, e: Throwable?): Boolean {
        return false
    }

    private fun runException(e: Exception, client: SocketIOClient) {
        println(e.cause)
        println(e.message)
        println(e.javaClass)
        println(e.cause?.message)

        Arrays.stream(e.cause?.stackTrace).forEach { println() }

        val errorCode = if (e.cause is SharingException) {
            (e.cause as SharingException).errorCode
        } else {
            ErrorCode.INTERNAL_SERVER_ERROR
        }

        val message = ErrorResponse(errorCode.status, errorCode.message)

        client.sendEvent("error", message)
    }
}