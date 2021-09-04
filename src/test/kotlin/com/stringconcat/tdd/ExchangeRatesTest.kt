package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.RoundingMode

internal class ExchangeRatesTest {

    @Test
    fun `add USD CHF`() {
        val exchangeRates = ExchangeRates()
        val rate = 2.toBigDecimal().setScale(4)
        exchangeRates.addRate(Money.Currency.CHF, Money.Currency.USD, rate);
        exchangeRates.getRate(Money.Currency.CHF, Money.Currency.USD) shouldBe rate
        exchangeRates.getRate(Money.Currency.USD, Money.Currency.CHF) shouldBe 1.toBigDecimal()
            .divide(rate, 4, RoundingMode.HALF_EVEN)
    }

    @Test
    fun `fail while getting USD CHF`() {
        val exchangeRates = ExchangeRates()
        val rate = 2.toBigDecimal().setScale(4)
        assertThrows(ExchangeRateNotFound::class.java) {
            exchangeRates.getRate(
                Money.Currency.CHF,
                Money.Currency.USD
            )
        }

    }
}