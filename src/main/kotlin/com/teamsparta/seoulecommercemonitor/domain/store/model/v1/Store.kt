package com.teamsparta.seoulecommercemonitor.domain.store.model.v1

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "stores")
class Store(
    @Column(nullable = false)
    val companyName: String,

    @Column(nullable = false)
    val storeName: String,

    @Column(nullable = false)
    val rating: Int,

    @Column(nullable = false)
    val monitoringDate: LocalDate,

    @Column(nullable = false)
    val status: String,

    @Column(nullable = false)
    var evaluation: String
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
