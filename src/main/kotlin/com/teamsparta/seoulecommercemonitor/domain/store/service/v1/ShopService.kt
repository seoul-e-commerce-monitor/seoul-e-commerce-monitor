package com.teamsparta.seoulecommercemonitor.domain.store.service.v1

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.teamsparta.seoulecommercemonitor.domain.store.dto.Shop
import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.InSho
import com.teamsparta.seoulecommercemonitor.domain.store.repository.v1.ShopRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@Service
class ShopService(
    private val shopRepository: ShopRepository,
) {
    fun accessData(): String? {
        val restClient = RestClient.create()
        val data = restClient.get()
            .uri("http://openapi.seoul.go.kr:8088/564a6472576b626835334342427559/json/ServiceInternetShopInfo/1/100/")
            .retrieve()
            .body<String>()

        return data
    }

    fun convertData(): List<String> {
        val restClient = RestClient.create()
        val data = restClient.get()
            .uri("http://openapi.seoul.go.kr:8088/564a6472576b626835334342427559/json/ServiceInternetShopInfo/1/100/")
            .retrieve()
            .body<String>()

        val shopList = JsonParser.parseString(data).asJsonObject
            .getAsJsonObject("ServiceInternetShopInfo")
            .getAsJsonArray("row")
            .map { it.asJsonObject }
            .map { Gson().fromJson(it, Shop::class.java) }

        shopList.forEach {
            shopRepository.save(
                InSho(
                    mallName = it.SHOP_NAME,
                    domainName = it.DOMAIN_NAME,
                    phoneNumber = it.TEL,
                    operatorEmail = it.EMAIL
                )
            )
        }
        return shopList.map { it.toString() }
    }
}