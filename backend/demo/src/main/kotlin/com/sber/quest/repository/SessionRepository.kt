package com.sber.quest.repository

import com.sber.quest.models.session.Session
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SessionRepository: JpaRepository<Session, UUID> {
    fun getSessionByUserName(username: String): Session
}
