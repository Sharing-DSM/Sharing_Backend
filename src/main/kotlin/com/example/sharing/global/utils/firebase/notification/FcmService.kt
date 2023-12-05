package com.example.sharing.global.utils.firebase.notification

import com.example.sharing.global.utils.firebase.notification.exception.InvalidDeviceTokenLengthException
import com.google.firebase.messaging.ApnsConfig
import com.google.firebase.messaging.Aps
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import org.springframework.stereotype.Service

@Service
class FcmService {
    companion object {
        const val MAX_TOKEN_LENGTH = 163
    }

    fun sendMessage(token: String, title: String, content: String) {
        if (token.length >= MAX_TOKEN_LENGTH) {
            val message = Message.builder()
                .setToken(token)
                .setNotification(
                    Notification.builder()
                        .setTitle(title)
                        .setBody(content)
                        .build()
                )
                .setApnsConfig(
                    ApnsConfig.builder()
                        .setAps(
                            Aps.builder()
                                .setSound("default")
                                .build()
                        ).build()
                )
                .build()
            FirebaseMessaging.getInstance().sendAsync(message)
        } else {
            throw InvalidDeviceTokenLengthException.EXCEPTION
        }
    }
}