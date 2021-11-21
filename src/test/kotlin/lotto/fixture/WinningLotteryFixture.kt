package lotto.fixture

import lotto.domain.WinningLottery

class WinningLotteryFixture {

    companion object {
        val WINNING_LOTTERY = WinningLottery.of(LotteryFixture.WINNING_LOTTERY, LottoNumberFixture.BONUS_BALL)
    }
}
