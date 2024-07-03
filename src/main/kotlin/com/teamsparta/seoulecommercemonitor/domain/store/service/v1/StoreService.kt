package com.teamsparta.seoulecommercemonitor.domain.store.service.v1

import com.teamsparta.seoulecommercemonitor.domain.store.dto.CsvResponse
import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.Store
import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.toCsvResponse
import com.teamsparta.seoulecommercemonitor.domain.store.repository.v1.CsvRepository
import com.teamsparta.seoulecommercemonitor.domain.store.repository.v1.StoreRepository
import com.teamsparta.seoulecommercemonitor.exception.type.ModelNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class StoreService(
    private val storeRepository: StoreRepository,
    private val csvRepository: CsvRepository
) {

    fun getAllStoresPage(pageable: Pageable,businessName:String?, overallEvaluation: String?, businessStatus: String?,monitoringDate:String?): Page<CsvResponse> {
        return csvRepository.findByStorePage(pageable,businessName ,overallEvaluation, businessStatus,monitoringDate).map { it.toCsvResponse() }
    }

    fun getAllStores(): List<Store> = storeRepository.findAll()

    fun getStoresByRating(rating: Int): List<Store> = storeRepository.findByRating(rating)

    fun getStoresByStatus(status: String): List<Store> = storeRepository.findByStatus(status)

    fun getStoresByRatingAndStatus(rating: Int?, status: String?): List<Store> {

        if (rating == null && status == null) throw ModelNotFoundException(" is null")
        else if (rating != null && status != null) {
            return storeRepository.findByRatingAndStatus(rating, status)
        }
        return emptyList()
    }
}