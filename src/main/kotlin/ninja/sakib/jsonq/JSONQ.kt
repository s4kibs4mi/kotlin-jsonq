package ninja.sakib.jsonq

import com.eclipsesource.json.Json
import com.eclipsesource.json.JsonObject
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

    constructor(jsonInputStream: InputStream) {
        this.primaryObject = Json.parse(InputStreamReader(jsonInputStream)).asObject()
    }
}
