package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class FrancTest {

    @Test
    fun `5 CHF has amount of 5`() {
        Franc(5).amount shouldBe 5
    }

    @Test
    fun `10 CHF is 10 CHF`() {
        Franc(10) shouldBe Franc(10)
    }

    @Test
    fun `10 CHF is not 5 CHF`() {
        Franc(10) shouldNotBe Franc(5)
    }

    @Test
    fun `5 CHF multiply 2 is 10 CHF`() {
        val ten = Franc(5) * 2
        ten shouldBe Franc(10)
    }
}