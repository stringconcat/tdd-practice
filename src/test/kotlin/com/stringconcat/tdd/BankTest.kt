package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BankTest {
    @Test
    fun `4 CHF is 2 USD if rate 2 to 1`() {
        Bank().convert(Money.franc(4), Currency.USD) shouldBe (Money.dollar(2))
    }

    @Test
    fun `5 USD to USD = 5 USD`() {
        Bank().convert(Money.dollar(5), Currency.USD) shouldBe (Money.dollar(5))
    }

    @Test
    fun `2 USD + 4 CHF = 4 USD (if rate 2 to 1)`() {
        val dollars = Money.dollar(2)
        val francs = Money.franc(4)
        val expectedDollarsResult = Money.dollar(4)

        val bank = Bank();
        bank.sum(dollars, francs) shouldBe expectedDollarsResult
    }

    @Test
    fun `2 CHF + 2 CHF is 4 CHF`() {
        Bank().sum(Money.franc(2), Money.franc(2)) shouldBe Money.franc(4)
    }

    @Test
    fun `2 USD + 2 USD is 4 USD`() {
        Bank().sum(Money.dollar(2), Money.dollar(2)) shouldBe Money.dollar(4)
    }
}