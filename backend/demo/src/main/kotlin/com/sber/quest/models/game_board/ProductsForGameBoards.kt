package com.sber.quest.models.game_board

import javax.persistence.*

@Entity
@Table(name = "products_for_boards")
@IdClass(GameBoardProductIdClass::class)
class ProductsForGameBoards(
    @Id
    @Column(name = "game_board_id")
    var gameBoardId: Long,
    @Column(name = "product_id")
    @Id
    var productId: Long,
    @Column(name = "num_of_repeating")
    var numOfRepeating: Int
)
