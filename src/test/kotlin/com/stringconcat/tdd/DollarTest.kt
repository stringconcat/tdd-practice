package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DollarTest {

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
    fun `2 USD + 2 USD is 4 USD`() {
        Money.dollar(2) + Money.dollar(2) shouldBe Money.dollar(4)
    }

    @Test
    fun `4 CHF is 2 USD if rate 2 to 1`() {
        Money.franc(4).toDollar(rate = 2) shouldBe (Money.dollar(2))
    }

    @Test
    fun `5 USD to USD = 5 USD`() {
        Money.dollar(5).toDollar(1) shouldBe (Money.dollar(5))
    }
}