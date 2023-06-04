package chapter1

data class Bag(
    var amount: Long,
    val invitation: Invitation? = null,
    var ticket: Ticket? = null
) {
    private val hasInvitation: Boolean = invitation != null

    constructor(amount: Long) : this(null, amount)

    constructor(
        invitation: Invitation?,
        amount: Long
    ): this(amount, invitation, null)

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun hold(ticket: Ticket): Long {
        return if (hasInvitation) {
            this.ticket = ticket
            0
        } else {
            minusAmount(ticket.fee)
            this.ticket = ticket
            ticket.fee
        }
    }

}
