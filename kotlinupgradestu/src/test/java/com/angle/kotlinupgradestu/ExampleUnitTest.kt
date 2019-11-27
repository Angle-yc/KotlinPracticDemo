package com.angle.kotlinupgradestu

import org.junit.Test
import java.beans.PropertyChangeListener

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val f = Foo("Dmitry",35,2500)
        f.addPropertyChangeListener(
                PropertyChangeListener { evt ->
                    println("Property ${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}")
                }
        )

        f.age = 36

        f.salary = 3000

        f.salary = 5000
    }


    val log = listOf(
            "123",
            "456",
            "486",
            "123",
            "123"
    )
    val  average = log
            .filter { it == "123"}
            .map { it }


    @Test
    fun filterTest(){
        print(average)
    }

}
