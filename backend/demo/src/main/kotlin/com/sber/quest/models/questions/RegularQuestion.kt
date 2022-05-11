package com.sber.quest.models.questions

import com.fasterxml.jackson.annotation.JsonIgnore
import com.sber.quest.models.product.Product
import javax.persistence.*

@Entity
@Table(name = "regular_questions")
data class RegularQuestion(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="regular_questions_id_seq")
    @SequenceGenerator(name="regular_questions_id_seq", sequenceName="regular_questions_id_seq", allocationSize=1)
    val id: Long = 0,
    @Column(name = "text", length = 2000)
    var text: String,
    @Column(name = "answer", length = 1500)
    var answer: String,
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    var questionType: QuestionType,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    var product: Product?
) {
}
