package payment

class PaymentValidator {
    fun check(payment: Payment):Boolean{
        return  when (payment.type){
            CardType.VISA->payment.card.length==16 && payment.card.startsWith("4")
            CardType.MASTERCARD->payment.card.length==16 && payment.card.startsWith("5")
            CardType.MIR->payment.card.length==16 && payment.card.startsWith("2")
            CardType.UNKNOWN->payment.card.length==16
        } && payment.sum>0
    }
}