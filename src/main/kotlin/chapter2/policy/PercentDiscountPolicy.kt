package chapter2.policy

import chapter2.Money
import chapter2.Screening
import chapter2.condition.DiscountCondition

class PercentDiscountPolicy(
    private val percent: Double,
    conditions: List<DiscountCondition>
) : DefaultDiscountPolicy(conditions) {

    constructor(
        percent: Double,
        vararg conditions: DiscountCondition
    ): this(percent, conditions.toList())

    override fun getDiscountAmount(screening: Screening): Money = screening.movieFee.times(percent)

}
