package com.teamsparta.seoulecommercemonitor.domain.store.service.v1

import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.Store
import com.teamsparta.seoulecommercemonitor.domain.store.repository.v1.StoreRepository
import org.springframework.stereotype.Service

@Service
class StoreService(private val storeRepository: StoreRepository) {

    fun getAllStores(): List<Store> = storeRepository.findAll()

    fun getStoresByRating(rating: Int): List<Store> = storeRepository.findByRating(rating)

    fun getStoresByStatus(status: String): List<Store> = storeRepository.findByStatus(status)

    fun getStoresByRatingAndStatus(rating: Int, status: String): List<Store> {
        return storeRepository.findAll()
            .filter { it.rating == rating && it.status == status }
            .sortedByDescending { it.monitoringDate }
            .take(10)
    }
}