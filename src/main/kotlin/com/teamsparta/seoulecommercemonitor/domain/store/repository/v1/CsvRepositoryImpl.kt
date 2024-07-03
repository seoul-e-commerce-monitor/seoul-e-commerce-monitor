package com.teamsparta.seoulecommercemonitor.domain.store.repository.v1

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Expression
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.dsl.EntityPathBase
import com.querydsl.core.types.dsl.PathBuilder
import com.teamsparta.seoulecommercemonitor.domain.infra.querydsl.QueryDslSupport
import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.Csv
import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.QCsv
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import kotlin.contracts.contract

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
            .fetch()

        return content
    }


    private fun getOrderSpecifier(
        pageable: Pageable,
        path: EntityPathBase<*>
    )
        : Array<OrderSpecifier<*>> {
        val pathBuilder = PathBuilder(path.type, path.metadata)

        return pageable.sort.toList().map { order ->
            OrderSpecifier(
                if (order.isAscending) Order.ASC else Order.DESC,
                pathBuilder.get(order.property)
                    as Expression<Comparable<*>>
            )
        }.toTypedArray()
    }
}