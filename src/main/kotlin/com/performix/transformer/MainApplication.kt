package com.performix.transformer

import com.jayway.jsonpath.Configuration
import com.jayway.jsonpath.JsonPath

/**
 * Entry point of this application.
 */
fun main(args: Array<String>) {
    val transformer = JsonTransformer { inputJson ->
        // Example transformation
        val document = JsonPath.using(Configuration.defaultConfiguration()).parse(inputJson)

        // Applying JsonPath filters
        val filteredData = document.read<List<Map<String, Any>>>("$.[?(@.age > 25)]")

        // Convert filtered data back to JSON
        val outputJson = com.fasterxml.jackson.module.kotlin.jacksonObjectMapper().writeValueAsString(filteredData)
        outputJson
    }

    // Perform transformation and print output
    val result = transformer.transformInputJson("input.json")
    println(result)
}