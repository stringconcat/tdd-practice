package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FrancTest {

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

    @Test
    fun `2 CHF + 2 CHF is 4 CHF`() {
        Money.franc(2) + Money.franc(2) shouldBe Money.franc(4)
    }
}