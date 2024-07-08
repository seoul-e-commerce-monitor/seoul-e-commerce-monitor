package com.teamsparta.seoulecommercemonitor.domain.store.repository.v1

import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.Csv
import org.springframework.data.jpa.repository.JpaRepository

interface CsvRepository : JpaRepository<Csv, Long>, CsvRepositoryCustom