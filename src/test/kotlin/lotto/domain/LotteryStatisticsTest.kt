package lotto.domain

import lotto.fixture.LotteriesFixture
import lotto.fixture.LotteryFixture
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LotteryStatisticsTest {

    @Test
    fun `로또 통계를 생성할 수 있다`() {
        // given
        val lotteries = LotteriesFixture.LOTTERIES
        val winning = LotteryFixture.WINNING_LOTTERY

        // when
        val statistics = LotteryStatistics.of(lotteries, winning).values

        // then
        Assertions.assertAll(
            { org.assertj.core.api.Assertions.assertThat(statistics.containsKey(Ranking.THIRD)) },
            { org.assertj.core.api.Assertions.assertThat(statistics.containsKey(Ranking.FOURTH)) },
            { org.assertj.core.api.Assertions.assertThat(statistics[Ranking.THIRD]).isEqualTo(1) },
            { org.assertj.core.api.Assertions.assertThat(statistics[Ranking.FOURTH]).isEqualTo(1) },
            { org.assertj.core.api.Assertions.assertThat(statistics.size).isEqualTo(2) }
        )
    }

    @Test
    fun `총 당첨금을 계산할 수 있다`() {
        // given
        val lotteries = LotteriesFixture.LOTTERIES
        val winning = LotteryFixture.WINNING_LOTTERY
        val statistics = LotteryStatistics.of(lotteries, winning)

        // when
        val reward = statistics.calculate()

        // then
        org.assertj.core.api.Assertions.assertThat(reward)
            .isEqualTo(Money.of(Ranking.THIRD.reward.value.add(Ranking.FOURTH.reward.value)))
    }
}