package com.sber.quest.service

import com.sber.quest.dto.AnswerAndStateDto
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
    fun onChooseQuestion(questionId: Long, questionType: QuestionType, state: String) {
        val answer = questionRepository.getById(questionId).answer

        //TODO Доставать эти данные из контекста
        val session = Session(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), "host1", answer, state)
        sessionRepository.save(session)
    }

    fun getAnswerAndStateFromActiveSession(): AnswerAndStateDto {
        val session = sessionRepository.getSessionByUserName("host1")
        return AnswerAndStateDto(answer = session.currentAnswer, state = session.state)
    }
}
