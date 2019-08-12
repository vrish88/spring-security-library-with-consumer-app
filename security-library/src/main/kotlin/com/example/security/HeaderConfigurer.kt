package com.example.security

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer
import org.springframework.security.web.header.writers.StaticHeadersWriter

class HeaderConfigurer : AbstractHttpConfigurer<HeaderConfigurer, HttpSecurity>() {
    override fun init(http: HttpSecurity) {
        http.headers().addHeaderWriter(StaticHeadersWriter("X-Security-Header", "marked"))
    }
}