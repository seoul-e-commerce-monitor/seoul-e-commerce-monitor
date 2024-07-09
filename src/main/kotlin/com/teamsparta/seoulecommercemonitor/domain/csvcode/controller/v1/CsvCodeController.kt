package com.teamsparta.seoulecommercemonitor.domain.csvcode.controller.v1

import com.teamsparta.seoulecommercemonitor.domain.csvcode.service.v1.CsvCodeService
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