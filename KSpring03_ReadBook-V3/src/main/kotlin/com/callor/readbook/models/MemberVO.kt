package com.callor.readbook

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * Spring Security 에서 login 한 사용자(User, Member) 정보를
 * 담아둘 VO 클래스
 */
data class MemberVO(
    private var username:String,
    private var password:String,
    private var enabled:Boolean = true,
    private var credentialNonExpired:Boolean = true,
    private var accountNonExpired:Boolean = true,
    private var accountNotLocked:Boolean = true,
    private var authorities:Collection<GrantedAuthority> = setOf()
) : UserDetails {
    override fun getUsername(): String = username
    override fun getPassword(): String = password

    override fun isEnabled(): Boolean = enabled
    override fun isAccountNonExpired(): Boolean = accountNonExpired
    override fun isCredentialsNonExpired(): Boolean = credentialNonExpired
    override fun isAccountNonLocked(): Boolean = accountNotLocked

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = authorities
    fun setAuthorities(authorities: Collection<GrantedAuthority>) {
        this.authorities = authorities
    }

}
