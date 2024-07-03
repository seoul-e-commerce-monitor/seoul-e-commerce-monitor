package com.teamsparta.seoulecommercemonitor.domain.store.controller.v1

import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.Store
import com.teamsparta.seoulecommercemonitor.domain.store.service.v1.StoreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/stores")
class StoreController(private val storeService: StoreService) {

    @GetMapping
    fun getAllStores(): List<Store> = storeService.getAllStores()

    @GetMapping("/filter/{rating}")
    fun getStoresByRating(@PathVariable rating: Int): List<Store> = storeService.getStoresByRating(rating)

    @GetMapping("/filter/{status}")
    fun getStoresByStatus(@PathVariable status: String): List<Store> = storeService.getStoresByStatus(status)

    @GetMapping("/filter")
    fun getStoresByRatingAndStatus(
        @RequestParam rating: Int,
        @RequestParam status: String
    ): List<Store> = storeService.getStoresByRatingAndStatus(rating, status)
}
