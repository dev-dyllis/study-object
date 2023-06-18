package chapter2.policy

import chapter2.Money
import chapter2.Screening
import chapter2.condition.DiscountCondition

abstract class DefaultDiscountPolicy(
    private val conditions: List<DiscountCondition> = listOf()
) : DiscountPolicy {

    override fun calculateDiscountAmount(
        screening: Screening
    ): Money {
        if (conditions.any { discountCondition -> discountCondition.isSatisfiedBy(screening) }) {
            return getDiscountAmount(screening)
        }

        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money

}