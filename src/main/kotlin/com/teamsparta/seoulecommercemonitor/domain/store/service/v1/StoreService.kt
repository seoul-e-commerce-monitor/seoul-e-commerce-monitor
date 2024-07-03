package com.teamsparta.seoulecommercemonitor.domain.store.service.v1

import com.teamsparta.seoulecommercemonitor.domain.store.dto.CsvResponse
import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.toCsvResponse
import com.teamsparta.seoulecommercemonitor.domain.store.repository.v1.CsvRepository

import com.teamsparta.seoulecommercemonitor.exception.type.ModelNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class StoreService(

    private val csvRepository: CsvRepository
) {

    fun getAllStoresPage(
        pageable: Pageable,
        businessName: String?,
        overallEvaluation: String?,
        businessStatus: String?,
        monitoringDate: String?
    ): Page<CsvResponse> {
        if (overallEvaluation == null && businessStatus == null) throw ModelNotFoundException(" is null")
        else if (overallEvaluation != null && businessStatus != null) {
            csvRepository.findByStorePage(pageable, businessName, overallEvaluation, businessStatus, monitoringDate).map { it.toCsvResponse() }
        }
        return Page.empty()

    }
}
