package com.sber.quest.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile("prod")
class SecurityConfig(private val userDetailsService: UserDetailsService) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf { disable() }
            cors { disable() }
            authorizeRequests {
                authorize("/auth/login", permitAll)
                authorize("/auth/registration", permitAll)
                authorize(
                    "/**", hasAnyAuthority(
                        Authorities.ROLE_PLAYER.name,
                        Authorities.ROLE_LEADER.name,
                        Authorities.ROLE_ADMIN.name
                    )
                )
            }
            formLogin {
                loginPage = "/auth/login"
                defaultSuccessUrl("/#/fields", alwaysUse = false)
            }
            logout { logoutUrl = "/auth/logout" }
        }
        return http.build()
    }

    @Bean
    protected fun daoAuthenticationProvider(): DaoAuthenticationProvider {
        val daoAuthenticationProvider = DaoAuthenticationProvider()
        daoAuthenticationProvider.setPasswordEncoder(BCryptPasswordEncoder(12))
        daoAuthenticationProvider.setUserDetailsService(userDetailsService)
        return daoAuthenticationProvider
    }
}
