package com.performix.transformer

import com.jayway.jsonpath.Configuration
import com.jayway.jsonpath.Option
import java.nio.file.Files
import java.nio.file.Paths

class JsonTransformer(private val transformation: JsonTransformation) {

    private val config = Configuration.builder()
        .options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS)
        .build()

    fun transformInputJson(resourcePath: String): String {
        // Load JSON from resources
        val jsonContent = loadJsonFromResources(resourcePath)

        // Apply transformation
        return transformation.transform(jsonContent)
    }

    private fun loadJsonFromResources(resourcePath: String): String {
        val url = this::class.java.classLoader.getResource(resourcePath)
            ?: throw IllegalArgumentException("Resource not found: $resourcePath")
        return Files.readString(Paths.get(url.toURI()))
    }
}