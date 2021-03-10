package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun `로또의 당첨된 번호를 구한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val result = lotto.findMatchedNums(Lotto(listOf(9, 8, 7, 3, 2, 1)))
        val expect = listOf(LottoNum.of(3), LottoNum.of(2), LottoNum.of(1))
        assertThat(result).containsExactlyInAnyOrderElementsOf(expect)
    }
}