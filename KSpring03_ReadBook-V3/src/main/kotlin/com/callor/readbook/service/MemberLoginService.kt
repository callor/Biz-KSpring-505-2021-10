package com.callor.readbook.service

import com.callor.readbook.config.logger
import com.callor.readbook.models.MemberVO
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 *
 * Security login Service 클래스
 * ( *UserDetailsService )
 *
 * Security login Service UserDetailsService 를 상속받는다
 *
 */
@Service
class MemberLoginService : UserDetailsService {

    // 가상의 member list 생성해 두기
    private val userList = listOf(
        MemberVO(username = "callor", password = "1234"),
        MemberVO(username = "callor88", password = "1234"),
        MemberVO(username = "callorok", password = "1234"),
    )


    // findByUserName(username) : UserDetails
    override fun loadUserByUsername(username: String): UserDetails {

        // 배열.find {] : 배열의 요소중 원하는 값이 담겨 있는가?
        // 담겨 있으면 해당 값을 return 하고, 없으면 null return
        val member: MemberVO? = userList.find { it.username == username }
        logger().debug("SERVICE {}", member.toString() )
        member ?: throw UsernameNotFoundException("사용자 ID 가 잘못되었습니다")


        logger().debug("SERVICE {}", member.toString() )

        return member

    }


}