package com.example.demo

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@RunWith(SpringRunner::class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private lateinit var wac: WebApplicationContext
    private lateinit var mockMvc: MockMvc

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
			.apply<DefaultMockMvcBuilder>(springSecurity()).build()
    }

    @Test
    fun `loads security libs and app security configuration`() {
		mockMvc.perform(get("/"))
			.andExpect(header().string("X-App-Header", "set"))
			.andExpect(header().string("X-Security-Header", "marked"))
    }

}
