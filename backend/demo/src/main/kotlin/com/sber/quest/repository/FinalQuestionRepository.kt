package com.sber.quest.repository

import com.sber.quest.models.questions.FinalQuestion
import org.springframework.data.jpa.repository.JpaRepository

interface FinalQuestionRepository: JpaRepository<FinalQuestion, Long> {
}
