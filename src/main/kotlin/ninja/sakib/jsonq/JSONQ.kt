package ninja.sakib.jsonq

import com.eclipsesource.json.Json
import com.eclipsesource.json.JsonArray
import com.eclipsesource.json.JsonObject
import com.eclipsesource.json.JsonValue
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

    fun find(key: String): JsonValue {
        return findValue(primaryObject!!, key)
    }

    private fun findValue(data: JsonValue, path: String): JsonValue {
        var t = data
        val keys = path.split(".")
        for (k in keys) {
            if (t.isArray) {
                t = t.asArray()[k.toInt()]
                continue
            }
            if (t.isObject) {
                t = t.asObject().get(k)
            }
        }
        return t
    }

    fun from(key: String): JsonArray {
        val data = findValue(primaryObject!!, key)
        val res = JsonArray()
        if (data.isArray.not()) {
            return res
        }
        return data.asArray()
    }

    fun JSONString(): String {
        return primaryObject.toString()
    }

    fun JSON(): JsonObject {
        return primaryObject!!
    }
}
