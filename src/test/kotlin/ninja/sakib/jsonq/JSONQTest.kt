package ninja.sakib.jsonq

import org.junit.Before
import org.junit.Test

/**
 * := Coded with love by Sakib Sami on 5/16/18.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class JSONQTest {
    private lateinit var jsonq: JSONQ

    @Before
    fun setup() {

    }

    @Test
    fun readJSONFile() {
        val inputStream = Thread.currentThread().contextClassLoader.getResourceAsStream("data.json")
        jsonq = JSONQ(inputStream)
    }
}
