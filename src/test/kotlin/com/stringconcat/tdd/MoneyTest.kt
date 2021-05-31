package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class MoneyTest {

    @Test
    fun `5 dollars is 5 dollars`() {
        Money.dollar(5) shouldBe Money.dollar(5)
    }

    @Test
    fun `5 dollars is NOT 2 dollars`() {
        Money.dollar(5) shouldNotBe Money.dollar(2)
    }

    @Test
    fun `5 dollars multiplay 2 is 10 dollars`() {
        Money.dollar(5) * 2 shouldBe Money.dollar(10)
    }

    @Test
    fun `5 dollars multiplay 3 is 15 dollars`() {
        Money.dollar(5) * 3 shouldBe Money.dollar(15)
    }

    @Test
    fun `5 franc is 5 franc`() {
        Money.franc(5) shouldBe Money.franc(5)
    }

    @Test
    fun `5 franc is NOT 2 franc`() {
        Money.franc(5) shouldNotBe Money.franc(2)
    }

    @Test
    fun `5 franc multiplay 2 is 10 franc`() {
        Money.franc(5) * 2 shouldBe Money.franc(10)
    }

    @Test
    fun `5 franc multiplay 3 is 15 franc`() {
        Money.franc(5) * 3 shouldBe Money.franc(15)
    }

    @Test
    fun `5 CHF + 5 CHF is 10 CHF`() {
        Money.franc(5) + Money.franc(5) shouldBe Wallet(Money.franc(10))
    }

    @Test
    fun `5 dollar + 5 dollar is 10 dollars`() {
        Money.dollar(5) + Money.dollar(5) shouldBe Wallet(Money.dollar(10))
    }

    @Test
    fun `5 dollars is not 5 francs`() {
        Money.dollar(5) shouldNotBe Money.franc(5)
    }

    @Test
    fun `2 CHF + 4 USD is wallet that contains 2 CHF and 4 USD`() {
        Money.franc(2) + Money.dollar(4) shouldBe Wallet(Money.franc(2), Money.dollar(4) )
    }
}