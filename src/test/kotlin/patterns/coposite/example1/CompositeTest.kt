package patterns.coposite.example1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class CompositeTest {

    @Test
    fun testComposite() {
        val pc = PersonalComputer()
            .add(Processor())
            .add(HardDrive())
            .add(Memory())

        println(pc.price)

        assertThat(pc.name).isEqualTo("PC")
        assertThat(pc.price).isEqualTo(1600)
    }
}
