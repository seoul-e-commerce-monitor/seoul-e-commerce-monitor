package com.teamsparta.seoulecommercemonitor.domain.store.repository.v1

import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.InSho
import org.springframework.data.jpa.repository.JpaRepository

interface ShopRepository : JpaRepository<InSho, Long>