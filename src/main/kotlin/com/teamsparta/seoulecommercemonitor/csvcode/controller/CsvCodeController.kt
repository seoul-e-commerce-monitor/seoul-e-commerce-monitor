package com.teamsparta.seoulecommercemonitor.csvcode.controller

import com.teamsparta.seoulecommercemonitor.csvcode.service.CsvCodeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/collection")
class CsvCodeController(
    private val csvCodeService: CsvCodeService,
) {
    @PostMapping
    fun readFromCsv(): ResponseEntity<Unit> {
        return ResponseEntity.ok(csvCodeService.readFromCsv())
    }
    
}