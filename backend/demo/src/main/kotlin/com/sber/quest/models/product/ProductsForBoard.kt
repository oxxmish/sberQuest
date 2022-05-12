package com.sber.quest.models.product

import com.sber.quest.models.questions.RegularQuestion
import javax.persistence.*

@Entity
@Table(name = "products_for_board")
class ProductsForBoard(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="product_for_board_id_seq")
    @SequenceGenerator(name="product_for_board_id_seq", sequenceName="product_for_board_id_seq", allocationSize=1)
    var id: Long = 0,
    @OneToOne
    var product: Product,
    @OneToMany
    @JoinColumn(name = "question_id")
    var questions: Set<RegularQuestion> = emptySet()
) {
}
