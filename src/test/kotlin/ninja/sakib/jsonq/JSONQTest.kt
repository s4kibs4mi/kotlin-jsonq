package ninja.sakib.jsonq

import org.junit.Assert
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
        val inputStream = Thread.currentThread().contextClassLoader.getResourceAsStream("data.json")
        jsonq = JSONQ(inputStream)
    }

    @Test
    fun readJSONFile() {
        val inputStream = Thread.currentThread().contextClassLoader.getResourceAsStream("data.json")
        jsonq = JSONQ(inputStream)
    }

    @Test
    fun findArrayElementTest() {
        val name = jsonq.find("cities.0.name")
        Assert.assertEquals("First city name doesn't match", "Barishal", name.asString())
    }

    @Test
    fun findArrayElementTest2() {
        val value = jsonq.find("arr.2")
        Assert.assertEquals("First city name doesn't match", 3, value.asInt())
    }

    @Test
    fun findJsonItemTest() {
        val name = jsonq.find("cities.0.name")
        Assert.assertEquals("First city name doesn't match", "Barishal", name.asString())
    }
}
