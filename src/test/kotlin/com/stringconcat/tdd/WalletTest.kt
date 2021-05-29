package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class WalletTest {

    @Test
    fun `wallet containing 2 dollars is another wallet containing 2 dollars`() {
        Wallet(Money.dollar(2)) shouldBe Wallet(Money.dollar(2))
    }

    @Test
    fun `wallet that contains 2 CHF returns 1 dollars if rate 2 to 1`() {
        Wallet(Money.franc(2)).asDollars(2.0) shouldBe Money.dollar(1)
    }
}