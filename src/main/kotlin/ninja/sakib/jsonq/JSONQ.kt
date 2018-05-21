package ninja.sakib.jsonq

import com.eclipsesource.json.Json
import com.eclipsesource.json.JsonObject
import com.eclipsesource.json.JsonValue
import ninja.sakib.jsonq.ext.isDouble
import ninja.sakib.jsonq.ext.isFloat
import ninja.sakib.jsonq.ext.isInt
import java.io.FileInputStream
import java.io.InputStream
import java.io.InputStreamReader

/**
 * := Coded with love by Sakib Sami on 5/16/18.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class JSONQ {
    private var primaryObject: JsonObject? = null

    constructor(json: JsonObject) {
        this.primaryObject = json
    }

    constructor(jsonPath: String) {
        this.primaryObject = Json.parse(InputStreamReader(FileInputStream(jsonPath))).asObject()
    }

    constructor(jsonData: ByteArray) {
        this.primaryObject = Json.parse(String(jsonData)).asObject()
    }

    constructor(jsonInputStream: InputStream) {
        this.primaryObject = Json.parse(InputStreamReader(jsonInputStream)).asObject()
    }

    fun primaryObject(): JsonObject? {
        return primaryObject
    }

    fun find(key: String): JsonValue {
        return findInner(primaryObject!!, key)
    }

    private fun findInner(data: JsonValue, path: String): JsonValue {
        var t = data
        val keys = path.split(".")
        for (k in keys) {
            if (t.isArray) {
                t = t.asArray()[k.toInt()]
                continue
            }

            if (t.isString) {
                return t
            }
            if (t.isBoolean) {
                return t
            }
            if (t.isNumber && t.isInt()) {
                return t
            }
            if (t.isNumber && t.isFloat()) {
                return t
            }
            if (t.isNumber && t.isDouble()) {
                return t
            }

            if (t.isObject) {
                t = t.asObject().get(k)
            }
        }
        return t
    }
}
