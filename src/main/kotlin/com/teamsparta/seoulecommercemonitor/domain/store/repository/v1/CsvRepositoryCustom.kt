package com.teamsparta.seoulecommercemonitor.domain.store.repository.v1

import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.Csv
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CsvRepositoryCustom {

    fun findByStorePage(pageable: Pageable, businessName:String? ,overallEvaluation: String?, businessStatus: String?, monitoringDate: String?): Page<Csv>
}