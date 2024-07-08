package com.teamsparta.seoulecommercemonitor.domain.store.repository.v1

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.teamsparta.seoulecommercemonitor.domain.infra.querydsl.v1.QueryDslSupport
import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.Csv
import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.QCsv
import org.springframework.stereotype.Repository

@Repository
class CsvRepositoryImpl : QueryDslSupport(), CsvRepositoryCustom {

    private val csv = QCsv.csv

    override fun findByStorePage(
        businessName: String?,
        overallEvaluation: String?,
        businessStatus: String?,
        monitoringDate: String?,
        csvId: Long?
    ): List<Csv> {

        val whereClause = BooleanBuilder()
        businessName?.let { whereClause.and(csv.businessName.like("%$businessName%")) }
        overallEvaluation?.let { whereClause.and(csv.overallEvaluation.like("%$overallEvaluation%")) }
        businessStatus?.let { whereClause.and(csv.businessStatus.like("%$businessStatus%")) }
        monitoringDate?.let { whereClause.and(csv.monitoringDate.like("%$monitoringDate%")) }
        csvId?.let { whereClause.and(csv.id.gt(it)) }

        val content = queryFactory
            .selectFrom(csv)
            .where(whereClause)
            .limit(15)
            .orderBy(getOrderSpecifier())
            .fetch()

        return content
    }

    private fun getOrderSpecifier(): OrderSpecifier<*> {
        return OrderSpecifier(Order.DESC, csv.monitoringDate)
    }
}