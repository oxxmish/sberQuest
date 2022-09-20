package com.sber.quest.models.auth

import com.sber.quest.config.Authorities
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="users_id_seq")
    @SequenceGenerator(name="users_id_seq", sequenceName="users_id_seq", allocationSize=1)
    val id: Long = 0,
    @Column(name = "username")
    val username: String,
    @Column(name = "password")
    var password: String,
    @Column(name = "first_name")
    val firstName: String,
    @Column(name = "middle_name")
    val middleName: String,
    @Column(name = "last_name")
    val lastName: String,
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    var status: Status = Status.WAITING_APPROVE,
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    val role: Authorities,
)
