package com.teamsparta.seoulecommercemonitor.domain.infra.swagger

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun openAPI(): OpenAPI = OpenAPI()
        .info(
            Info()
                .title("Post API")
                .description("Post Schema")
                .version("1.0.0")
        )
}