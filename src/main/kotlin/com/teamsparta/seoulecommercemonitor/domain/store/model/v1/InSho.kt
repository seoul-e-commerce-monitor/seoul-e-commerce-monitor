package com.teamsparta.seoulecommercemonitor.domain.store.model.v1

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "internet_shopping_malls")
data class InSho(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val mallName: String,

    @Column
    val domainName: String,

    @Column
    val phoneNumber: String,

    @Column
    val operatorEmail: String,
)
