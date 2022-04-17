package patterns.decorator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ExtendedShapeTest{

    @Test
    fun testExtendedShape(){
        val circleExtended = ExtendedShape(Circle())

        assertTrue(circleExtended.draw().equals("Circle Extended"))
    }
}

