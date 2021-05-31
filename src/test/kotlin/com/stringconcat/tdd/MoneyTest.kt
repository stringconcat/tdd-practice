package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class MoneyTest {
    @Test
    fun `5 USD is 5 USD`() {
        Money.dollar(5) shouldBe Money.dollar(5)
    }

    @Test
    fun `5 USD is NOT 2 USD`() {
        Money.dollar(5) shouldNotBe Money.dollar(2)
    }

    @Test
    fun `5 USD multiplay 2 is 10 USD`() {
        Money.dollar(5) * 2 shouldBe Money.dollar(10)
    }

    @Test
    fun `5 USD multiplay 3 is 15 USD`() {
        Money.dollar(5) * 3 shouldBe Money.dollar(15)
    }

    @Test
    fun `5 CHF is 5 CHF`() {
        Money.franc(5) shouldBe Money.franc(5)
    }

    @Test
    fun `5 CHF is NOT 2 CHF`() {
        Money.franc(5) shouldNotBe Money.franc(2)
    }

    @Test
    fun `5 CHF multiplay 2 is 10 CHF`() {
        Money.franc(5) * 2 shouldBe Money.franc(10)
    }

    @Test
    fun `5 CHF multiplay 3 is 15 CHF`() {
        Money.franc(5) * 3 shouldBe Money.franc(15)
    }

    @Test
    fun `5 CHF + 5 CHF is 10 CHF`() {
        Money.franc(5) + Money.franc(5) shouldBe Wallet(Money.franc(10))
    }

    @Test
    fun `5 USD + 5 USD is 10 USD`() {
        Money.dollar(5) + Money.dollar(5) shouldBe Wallet(Money.dollar(10))
    }

    @Test
    fun `5 USD is not 5 CHF`() {
        Money.dollar(5) shouldNotBe Money.franc(5)
    }

    @Test
    fun `2 CHF + 4 USD is wallet that contains 2 CHF and 4 USD`() {
        Money.franc(2) + Money.dollar(4) shouldBe Wallet(Money.franc(2), Money.dollar(4) )
    }
}