package ninja.sakib.jsonq.ext

import com.eclipsesource.json.JsonArray

/**
 * := Coded with love by Sakib Sami on 5/21/18.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

fun JsonArray.whereGt(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    for (it in this) {
        if (it.isObject.not()) {
            continue
        }
        val obj = it.asObject().get(key)
        if (obj.isString && v is String && obj.asString() > v) {
            res.add(it.asObject())
        } else if (obj.isInt() && v is Int && obj.asInt() > v) {
            res.add(it.asObject())
        }
    }
    return res
}

fun JsonArray.whereEq(key: String, v: Any): MutableList<Any> {
    val res = mutableListOf<Any>()
    for (it in this) {
        if (it.isObject.not()) {
            continue
        }
        val obj = it.asObject().get(key)
        if (obj.isString && v is String && obj.asString() == v) {
            res.add(it.asObject())
        } else if (obj.isInt() && v is Int && obj.asInt() == v) {
            res.add(it.asObject())
        }
    }
    return res
}
