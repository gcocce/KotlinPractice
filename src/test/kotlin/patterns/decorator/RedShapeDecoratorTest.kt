package patterns.decorator

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RedShapeDecoratorTest {

    val figures: ArrayList<Shape> = ArrayList()

    @BeforeEach
    fun setUp() {
        figures.clear()
        figures.add(Rectangle())
        figures.add(Circle())
    }

    @AfterEach
    fun tearDown() {
        figures.clear()
    }

    @Test
    fun testSomethint(){
        //assertFalse(figures?.isEmpty() ?: false)
        assertFalse(figures.isEmpty())
    }

    @Test
    fun testOther(){
        assertTrue(figures.isNotEmpty())
    }

    @Test
    fun testCircleRedDecorator(){
        val redCircle: Shape  = RedShapeDecorator(Circle())
        assertTrue(redCircle.draw().equals("Circle Red"))
    }

    @Test
    fun testRectangleDecorator(){
        val redRectangle: Shape = RedShapeDecorator(Rectangle())
        assertTrue(redRectangle.draw().equals("Rectangle Red"))
    }

}