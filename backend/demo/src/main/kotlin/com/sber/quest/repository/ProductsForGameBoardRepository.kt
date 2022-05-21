package com.sber.quest.repository

import com.sber.quest.models.game_board.ProductsForGameBoards
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProductsForGameBoardRepository: JpaRepository<ProductsForGameBoards, Long> {
    @Query("select g" +
            " from ProductsForGameBoards g" +
            " where g.gameBoardId = :id")
    fun findAllByGameBoardId(@Param("id") id: Long): List<ProductsForGameBoards>
}
