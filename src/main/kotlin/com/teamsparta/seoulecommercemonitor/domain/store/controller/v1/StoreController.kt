package com.teamsparta.seoulecommercemonitor.domain.store.controller.v1

import com.teamsparta.seoulecommercemonitor.domain.store.dto.CsvResponse
import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.Store
import com.teamsparta.seoulecommercemonitor.domain.store.service.v1.StoreService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/stores")
class StoreController(private val storeService: StoreService) {

    @GetMapping("/filter")
    fun getAllStoresPage(
        @PageableDefault(size = 10, sort = ["monitoringDate"]) pageable: Pageable,
        @PathVariable businessName: String?,
        @RequestParam(value ="overallEvaluation", required = false) overallEvaluation:String?,
        @RequestParam(value = "businessStatus", required = false) businessStatus: String?,
        @RequestParam(value = "monitoringDate", required = false) monitoringDate: String?,
    ): ResponseEntity<Page<CsvResponse>> {
        return ResponseEntity.ok(storeService.getAllStoresPage(pageable,businessName, overallEvaluation, businessStatus, monitoringDate))
    }

    @GetMapping
    fun getAllStores(): List<Store> = storeService.getAllStores()

    @GetMapping("{rating}")
    fun getStoresByRating(@PathVariable rating: Int): List<Store> = storeService.getStoresByRating(rating)

    @GetMapping("{status}")
    fun getStoresByStatus(@PathVariable status: String): List<Store> = storeService.getStoresByStatus(status)

    @GetMapping("/{RatingAndStatus}")
    fun getStoresByRatingAndStatus(
        @RequestParam rating: Int,
        @RequestParam status: String
    ): List<Store> = storeService.getStoresByRatingAndStatus(rating, status)
}