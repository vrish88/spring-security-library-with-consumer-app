package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.header.writers.StaticHeadersWriter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
	override fun configure(http: HttpSecurity) {
		http.headers().addHeaderWriter(StaticHeadersWriter("X-App-Header", "set"))
	}
}

@RestController
class MyController {
	@GetMapping("/")
	fun ok() = "OK"
}
