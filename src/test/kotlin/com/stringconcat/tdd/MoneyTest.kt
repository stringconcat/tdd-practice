package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class MoneyTest {
    @Test
    fun `2 CHF is not 2 USD`() {
        Money.dollar(2) shouldNotBe Money.franc(2)
    }

    @Test
    fun `2 multiply 5 USD is 10 USD`() {
        Money.dollar(5) * 2 shouldBe Money.dollar(10)
    }

    @Test
    fun `3 multiply 5 USD is 15 USD`() {
        Money.dollar(5) * 3 shouldBe Money.dollar(15)
    }

    @Test
    fun `zero dollars are zero dollars`() {
        Money.dollar(0) shouldBe Money.dollar(0)
    }

    @Test
    fun `2 USD is 2 USD`() {
        Money.dollar(2) shouldBe Money.dollar(2)
    }

    @Test
    fun `2 USD is not 3 USD`() {
        Money.dollar(2) shouldNotBe Money.dollar(3)
    }

    @Test
    fun `2 USD is not equal to null`() {
        Money.dollar(2).equals(null) shouldBe false
    }

    @Test
    fun `2 USD is not equal to any other object`() {
        Money.dollar(2) shouldNotBe "any string"
    }

    @Test
    fun `2 multiply 5 CHF is 10 CHF`() {
        Money.franc(5) * 2 shouldBe Money.franc(10)
    }

    @Test
    fun `3 multiply 5 CHF is 15 CHF`() {
        Money.franc(5) * 3 shouldBe Money.franc(15)
    }

    @Test
    fun `zero Francs are zero Francs`() {
        Money.franc(0) shouldBe Money.franc(0)
    }

    @Test
    fun `2 CHF is 2 CHF`() {
        Money.franc(2) shouldBe Money.franc(2)
    }

    @Test
    fun `2 CHF is not 3 CHF`() {
        Money.franc(2) shouldNotBe Money.franc(3)
    }

    @Test
    fun `2 CHF is not equal to null`() {
        Money.franc(2).equals(null) shouldBe false
    }

    @Test
    fun `2 CHF is not equal to any other object`() {
        Money.franc(2) shouldNotBe "any string"
    }
}