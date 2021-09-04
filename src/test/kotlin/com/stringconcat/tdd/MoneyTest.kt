package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.RoundingMode

internal class MoneyTest {

    @Test
    fun `5 CHF is equal to 5 CHF`() {
        Money.franc(BigDecimal.valueOf(5)) shouldBe Money.franc(BigDecimal.valueOf(5))
    }

    @Test
    fun `5 CHF is NOT equal to 7 CHF`() {
        Money.franc(BigDecimal.valueOf(5)) shouldNotBe Money.franc(BigDecimal.valueOf(7))
    }

    @Test
    fun `No CHF is equal to null`() {
        Money.franc(BigDecimal.valueOf(5)).shouldNotBe(null)
    }

    @Test
    fun `5 CHF multiply 2 should be 10 CHF`() {
        Money.franc(BigDecimal.valueOf(5)) * 2 shouldBe Money.franc(BigDecimal.valueOf(10))
    }

    @Test
    fun `10 CHF multiply 3 should be 30 CHF`() {
        Money.franc(BigDecimal.valueOf(10)) * 3 shouldBe Money.franc(BigDecimal.valueOf(30))
    }

    @Test
    fun `2 CHF + 2 CHF is 4 CHF`() {
        Money.franc(BigDecimal.valueOf(2)) + Money.franc(BigDecimal.valueOf(2)) shouldBe Money.franc(
            BigDecimal.valueOf(
                4
            )
        )
    }

    @Test
    fun `5 USD is equal to 5 USD`() {
        Money.dollar(BigDecimal.valueOf(5)) shouldBe Money.dollar(BigDecimal.valueOf(5))
    }

    @Test
    fun `5 USD is NOT equal to 7 USD`() {
        Money.dollar(BigDecimal.valueOf(5)) shouldNotBe Money.dollar(BigDecimal.valueOf(7))
    }

    @Test
    fun `No dollar is equal to null`() {
        Money.dollar(BigDecimal.valueOf(5)).shouldNotBe(null)
    }

    @Test
    fun `5 USD multiply 2 should be 10 USD`() {
        Money.dollar(BigDecimal.valueOf(5)) * 2 shouldBe Money.dollar(BigDecimal.valueOf(10))
    }

    @Test
    fun `10 USD multiply 3 should be 30 USD`() {
        Money.dollar(BigDecimal.valueOf(10)) * 3 shouldBe Money.dollar(BigDecimal.valueOf(30))
    }

    @Test
    fun `2 USD + 2 USD is 4 USD`() {
        Money.dollar(BigDecimal.valueOf(2)) + Money.dollar(BigDecimal.valueOf(2)) shouldBe Money.dollar(
            BigDecimal.valueOf(
                4
            )
        )
    }

    @Test
    fun `2 USD is not equal 2 CHF`() {
        Money.dollar(2.toBigDecimal()) shouldNotBe Money.franc(2.toBigDecimal())
    }

    @Test
    fun `5 USD to CHF is 15 CHF if rate 3 to 1`() {
        Money.dollar(BigDecimal.valueOf(5)).convert(3.toBigDecimal(), Money.Currency.CHF) shouldBe Money.franc(
            BigDecimal.valueOf(15)
        )
    }

    @Test
    fun `15 CHF to USD is 5 USD if rate 1 to 3`() {
        Money.franc(BigDecimal.valueOf(15)).convert(
            1.toBigDecimal().divide(3.toBigDecimal(), 4, RoundingMode.HALF_EVEN),
            Money.Currency.USD

        ) shouldBe Money.dollar(BigDecimal.valueOf(5))
    }

    @Test
    fun `5 USD to CHF is 10 CHF if rate 2 to 1`() {
        Money.dollar(BigDecimal.valueOf(5)).convert(2.toBigDecimal(), Money.Currency.CHF) shouldBe Money.franc(
            BigDecimal.valueOf(10)
        )
    }

    @Test
    fun `5 CHF to CHF is 5 CHF`() {
        Money.franc(BigDecimal.valueOf(5))
            .convert(1.toBigDecimal(), Money.Currency.CHF) shouldBe Money.franc(5.toBigDecimal())
    }

    @Test
    fun `10 CHF to USD is 5 USD if rate 1 to 2`() {
        Money.franc(BigDecimal.valueOf(10)).convert(

            1.toBigDecimal().divide(2.toBigDecimal(), 4, RoundingMode.HALF_EVEN),
            Money.Currency.USD

        ) shouldBe Money.dollar(BigDecimal.valueOf(5))
    }

    @Test
    fun `10 CHF + 5 USD to USD is 10 USD if CHFUSD rate 1 to 2`() {
        Money.franc(BigDecimal.valueOf(10)).convert(0.5.toBigDecimal(), Money.Currency.USD) + Money.dollar(
            BigDecimal.valueOf(5)
        ) shouldBe Money.dollar(10.toBigDecimal())
    }

    @Test
    fun `10 CHF + 10 USD to USD is 10 USD if CHFUSD rate 1 to 2`() {
        Money.franc(BigDecimal.valueOf(10)).convert(

            0.5.toBigDecimal(),
            Money.Currency.USD

        ) + Money.dollar(10.toBigDecimal()) shouldBe Money.dollar(15.toBigDecimal())
    }

    @Test
    fun `10 CHF + 10 USD to USD is 10 USD if CHFUSD rate 1 to 1`() {
        Money.franc(BigDecimal.valueOf(10)).convert(1.toBigDecimal(), Money.Currency.USD) + Money.dollar(
            BigDecimal.valueOf(10)
        ) shouldBe Money.dollar(20.toBigDecimal())
    }

    @Test
    fun `10 CHF + 10 USD to USD is 10 USD if CHFUSD rate 3 to 1`() {
        Money.franc(BigDecimal.valueOf(10)).convert(
            1.toBigDecimal().divide((3).toBigDecimal(), 4, RoundingMode.HALF_EVEN),
            Money.Currency.USD
        ) + Money.dollar(
            BigDecimal.valueOf(10)
        ) shouldBe Money.dollar(
            (10.toBigDecimal().divide((3).toBigDecimal(), 4, RoundingMode.HALF_EVEN).add(10.toBigDecimal()))
        )
    }

}