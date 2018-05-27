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

fun JsonArray.get(): MutableList<Any> {
    return this.toMutableList()
}

fun JsonArray.whereGt(key: String, v: Any): JsonArray {
    val res = JsonArray()
    for (it in this) {
        if (it.isCountable(key, v, GREATER)) {
            res.add(it)
        }
    }
    return res
}

fun JsonArray.whereLt(key: String, v: Any): JsonArray {
    val res = JsonArray()
    for (it in this) {
        if (it.isCountable(key, v, LESS)) {
            res.add(it)
        }
    }
    return res
}

fun JsonArray.whereLe(key: String, v: Any): JsonArray {
    val res = JsonArray()
    for (it in this) {
        if (it.isCountable(key, v, LESS_EQ)) {
            res.add(it)
        }
    }
    return res
}

fun JsonArray.whereGe(key: String, v: Any): JsonArray {
    val res = JsonArray()
    for (it in this) {
        if (it.isCountable(key, v, GREATER_EQ)) {
            res.add(it)
        }
    }
    return res

}

fun JsonArray.whereEq(key: String, v: Any): JsonArray {
    val res = JsonArray()
    for (it in this) {
        if (it.isCountable(key, v, EQ)) {
            res.add(it)
        }
    }
    return res
}

fun JsonArray.hasSuffix(key: String, v: Any): JsonArray {
    val res = JsonArray()
    for (it in this) {
        if (it.findSuffix(key, v)) {
            res.add(it)
        }
    }
    return res
}

fun JsonArray.hasPrefix(key: String, v: Any): JsonArray {
    val res = JsonArray()
    for (it in this) {
        if (it.findPrefix(key, v)) {
            res.add(it)
        }
    }
    return res
}

fun JsonArray.contains(key: String, v: Any): JsonArray {
    val res = JsonArray()
    for (it in this) {
        if (it.findMatch(key, v)) {
            res.add(it)
        }
    }
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

fun JsonArray.avg(key: String): Double {
    return this.sum(key) / this.size()
}
