package com.teamsparta.seoulecommercemonitor.domain.store.repository.v1

import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.Csv

interface CsvRepositoryCustom {
    fun findByStorePage(
        businessName: String?,
        overallEvaluation: String?,
        businessStatus: String?,
        monitoringDate: String?,
        csvId: Long?
    ): List<Csv>
}
