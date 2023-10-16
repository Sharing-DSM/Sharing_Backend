package com.example.sharing.global.utils.openfeign

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HeaderConfiguration(
    @Value(value = "\${kakao.api-key}")
    val authorization: String
) {
    @Bean
    fun headerInterceptor(): RequestInterceptor{
        return RequestInterceptor { template: RequestTemplate ->
            template.header("Authorization", "KakaoAK $authorization") }
    }
}