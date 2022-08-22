package com.sber.quest.models.auth

import com.sber.quest.config.Authorities
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class SecurityUser(
    private val username: String,
    private val password: String,
    private val role: Authorities,
    private val status: Status
) :
    UserDetails {

    companion object {
        fun fromUser(user: User) = SecurityUser(
            username = user.username,
            password = user.password,
            role = user.role,
            status = user.status
        )
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        mutableListOf(SimpleGrantedAuthority(role.name))

    override fun getPassword(): String = password

    override fun getUsername(): String = username

    override fun isAccountNonExpired(): Boolean = status == Status.ACTIVE

    override fun isAccountNonLocked(): Boolean = status == Status.ACTIVE

    override fun isCredentialsNonExpired(): Boolean = status == Status.ACTIVE

    override fun isEnabled(): Boolean = status == Status.ACTIVE
}