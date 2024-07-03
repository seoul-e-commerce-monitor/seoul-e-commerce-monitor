package com.teamsparta.seoulecommercemonitor.domain.store.model.v1

import com.teamsparta.seoulecommercemonitor.domain.store.dto.CsvResponse
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "seoul_online_shopping_mall_status")
class Csv(
    @Column(name = "business_name")
    val businessName: String,

    @Column(name = "overall_evaluation")
    var overallEvaluation: String,

    @Column(name = "business_status")
    var businessStatus: String,

    @Column(name = "monitoring_date")
    var monitoringDate: String

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun Csv.toCsvResponse(): CsvResponse = CsvResponse(
    id = id!!,
    businessName = businessName,
    overallEvaluation = overallEvaluation,
    businessStatus = businessStatus,
    monitoringDate = monitoringDate
)
