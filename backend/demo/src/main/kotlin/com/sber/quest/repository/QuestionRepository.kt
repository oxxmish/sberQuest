package com.sber.quest.repository

import com.sber.quest.models.questions.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface QuestionRepository: JpaRepository<Question, Long>{
    @Query("select q from Question q" +
            " where q.id in (:ids)")
    fun findAllByIdOrderById(@Param("ids") ids: List<Long>): List<Question>
}
