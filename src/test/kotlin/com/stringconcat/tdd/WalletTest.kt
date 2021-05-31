package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class WalletTest {
    @Test
    fun `wallet containing 2 USD is another wallet containing 2 USD`() {
        Wallet(Money.dollar(2)) shouldBe Wallet(Money.dollar(2))
    }

    @Test
    fun `wallet that contains 2 CHF returns 1 USD if rate 2 to 1`() {
        Wallet(Money.franc(2)).asDollars(2.0) shouldBe Money.dollar(1)
    }

    @Test
    fun `wallet that contains 3 CHF returns 1 USD if rate 3 to 1`() {
        Wallet(Money.franc(3)).asDollars(3.0) shouldBe Money.dollar(1)
    }

    @Test
    fun `wallet that contains 1 USD returns 2 CHF if rate 1 to 2`() {
        Wallet(Money.dollar(1)).asFranc(0.5) shouldBe Money.franc(2)
    }

    @Test
    fun `wallet that contains 2 CHF and 1 USD returns 2 USD if rate 2 to 1`() {
        Wallet(Money.franc(2), Money.dollar(1)).asDollars(2.0) shouldBe Money.dollar(2)
    }

    @Test
    fun `wallet that contains 3 CHF returns 1 EUR if rate 3 to 1`() {
        Wallet(Money.franc(3)).asEuro(3.0) shouldBe Money.euro(1)
    }

    @Test
    fun `wallet that contains 6 USD returns 3 EUR if rate 2 to 1`() {
        Wallet(Money.dollar(6)).asEuro(2.0) shouldBe Money.euro(3)
    }

    @Test
    fun `wallet that contains 3 EUR returns 6 USD if rate 1 to 2`() {
        Wallet(Money.euro(3)).asDollars(0.5) shouldBe Money.dollar(6)
    }

    @Test
    fun `wallet that contains 3 EUR returns 6 CHF if rate 1 to 2`() {
        Wallet(Money.euro(3)).asFranc(0.5) shouldBe Money.franc(6)
    }

    @Test
    fun `wallet that contains 3 EUR returns 3 EUR if rate 1 to 1`() {
        Wallet(Money.euro(3)).asEuro(1.0) shouldBe Money.euro(3)
    }

    @Test
    fun `wallet that contains 3 USD and 3 CHF + wallet that contains 3 CHF retutn wallet that contains 3 USD and 6 CHF`() {
        Wallet(Money.dollar(3), Money.franc(3)) + Wallet(Money.franc(3)) shouldBe Wallet(Money.dollar(3), Money.franc(6))
    }
}