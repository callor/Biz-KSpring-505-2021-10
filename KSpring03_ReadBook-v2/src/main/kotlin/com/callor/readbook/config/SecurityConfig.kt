package com.callor.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@SpringBootConfiguration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {

        http.authorizeRequests()
            .antMatchers("/member/mypage").authenticated()
            .antMatchers("/**").permitAll()
            .mvcMatchers("/**").anonymous()
//            .and()
//            .httpBasic()

        // pop up login 창 뜨우기
//        http.httpBasic()

        // 만약 인증이 필요한 페이지에 권한이 없이 접근하면
        // /member/login 으로 redirect 하라
        http.formLogin()
            .loginPage("/member/login").permitAll()

    }
}