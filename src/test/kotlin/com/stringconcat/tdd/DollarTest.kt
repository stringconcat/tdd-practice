package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class DollarTest {

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
}