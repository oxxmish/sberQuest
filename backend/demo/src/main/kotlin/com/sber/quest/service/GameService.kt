package com.sber.quest.service

import com.sber.quest.dto.AnswerDto
import com.sber.quest.models.session.QuestionType
import com.sber.quest.models.session.Session
import com.sber.quest.repository.QuestionRepository
import com.sber.quest.repository.SessionRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class GameService(
    val questionRepository: QuestionRepository,
    val sessionRepository: SessionRepository,
) {
    fun onChooseQuestion(questionId: Long, questionType: QuestionType) {
        val answer = questionRepository.getById(questionId).answer

        //TODO Доставать эти данные из контекста
        val session = Session(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), "host1", answer)
        sessionRepository.save(session)
    }

    fun getAnswerFromActiveSession(): AnswerDto {
        return AnswerDto(sessionRepository.getSessionByUserName("host1").currentAnswer)
    }
}
