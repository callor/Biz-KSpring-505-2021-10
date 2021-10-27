package com.callor.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@SpringBootConfiguration
// spring Security 를 Custom 하겠다 라는 선언
@EnableWebSecurity
class SecurityConfig:WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {

        http.authorizeRequests()
            .mvcMatchers("/**") // 모든 request 에 대하여
            .anonymous()
            .mvcMatchers("/admin")
            .fullyAuthenticated()

    }
}