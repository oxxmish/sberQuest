package com.sber.quest.service

import com.sber.quest.dto.AnswerAndStateDto
import com.sber.quest.dto.GameDto
import com.sber.quest.mappers.toDto
import com.sber.quest.mappers.toEntity
import com.sber.quest.models.auth.SecurityUser
import com.sber.quest.models.game.GameEntity
import com.sber.quest.models.session.QuestionType
import com.sber.quest.models.session.Session
import com.sber.quest.repository.GameEntityRepository
import com.sber.quest.repository.QuestionRepository
import com.sber.quest.repository.SessionRepository
import com.sber.quest.repository.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.util.*

@Service
class GameService(
    private val questionRepository: QuestionRepository,
    private val sessionRepository: SessionRepository,
    private val userRepository: UserRepository,
    private val gameEntityRepository: GameEntityRepository,
) {
    fun get(id: Long): GameDto {
        val game =
            gameEntityRepository.findById(id).orElseThrow { RuntimeException("Game with id = $id doesn't exist") }
        return game.toDto()
    }

    fun getAll(): MutableList<GameEntity> =
        gameEntityRepository.findAll()


    fun create(rq: GameDto): GameDto {
        val currentPrincipal = SecurityContextHolder.getContext().authentication.principal as SecurityUser
        val currentUser = userRepository.findByUsername(currentPrincipal.username)
        val game = rq.toEntity(mutableListOf(currentUser))
        return gameEntityRepository.save(game).toDto()
    }

    fun update(rq: GameDto): GameDto {
        val leaders = userRepository.findAllById(rq.leaderIds!!)
        val updatedGame = rq.toEntity(leaders)
        return gameEntityRepository.save(updatedGame).toDto()
    }

    fun delete(id: Long) {
        gameEntityRepository.deleteById(id)
    }

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
