package com.stringconcat.com

import com.stringconcat.tdd.Dollar
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class DollarTest {

    @Test
    fun `5 dollars is five dollars`() {
        val five = Dollar(5)
        five.amount shouldBe 5
    }
}