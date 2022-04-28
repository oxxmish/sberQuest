package com.sber.quest.models

import com.sber.quest.models.questions.RegularQuestion
import javax.persistence.*

@Entity
@Table(name = "products")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(name = "name")
    var name: String,
    @Column(name ="colour")
    var colour: String,
    @OneToMany(mappedBy = "product")
    var question: List<RegularQuestion>
) {
}
