package com.performix.transformer

/**
 * Interface for transforming input JSON string to output JSON string by applying JSON Path rules.
 */
fun interface JsonTransformation {

    /**
     * Transforms the JSON.
     */
    fun transform(json: String): String
}