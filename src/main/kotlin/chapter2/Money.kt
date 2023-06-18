package chapter2

import java.math.BigDecimal

data class Money(
    val amount: BigDecimal
) {

    fun plus(amount: Money): Money = Money(this.amount.add(amount.amount))

    fun minus(amount: Money): Money = Money(this.amount.subtract(amount.amount))

    fun times(percent: Double): Money = Money(this.amount.multiply(BigDecimal.valueOf(percent)))

    fun isLessThan(other: Money): Boolean = amount < other.amount

    fun isGreaterThanOorEqual(other: Money): Boolean = amount >= other.amount

    companion object {
        val ZERO: Money = wons(0)

        fun wons(amount: Long): Money = Money(BigDecimal.valueOf(amount))
        fun wons(amount: Double): Money = Money(BigDecimal.valueOf(amount))
    }

}
