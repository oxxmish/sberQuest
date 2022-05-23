package com.sber.quest.models.questions

import com.fasterxml.jackson.annotation.JsonIgnore
import com.sber.quest.models.product.Product
import javax.persistence.*

@Entity
@Table(name = "questions")
data class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="questions_id_seq")
    @SequenceGenerator(name="questions_id_seq", sequenceName="questions_id_seq", allocationSize=1)
    val id: Long = 0,
    @Column(name = "text", length = 2000)
    var text: String,
    @Column(name = "short_text", length = 500)
    var shortText: String,
    @Column(name = "answer", length = 1500)
    var answer: String,
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    var questionType: QuestionType,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    var product: Product
) {
}
