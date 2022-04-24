package patterns.coposite.general

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CompositeTest{

    @Test
    fun testComposite() {

        val container= Composite("1")

        container.add(Leaf("1"))
        container.add(Leaf("2"))
        container.add(Leaf("3"))

        assertThat(container.size==4)

        val container2 = Composite("2")
        container2.add(Leaf("4"))
        container2.add(Leaf("5"))
        container2.add(Leaf("6"))
        container2.add(Leaf("7"))

        container.add(container2)

        assertThat(container.size==9)




    }
}