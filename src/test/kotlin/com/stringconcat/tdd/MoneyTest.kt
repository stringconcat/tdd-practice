package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class MoneyTest {

    @Test
    fun `5 CHF is equal to 5 CHF`() {
        Money.franc(5) shouldBe Money.franc(5)
    }

    @Test
    fun `5 CHF is NOT equal to 7 CHF`() {
        Money.franc(5) shouldNotBe  Money.franc(7)
    }

    @Test
    fun `No CHF is equal to null`() {
        Money.franc(5).shouldNotBe(null)
    }

    @Test
    fun `5 CHF multiply 2 should be 10 CHF`() {
        Money.franc(5) * 2  shouldBe Money.franc(10)
    }

    @Test
    fun `10 CHF multiply 3 should be 30 CHF`() {
        Money.franc(10) * 3  shouldBe Money.franc(30)
    }

    @Test
    fun `2 CHF + 2 CHF is 4 CHF`() {
        Money.franc(2) + Money.franc(2) shouldBe Money.franc(4)
    }

    @Test
    fun `5 USD is equal to 5 USD`() {
        Money.dollar(5) shouldBe Money.dollar(5)
    }

    @Test
    fun `5 USD is NOT equal to 7 USD`() {
        Money.dollar(5) shouldNotBe Money.dollar(7)
    }

    @Test
    fun `No dollar is equal to null`() {
        Money.dollar(5).shouldNotBe(null)
    }

    @Test
    fun `5 USD multiply 2 should be 10 USD`() {
        Money.dollar(5) * 2  shouldBe Money.dollar(10)
    }

    @Test
    fun `10 USD multiply 3 should be 30 USD`() {
        Money.dollar(10) * 3  shouldBe Money.dollar(30)
    }

    @Test
    fun `2 USD + 2 USD is 4 USD`() {
        Money.dollar(2) + Money.dollar(2) shouldBe Money.dollar(4)
    }

    @Test
    fun `2 USD is not equal 2 CHF`() {
        Money.dollar(2) shouldNotBe Money.franc(2)
    }

    @Test
    fun `5 USD to CHF is 10 CHF if rate 2 to 1`() {
        Money.dollar(5).toFranc() shouldBe Money.franc(10)
    }

    @Test
    fun `5 CHF to CHF is 5 CHF`() {
        Money.franc(5).toFranc() shouldBe Money.franc(5)
    }
}