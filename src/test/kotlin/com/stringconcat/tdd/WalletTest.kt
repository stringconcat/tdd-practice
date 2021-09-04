package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigDecimal

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WalletTest {

    private lateinit var exchangeRates: ExchangeRates

    @BeforeAll
    internal fun setUp() {
        exchangeRates = ExchangeRates()
        exchangeRates.addRate(Money.Currency.USD, Money.Currency.CHF, 2.toBigDecimal())
    }


    @Test
    fun `add 5 CHF to wallet and calculate than result should be 5 CHF`() {
        val wallet = Wallet(exchangeRates)
        wallet.add(Money(5.toBigDecimal(), Money.Currency.CHF))
        wallet.calculate(Money.Currency.CHF) shouldBe Money(5.toBigDecimal(), Money.Currency.CHF)
    }

    @Test
    fun `add 10 CHF add 5 USD to wallet and calculate than result should be 10 USD`() {
        val wallet = Wallet(exchangeRates)
        wallet.add(Money(10.toBigDecimal(), Money.Currency.CHF))
        wallet.add(Money(5.toBigDecimal(), Money.Currency.USD))
        wallet.calculate(Money.Currency.USD) shouldBe Money(10.toBigDecimal(), Money.Currency.USD)
    }

    @Test
    fun `add 10 CHF add 5 USD to wallet and calculate than result should be 20 CHF`() {
        val wallet = Wallet(exchangeRates)
        wallet.add(Money(10.toBigDecimal(), Money.Currency.CHF))
        wallet.add(Money(5.toBigDecimal(), Money.Currency.USD))
        wallet.calculate(Money.Currency.CHF) shouldBe Money(20.toBigDecimal(), Money.Currency.CHF)
    }

}