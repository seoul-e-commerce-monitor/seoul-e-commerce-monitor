package com.teamsparta.seoulecommercemonitor.exception.type

data class ModelNotFoundException(
    val modelName: String
) : RuntimeException ("Model $modelName not found")

