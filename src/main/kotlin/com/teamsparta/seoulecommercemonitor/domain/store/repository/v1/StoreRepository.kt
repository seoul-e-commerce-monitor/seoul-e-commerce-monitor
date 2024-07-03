package com.teamsparta.seoulecommercemonitor.domain.store.repository.v1

import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository : JpaRepository<Store, Long> {
    fun findByRating(rating: Int): List<Store>
    fun findByStatus(status: String): List<Store>
}