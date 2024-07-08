package com.teamsparta.seoulecommercemonitor.domain.store.controller.v1

import com.teamsparta.seoulecommercemonitor.domain.store.service.v1.ShopService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/collection-openapi")
class ShopController(
    private val shopService: ShopService
) {
    @GetMapping
    fun accessData(): ResponseEntity<String> {
        return try {
            val result = shopService.accessData()
            ResponseEntity.ok(result)
        } catch (e: RuntimeException) {
            ResponseEntity.status(500).body("Error: ${e.message}")
        }
    }

    @GetMapping("/convert")
    fun convertData(): ResponseEntity<List<String>> {
        return try {
            val result = shopService.convertData()
            ResponseEntity.ok(result)
        } catch (e: RuntimeException) {
            ResponseEntity.status(500).body(emptyList())
        }
    }
}