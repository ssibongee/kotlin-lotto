package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TicketBuilderTest {
    @ParameterizedTest
    @ValueSource(ints = [5000, 5100, 5200, 5500, 5900, 5999])
    fun `howMuchTickets() 5천원이상 6천원 이하를 받으면 5장을 산다`(cost: Int) {
        assertThat(TicketBuilder.sellTickets(cost).size).isEqualTo(5)
    }
}