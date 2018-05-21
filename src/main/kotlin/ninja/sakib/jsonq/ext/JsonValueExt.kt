package ninja.sakib.jsonq.ext

import com.eclipsesource.json.JsonValue
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
        e.printStackTrace()
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
