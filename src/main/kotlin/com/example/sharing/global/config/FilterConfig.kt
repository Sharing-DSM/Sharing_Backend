package com.example.sharing.global.config

import com.example.sharing.global.error.ExceptionFilter
import com.example.sharing.global.security.jwt.JwtTokenFilter
import com.example.sharing.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val objectMapper: ObjectMapper,
    private val jwtTokenProvider: JwtTokenProvider
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    override fun configure(builder: HttpSecurity) {
        val tokenFilter = JwtTokenFilter(jwtTokenProvider)
        val exceptionFilter = ExceptionFilter(objectMapper)

        builder.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(exceptionFilter, JwtTokenFilter::class.java)
    }
}