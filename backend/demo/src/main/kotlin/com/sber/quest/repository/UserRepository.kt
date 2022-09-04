package com.sber.quest.repository

import com.sber.quest.config.Authorities
import com.sber.quest.models.auth.Status
import com.sber.quest.models.auth.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username: String): User

    fun findAllByRoleAndStatus(role: Authorities, status: Status): List<User>
}