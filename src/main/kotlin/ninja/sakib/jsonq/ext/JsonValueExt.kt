package ninja.sakib.jsonq.ext

import com.eclipsesource.json.JsonValue
import ninja.sakib.jsonq.utils.*
import java.lang.Exception

/**
 * := Coded with love by Sakib Sami on 5/21/18.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

fun JsonValue.isInt(): Boolean {
    try {
        this.asInt()
        return true
    } catch (e: Exception) {
    }
    return false
}

fun JsonValue.isFloat(): Boolean {
    try {
        this.asFloat()
        return true
    } catch (e: Exception) {

    }
    return false
}

fun JsonValue.isDouble(): Boolean {
    try {
        this.asDouble()
        return true
    } catch (e: Exception) {

    }
    return false
}

fun JsonValue.isLong(): Boolean {
    try {
        this.asLong()
        return true
    } catch (e: Exception) {

    }
    return false
}

fun JsonValue.isCountable(v: Any, key: String, operator: String): Boolean {
    val it = this
    when (operator) {
        EQ -> {
            if (it.isObject.not()) {
                return false
            }
            val obj = it.asObject().get(key)
            if (obj.isString && v is String && obj.asString() == v) {
                return true
            } else if (obj.isInt() && v is Int && obj.asInt() == v) {
                return true
            } else if (obj.isDouble() && v is Double && obj.asDouble() == v) {
                return true
            } else if (obj.isFloat() && v is Float && obj.asFloat() == v) {
                return true
            } else if (obj.isLong() && v is Long && obj.asLong() == v) {
                return true
            }
        }
        LESS_EQ -> {
            if (it.isObject.not()) {
                return false
            }
            val obj = it.asObject().get(key)
            if (obj.isString && v is String && obj.asString() <= v) {
                return true
            } else if (obj.isInt() && v is Int && obj.asInt() <= v) {
                return true
            } else if (obj.isDouble() && v is Double && obj.asDouble() <= v) {
                return true
            } else if (obj.isFloat() && v is Float && obj.asFloat() <= v) {
                return true
            } else if (obj.isLong() && v is Long && obj.asLong() <= v) {
                return true
            }
        }
        GREATER_EQ -> {
            if (it.isObject.not()) {
                return false
            }
            val obj = it.asObject().get(key)
            if (obj.isString && v is String && obj.asString() >= v) {
                return true
            } else if (obj.isInt() && v is Int && obj.asInt() >= v) {
                return true
            } else if (obj.isDouble() && v is Double && obj.asDouble() >= v) {
                return true
            } else if (obj.isFloat() && v is Float && obj.asFloat() >= v) {
                return true
            } else if (obj.isLong() && v is Long && obj.asLong() >= v) {
                return true
            }
        }
        GREATER -> {
            if (it.isObject.not()) {
                return false
            }
            val obj = it.asObject().get(key)
            if (obj.isString && v is String && obj.asString() > v) {
                return true
            } else if (obj.isInt() && v is Int && obj.asInt() > v) {
                return true
            } else if (obj.isDouble() && v is Double && obj.asDouble() > v) {
                return true
            } else if (obj.isFloat() && v is Float && obj.asFloat() > v) {
                return true
            } else if (obj.isLong() && v is Long && obj.asLong() > v) {
                return true
            }
        }
        LESS -> {
            if (it.isObject.not()) {
                return false
            }
            val obj = it.asObject().get(key)
            if (obj.isString && v is String && obj.asString() < v) {
                return true
            } else if (obj.isInt() && v is Int && obj.asInt() < v) {
                return true
            } else if (obj.isDouble() && v is Double && obj.asDouble() < v) {
                return true
            } else if (obj.isFloat() && v is Float && obj.asFloat() < v) {
                return true
            } else if (obj.isLong() && v is Long && obj.asLong() < v) {
                return true
            }
        }
        NOT_EQ -> {
            if (it.isObject.not()) {
                return false
            }
            val obj = it.asObject().get(key)
            if (obj.isString && v is String && obj.asString() != v) {
                return true
            } else if (obj.isInt() && v is Int && obj.asInt() != v) {
                return true
            } else if (obj.isDouble() && v is Double && obj.asDouble() != v) {
                return true
            } else if (obj.isFloat() && v is Float && obj.asFloat() != v) {
                return true
            } else if (obj.isLong() && v is Long && obj.asLong() != v) {
                return true
            }
        }
    }
    return false
}

fun JsonValue.findSuffix(v: Any, key: String): Boolean {
    val it = this
    if (it.isObject.not()) {
        return false
    }
    val obj = it.asObject().get(key)
    if (obj.isString && v is String) {
        return obj.asString().endsWith(v, true)
    }
    return false
}

fun JsonValue.findPrefix(v: Any, key: String): Boolean {
    val it = this
    if (it.isObject.not()) {
        return false
    }
    val obj = it.asObject().get(key)
    if (obj.isString && v is String) {
        return obj.asString().startsWith(v, true)
    }
    return false
}

fun JsonValue.findMatch(v: Any, key: String): Boolean {
    val it = this
    if (it.isObject.not()) {
        return false
    }
    val obj = it.asObject().get(key)
    if (obj.isString && v is String) {
        return obj.asString().contains(v, true)
    }
    return false
}
