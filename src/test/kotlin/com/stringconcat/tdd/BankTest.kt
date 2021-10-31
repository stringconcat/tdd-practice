package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BankTest {
    val rates: Map<Pair<Currency, Currency>, Double> = mapOf(
        Pair(Pair(Currency.CHF,Currency.USD), 2.0),
        Pair(Pair(Currency.USD,Currency.CHF), 0.5)
    )
    
    @Test
    fun `4 CHF is 2 USD if rate 2 to 1`() {
        Bank(rates).convert(Money.franc(4), Currency.USD) shouldBe (Money.dollar(2))
    }

    @Test
    fun `5 USD to USD = 5 USD`() {
        Bank(rates).convert(Money.dollar(5), Currency.USD) shouldBe (Money.dollar(5))
    }

    @Test
    fun `2 USD + 4 CHF = 4 USD (if rate 2 to 1)`() {
        val dollars = Money.dollar(2)
        val francs = Money.franc(4)
        val expectedDollarsResult = Money.dollar(4)

        val bank = Bank(rates);
        bank.sum(dollars, francs) shouldBe expectedDollarsResult
    }

    @Test
    fun `2 CHF + 2 CHF is 4 CHF`() {
        Bank(rates).sum(Money.franc(2), Money.franc(2)) shouldBe Money.franc(4)
    }

    @Test
    fun `2 USD + 2 USD is 4 USD`() {
        Bank(rates).sum(Money.dollar(2), Money.dollar(2)) shouldBe Money.dollar(4)
    }

    @Test
    fun `2 CHF + 4 USD = 4 CHF (if rate 1 to 2)`() {
        val francs = Money.franc(2)
        val dollars = Money.dollar(4)
        val expectedFrancResult = Money.franc(10)

        val bank = Bank(rates);
        bank.convert(bank.sum(francs, dollars), Currency.CHF) shouldBe expectedFrancResult
    }

    @Test
    fun `2 USD + 4 CHF + 8 CHF + 2 USD = 10USD (if rate 2 to 1)`() {
        val bank = Bank(rates);

        bank.sum(
            Money.dollar(2),
            Money.franc(4),
            Money.franc(8),
            Money.dollar(2),
        ) shouldBe Money.dollar(10)
    }

    @Test
    fun `4 CHF + 8 CHF + 2 USD = 8USD (if rate 2 to 1)`() {
        val bank = Bank(rates);

        bank.sum(
            Money.franc(4),
            Money.franc(8),
            Money.dollar(2),
        ) shouldBe Money.dollar(8)
    }
}