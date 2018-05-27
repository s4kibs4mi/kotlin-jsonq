package ninja.sakib.jsonq

import com.eclipsesource.json.JsonObject
import ninja.sakib.jsonq.ext.*
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
        val name = jsonq.find("users.2.location")
        Assert.assertEquals("First city name doesn't match", "Barishal", name.asString())
    }

    @Test
    fun findArrayObjTest() {
        val obj = jsonq.find("users.5.visits")
        Assert.assertEquals("First city name doesn't match", true, obj.isArray)
        println(obj)
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

    @Test
    fun WhereEqTest() {
        val res = jsonq.from("users.5.visits").whereEq("name", "Bandarbar")
        for (v in res) {
            println((v as JsonObject).toString())
        }
        println(res)
    }

    @Test
    fun WhereGtTest() {
        val res = jsonq.from("users").whereGt("id", 3)
        for (v in res) {
            println((v as JsonObject).toString())
        }
        println(res)
    }

    @Test
    fun WhereLtTest() {
        val res = jsonq.from("users").whereLt("id", 3)
        for (v in res) {
            println((v as JsonObject).toString())
        }
    }

    @Test
    fun WhereLeTest() {
        val res = jsonq.from("users").whereLe("id", 3)
        for (v in res) {
            println((v as JsonObject).toString())
        }
    }

    @Test
    fun WhereGeTest() {
        val res = jsonq.from("users").whereGe("id", 3)
        for (v in res) {
            println((v as JsonObject).toString())
        }
    }

    @Test
    fun WhereHasSuffix() {
        val res = jsonq.from("users").hasSuffix("name", "Sumi")
        for (v in res) {
            println((v as JsonObject).toString())
        }
        println(res.get())
    }

    @Test
    fun WhereHasPrefix() {
        val res = jsonq.from("users").hasPrefix("name", "Johura")
        for (v in res) {
            println((v as JsonObject).toString())
        }
    }

    @Test
    fun WhereContains() {
        val res = jsonq.from("users").contains("name", "Su")
        for (v in res) {
            println((v as JsonObject).toString())
        }
    }

    @Test
    fun QueryChain() {
        val res = jsonq.from("users")
        println(res.whereGe("id", 3))
        println(res.whereGe("id", 3).contains("location", "Barisal"))
        println(res.whereGe("id", 3).contains("name", "Is"))
    }

    @Test
    fun Sum() {
        val res = jsonq.from("products").sum("price")
        Assert.assertEquals(448000, res.toInt())
    }

    @Test
    fun Sum2() {
        val res = jsonq.from("arr").sum("")
        Assert.assertEquals(10, res.toInt())
    }

    @Test
    fun Min() {
        val res = jsonq.from("products").min("price")
        Assert.assertEquals(12000.2, res.asDouble(), 0.0)
    }

    @Test
    fun Max() {
        val res = jsonq.from("products").max("price")
        Assert.assertEquals(150000.1, res.asDouble(), 0.0)
    }

    @Test
    fun Avg() {
        val res = jsonq.from("arr").avg("")
        Assert.assertEquals(2.5, res, 0.0)
    }
}
