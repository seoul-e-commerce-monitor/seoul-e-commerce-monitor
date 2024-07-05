package com.teamsparta.seoulecommercemonitor.domain.store.service.v1

import com.teamsparta.seoulecommercemonitor.domain.store.dto.CsvResponse
import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.Csv
import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.toCsvResponse
import com.teamsparta.seoulecommercemonitor.domain.store.repository.v1.CsvRepository
import com.teamsparta.seoulecommercemonitor.exception.type.ModelNotFoundException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service
import java.io.File


@Service
class StoreService(
    private val csvRepository: CsvRepository
) {
    private val logger = KotlinLogging.logger {}

    fun getAllStoresPage(

        businessName: String?,
        overallEvaluation: String?,
        businessStatus: String?,
        monitoringDate: String?,
        csvId: Long?

    ): List<CsvResponse> {
        if (overallEvaluation == null && businessStatus == null) throw ModelNotFoundException(" is null")
        else if (overallEvaluation != null && businessStatus != null) throw ModelNotFoundException(" ")
        return csvRepository.findByStorePage(businessName, overallEvaluation, businessStatus, monitoringDate, csvId)
            .map { it.toCsvResponse() }
    }



    //companion object {
        //const val EXPECTED_FILE_COUNT = 32 //32개의 필드
    //}

    fun readCsv(file: File) {

        // 파일 존재 여부 확인
        if (file.exists()) {
            println("파일이 존재합니다.")
        } else {
            println("파일이 존재하지 않습니다.")
        }

        val lines = file.readLines()
        var count = 0
        val csvSize = 100
        val csvList = mutableListOf<Csv>()

        lines.forEach { line ->

                val regex = ",".toRegex()
                val data = regex.split(line).map{ it.trim('\"') }

            //if (data.size != EXPECTED_FILE_COUNT) {
                //throw ModelNotFoundException("데이터 형식이 잘못되었습니다")
            //}


            val csv = Csv(
                businessName = data[0],
                mallName = data[1],
                domainName = data[2],
                phoneNumber = data[3],
                operatorEmail = data[4],
                salesRegistrationNumber = data[5],
                businessType = data[6],
                initialReportDate = (data[7]),
                companyAddress = data[8],
                businessStatus = data[9],
                overallEvaluation = data[10],
                businessInfoDisplayEvaluation = data[11],
                withdrawalRightEvaluation = data[12],
                paymentMethodEvaluation = data[13],
                termsOfServiceEvaluation = data[14],
                personalInfoSecurityEvaluation = data[15],
                mainProducts = data[16],
                withdrawalPossibility = data[17],
                requiredInitialScreenItems = data[18],
                paymentMethods = data[19],
                complianceWithTermsOfService = data[20],
                personalInfoHandlingPolicy = data[21],
                requestForAdditionalPersonalInfo = data[22],
                purchaseSafetyService = data[23],
                securityServerInstallation = data[24],
                certificationMark = data[25],
                expectedDeliveryDate = data[26],
                withdrawalShippingCostBurden = data[27],
                customerComplaintBoardOperation = data[28],
                membershipWithdrawalMethod = data[29],
                siteEstablishmentYear = data[30],
                monitoringDate = data[31],



            )


            csvList.add(csv)
            if (csvList.size == csvSize) {
                csvRepository.saveAll(csvList)
                count ++
                logger.info { "100개씩 insert ${count}번째 successful" }

                    csvList.clear()
            }
        }

        }
//    private fun parseLocalDate(dateString: String): LocalDate? {
//        if (dateString.isBlank() || dateString == "확인안됨") {
//            return null //빈 문자열 또는 "확인안됨" dateString이 빈 문자열이거나 "확인안됨"인 경우에는 null을 반환
//        }
//
//        return try {
//            LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
//        } catch (e: DateTimeParseException) {
//            logger.info {"날짜 형식이 올바르지 않습니다: $dateString"} //LocalDate.parse가 안먹힐 경우 예외처리 오류 메시지를 출력한 뒤 null을 반환
//            null
//        }
//    }



    }






