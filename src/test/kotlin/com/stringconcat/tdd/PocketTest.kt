package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class PocketTest {

    @Test
    fun `1 USD plus 1 USD is 2 USD`() {
        val twoDollars = Money.dollar(1) + Money.dollar(1)
        twoDollars.a shouldBe Money.dollar(1)
        twoDollars.b shouldBe Money.dollar(1)
    }

    @Test
    fun `1 CHF plus 1 CHF is 2 CHF`() {
        val twoFrancs = Money.franc(1) + Money.franc(1)

        twoFrancs.a shouldBe Money.franc(1)
        twoFrancs.b shouldBe Money.franc(1)
    }

    @Test
    fun `10 USD and 5 CHF in pocket`() {
        val pocket = Money.dollar(10) + Money.franc(5)

        pocket.a shouldBe Money.dollar(10)
        pocket.b shouldBe Money.franc(5)
    }

    @Test
    fun `5 USD + 5 USD is 10 USD`() {
        val pocket = Money.dollar(5) + Money.dollar(5)
        pocket.reduce(to = Money.Currency.USD, rateProvider = {1}) shouldBe Money.dollar(10)
    }

//    @Test
//    fun `5 USD plus 10 franc is 10 dollars`() {
//        val fiveDollars = Money.dollar(5)
//        val tenFrancs = Money.franc(10)
//
//        val pocket = fiveDollars + tenFrancs
//        val converted = pocket.reduce(Money.Currency.USD, rate?? )
//
//        converted shouldBe Money.dollar(10)
//    }

    @Test
    fun `5 USD + 5 USD reduced to 20 CHF`() {
        val pocket = Money.dollar(5) + Money.dollar(5)

        pocket.reduce(to = Money.Currency.CHF, {2}) shouldBe Money.franc(20)
    }
}