package com.example.sharing.global.config

import com.corundumstudio.socketio.SocketConfig
import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner
import com.example.sharing.global.socket.exception.SocketExceptionListener
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WebSocketConfig(
    @Value("\${socket.port}")
    private val port: Int
){
    @Bean
    fun socketServer(): SocketIOServer {
        val socketConfig = SocketConfig()
        val configuration = com.corundumstudio.socketio.Configuration()

        socketConfig.isReuseAddress = true

        configuration.port = port
        configuration.origin = "*"
        configuration.socketConfig = socketConfig
        configuration.exceptionListener = SocketExceptionListener()

        return SocketIOServer(configuration)
    }

    @Bean
    fun springAnnotationScanner(socketIOServer: SocketIOServer): SpringAnnotationScanner {
        return SpringAnnotationScanner(socketIOServer)
    }
}
