package com.example.sharing

import com.example.sharing.global.security.jwt.JwtProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableConfigurationProperties(JwtProperties::class)
@SpringBootApplication
class SharingApplication

fun main(args: Array<String>) {
    runApplication<SharingApplication>(*args)
}
