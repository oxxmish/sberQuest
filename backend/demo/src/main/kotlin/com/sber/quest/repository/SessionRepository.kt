package com.sber.quest.repository

import com.sber.quest.models.session.Session
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SessionRepository: JpaRepository<Session, UUID> {
    fun getSessionByUserName(username: String): Session
}
