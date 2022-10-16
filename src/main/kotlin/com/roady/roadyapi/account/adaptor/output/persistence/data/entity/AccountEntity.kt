package com.roady.roadyapi.account.adaptor.output.persistence.data.entity

import javax.persistence.*

@Entity
@Table(name = "account")
class AccountEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long,
    val nickname: String,
    val id: String,
    val encodedPassword: String
)