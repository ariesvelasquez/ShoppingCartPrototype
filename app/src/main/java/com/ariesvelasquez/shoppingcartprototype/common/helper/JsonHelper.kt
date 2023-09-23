package com.ariesvelasquez.shoppingcartprototype.common.helper

import com.google.gson.JsonParseException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object JsonHelper {

    val json = Json {
        isLenient = false
        ignoreUnknownKeys = true
    }

    inline fun <reified T : Any> fromJson(value: String?): T {
        return try {
            json.decodeFromString(value!!)
        } catch (e: Exception) {
            throw JsonParseException("Unable to decode this value: $value")
        }
    }

    inline fun <reified T : Any> fromListJson(value: String?): MutableList<T> {
        return try {
            json.decodeFromString<List<T>>(value!!).toMutableList()
        } catch (e: Exception) {
            throw JsonParseException("Unable to decode this value: $value")
        }
    }

    inline fun <reified T : Any> toJson(value: List<T>?): String {
        return value?.let {
            json.encodeToString(value)
        } ?: ""
    }

    inline fun <reified T : Any> toJson(value: T?): String {
        return value?.let {
            json.encodeToString(value)
        } ?: ""
    }

}