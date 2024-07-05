package com.teamsparta.seoulecommercemonitor.domain.store.controller.v1

import com.teamsparta.seoulecommercemonitor.domain.store.dto.CsvResponse
import com.teamsparta.seoulecommercemonitor.domain.store.service.v1.StoreService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.File

@RestController
@RequestMapping("/api/v1/stores")
class StoreController(private val storeService: StoreService) {

    @GetMapping("/filter")
    fun getAllStoresPage(
        @PathVariable businessName: String?,
        @RequestParam(value = "overallEvaluation", required = false) overallEvaluation: String?,
        @RequestParam(value = "businessStatus", required = false) businessStatus: String?,
        @RequestParam(value = "monitoringDate", required = false) monitoringDate: String?,
        @RequestParam(value = "csvId", required = false) csvId: Long?
    ): ResponseEntity<List<CsvResponse>> {
        return ResponseEntity.ok(
            storeService.getAllStoresPage(
                businessName,
                overallEvaluation,
                businessStatus,
                monitoringDate,
                csvId
            )
        )
    }

    @PostMapping("/collection", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun readCsv(@RequestParam("pathfile") multipartFile: MultipartFile) { //
        val file = File.createTempFile("csv", ".tmp") //임시파일 생성
        try {
            multipartFile.transferTo(file) //업로드한 multipartFile 저장
            storeService.readCsv(file)
        } finally {
            file.delete() //임시로 생성한 파일 삭제
        }


    }
}
