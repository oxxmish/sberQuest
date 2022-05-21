package com.sber.quest.repository

import com.sber.quest.models.questions.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository: JpaRepository<Question, Long>{
}
