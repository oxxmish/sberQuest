package com.sber.quest.repository

import com.sber.quest.models.questions.RegularQuestion
import org.springframework.data.jpa.repository.JpaRepository

interface RegularQuestionRepository: JpaRepository<RegularQuestion, Long>{
}
