package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class FrancTest {

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
}