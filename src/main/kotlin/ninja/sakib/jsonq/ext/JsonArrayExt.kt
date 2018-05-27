package ninja.sakib.jsonq.ext

import com.eclipsesource.json.Json
import com.eclipsesource.json.JsonArray
import com.eclipsesource.json.JsonValue

/**
 * := Coded with love by Sakib Sami on 5/21/18.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

fun JsonArray.whereGt(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.isCountable(v, key, ninja.sakib.jsonq.GREATER) }
            .mapTo(res) { it -> it.asObject() }
    return res
}

fun JsonArray.whereLt(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.isCountable(v, key, ninja.sakib.jsonq.LESS) }
            .mapTo(res) { it -> it.asObject() }
    return res
}

fun JsonArray.whereLe(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.isCountable(v, key, ninja.sakib.jsonq.LESS_EQ) }
            .mapTo(res) { it -> it.asObject() }
    return res
}

fun JsonArray.whereGe(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.isCountable(v, key, ninja.sakib.jsonq.GREATER_EQ) }
            .mapTo(res) { it -> it.asObject() }
    return res
}

fun JsonArray.whereEq(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    this
            .filter { it -> it.isCountable(v, key, ninja.sakib.jsonq.EQ) }
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

fun JsonArray.sum(): Double {
    var sum = 0.0
    this
            .forEach { it ->
                when {
                    it.isInt() -> sum += it.asInt()
                    it.isLong() -> sum += it.asLong()
                    it.isFloat() -> sum += it.asFloat()
                    it.isDouble() -> sum += it.asDouble()
                }
            }
    return sum
}

fun JsonArray.min(): JsonValue {
    if (this.size() == 0)
        return Json.value(0)
    var min = this[0]
    for (v in this) {
        if (v.isInt() && min.isInt() && v.asInt() < min.asInt()) {
            min = v
        } else if (v.isLong() && min.isLong() && v.asLong() < min.asLong()) {
            min = v
        } else if (v.isFloat() && min.isFloat() && v.asFloat() < min.asFloat()) {
            min = v
        } else if (v.isDouble() && min.isDouble() && v.asDouble() < min.asDouble()) {
            min = v
        }
    }
    return min
}

fun JsonArray.max(): JsonValue {
    if (this.size() == 0)
        return Json.value(0)
    var max = this[this.size() - 1]
    for (v in this) {
        if (v.isInt() && max.isInt() && v.asInt() > max.asInt()) {
            max = v
        } else if (v.isLong() && max.isLong() && v.asLong() > max.asLong()) {
            max = v
        } else if (v.isFloat() && max.isFloat() && v.asFloat() > max.asFloat()) {
            max = v
        } else if (v.isDouble() && max.isDouble() && v.asDouble() > max.asDouble()) {
            max = v
        }
    }
    return max
}

fun JsonArray.avg(): JsonValue {
    return Json.value(this.sum() / this.size())
}
