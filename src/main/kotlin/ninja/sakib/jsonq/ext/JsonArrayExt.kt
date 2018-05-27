package ninja.sakib.jsonq.ext

import com.eclipsesource.json.Json
import com.eclipsesource.json.JsonArray
import com.eclipsesource.json.JsonValue
import ninja.sakib.jsonq.utils.*

/**
 * := Coded with love by Sakib Sami on 5/21/18.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

fun JsonArray.whereGt(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.isCountable(v, key, GREATER) }
            .mapTo(res) { it -> it.asObject() }
    return res
}

fun JsonArray.whereLt(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.isCountable(v, key, LESS) }
            .mapTo(res) { it -> it.asObject() }
    return res
}

fun JsonArray.whereLe(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.isCountable(v, key, LESS_EQ) }
            .mapTo(res) { it -> it.asObject() }
    return res
}

fun JsonArray.whereGe(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.isCountable(v, key, GREATER_EQ) }
            .mapTo(res) { it -> it.asObject() }
    return res
}

fun JsonArray.whereEq(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.isCountable(v, key, EQ) }
            .mapTo(res) { it -> it.asObject() }
    return res
}

fun JsonArray.hasSuffix(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.findSuffix(v, key) }
            .mapTo(res) { it -> it.asObject() }
    return res
}

fun JsonArray.hasPrefix(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.findPrefix(v, key) }
            .mapTo(res) { it -> it.asObject() }
    return res
}

fun JsonArray.contains(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.findMatch(v, key) }
            .mapTo(res) { it -> it.asObject() }
    return res
}

fun JsonArray.sum(key: String): Double {
    var sum = 0.0
    this
            .forEach { it ->
                when {
                    it.isInt() -> sum += it.asInt()
                    it.isLong() -> sum += it.asLong()
                    it.isFloat() -> sum += it.asFloat()
                    it.isDouble() -> sum += it.asDouble()
                    it.isObject -> {
                        val nIt = it.asObject().get(key)
                        when {
                            nIt.isInt() -> sum += nIt.asInt()
                            nIt.isLong() -> sum += nIt.asLong()
                            nIt.isFloat() -> sum += nIt.asFloat()
                            nIt.isDouble() -> sum += nIt.asDouble()
                        }
                    }
                }
            }
    return sum
}

fun JsonArray.min(key: String): JsonValue {
    var min = Json.value(Double.MAX_VALUE)
    this
            .forEach { it ->
                when {
                    it.isObject -> {
                        val nIt = it.asObject().get(key)
                        when {
                            nIt.isInt() && nIt.asInt() < min.asInt() -> min = nIt
                            nIt.isLong() && nIt.asLong() < min.asLong() -> min = nIt
                            nIt.isFloat() && nIt.asFloat() < min.asFloat() -> min = nIt
                            nIt.isDouble() && nIt.asDouble() < min.asDouble() -> min = nIt
                        }
                    }
                    it.isInt() && it.asInt() < min.asInt() -> min = it
                    it.isLong() && it.asLong() < min.asLong() -> min = it
                    it.isFloat() && it.asFloat() < min.asFloat() -> min = it
                    it.isDouble() && it.asDouble() < min.asDouble() -> min = it
                }
            }
    return min
}

fun JsonArray.max(key: String): JsonValue {
    var max = Json.value(Double.MIN_VALUE)
    this
            .forEach { it ->
                when {
                    it.isObject -> {
                        val nIt = it.asObject().get(key)
                        when {
                            nIt.isInt() && nIt.asInt() > max.asInt() -> max = nIt
                            nIt.isLong() && nIt.asLong() > max.asLong() -> max = nIt
                            nIt.isFloat() && nIt.asFloat() > max.asFloat() -> max = nIt
                            nIt.isDouble() && nIt.asDouble() > max.asDouble() -> max = nIt
                        }
                    }
                    it.isInt() && it.asInt() > max.asInt() -> max = it
                    it.isLong() && it.asLong() > max.asLong() -> max = it
                    it.isFloat() && it.asFloat() > max.asFloat() -> max = it
                    it.isDouble() && it.asDouble() > max.asDouble() -> max = it
                }
            }
    return max
}

fun JsonArray.avg(key: String): JsonValue {
    return Json.value(this.sum(key) / this.size())
}
