package com.teamsparta.seoulecommercemonitor.domain.store.dto

data class CsvResponse(
    val id: Long,
    val businessName: String,
    val overallEvaluation: String,
    val businessStatus: String,
    val monitoringDate: String
)
