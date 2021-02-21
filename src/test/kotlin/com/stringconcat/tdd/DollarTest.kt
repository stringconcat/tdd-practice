package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class DollarTest {

    @Test
    fun `5 USD has amount of 5`() {
        Dollar(5).amount shouldBe 5
    }

    @Test
    fun `10 Usd is 10 USD`() {
        Dollar(10) shouldBe Dollar(10)
    }

    @Test
    fun `10 Usd is not 5 USD`() {
        Dollar(10) shouldNotBe Dollar(5)
    }

    @Test
    fun `5 dollar multiply 2 is 10 USD`() {
        val ten = Dollar(5) * 2
        ten shouldBe Dollar(10)
    }

    @Test
    fun `5 USD is not 5 CHF`() {
        Dollar(5) shouldNotBe Franc(5)
    }
}