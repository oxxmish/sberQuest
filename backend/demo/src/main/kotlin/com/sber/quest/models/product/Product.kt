package com.sber.quest.models.product

import com.sber.quest.models.questions.Question
import javax.persistence.*

@Entity
@Table(name = "products")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="products_id_seq")
    @SequenceGenerator(name="products_id_seq", sequenceName="products_id_seq", allocationSize=1)
    var id: Long = 0,
    @Column(name = "name")
    var name: String,
    @Column(name ="colour")
    var colour: String,
    @OneToMany(mappedBy = "product")
    var questions: Set<Question>? = emptySet()
) {
}
