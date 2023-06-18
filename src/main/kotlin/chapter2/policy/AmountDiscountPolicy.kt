package chapter2.policy

import chapter2.Money
import chapter2.Screening
import chapter2.condition.DiscountCondition

class AmountDiscountPolicy(
    private val discountAmount: Money,
    conditions: List<DiscountCondition>
) : DefaultDiscountPolicy(conditions) {

    constructor(
        discountAmount: Money,
        vararg conditions: DiscountCondition
    ): this(discountAmount, conditions.toList())

    override fun getDiscountAmount(screening: Screening): Money = discountAmount

}
