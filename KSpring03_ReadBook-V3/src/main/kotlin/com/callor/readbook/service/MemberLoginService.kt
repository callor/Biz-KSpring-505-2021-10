package com.callor.readbook.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

/**
 * Security login Service 클래스
 * ( *UserDetailsService )
 *
 * Security login Service UserDetailsService 를 상속받는다
 */
class MemberLoginService : UserDetailsService{

    val userList = listOf(

    )


    // findByUserName(username) : UserDetails
    override fun loadUserByUsername(username: String): UserDetails {
        TODO("Not yet implemented")
    }


}