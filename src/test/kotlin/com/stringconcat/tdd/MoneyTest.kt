package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class MoneyTest {

    @Test
    fun `5 USD has amount of 5`() {
        Money.dollar(5).amount shouldBe 5
    }

    @Test
    fun `10 Usd is 10 USD`() {
        Money.dollar(10) shouldBe Money.dollar(10)
    }

    @Test
    fun `10 Usd is not 5 USD`() {
        Money.dollar(10) shouldNotBe Money.dollar(5)
    }

    @Test
    fun `5 dollar multiply 2 is 10 USD`() {
        val ten = Money.dollar(5) * 2
        ten shouldBe Money.dollar(10)
    }

    @Test
    fun `5 USD is not 5 CHF`() {
        Money.dollar(5) shouldNotBe Money.franc(5)
    }

    @Test
    fun `5 CHF has amount of 5`() {
        Money.franc(5).amount shouldBe 5
    }

    @Test
    fun `10 CHF is 10 CHF`() {
        Money.franc(10) shouldBe Money.franc(10)
    }

    @Test
    fun `10 CHF is not 5 CHF`() {
        Money.franc(10) shouldNotBe Money.franc(5)
    }

    @Test
    fun `5 CHF multiply 2 is 10 CHF`() {
        val ten = Money.franc(5) * 2
        ten shouldBe Money.franc(10)
    }

    @Test
    fun `Dollar has currency of USD`() {
        Money.dollar(1).currency shouldBe Money.Currency.USD
    }

    @Test
    fun `Franc has currency of CHF`() {
        Money.franc(1).currency shouldBe Money.Currency.CHF
    }
}