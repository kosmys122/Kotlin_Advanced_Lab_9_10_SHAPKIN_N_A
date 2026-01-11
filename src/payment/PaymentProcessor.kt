package payment

class PaymentProcessor {
    private val validator=PaymentValidator()
    fun pay(payment: Payment):PaymentResult{
        if (!validator.check((payment))){
            return PaymentResult.Error("Ошибка валидации")
        }
        return when(payment.type){
            CardType.VISA->PaymentResult.Success("VISA-${System.currentTimeMillis()}")
            CardType.MASTERCARD->PaymentResult.Processing
            CardType.MIR->PaymentResult.Success("MIR-${System.currentTimeMillis()}")
            CardType.UNKNOWN->PaymentResult.Error("Неизвестный тип карты")
        }
    }
    fun show(result: PaymentResult){
        when(result){
            is PaymentResult.Success-> println("Успех: ${result.id}")
            is PaymentResult.Error-> println("Ошибка: ${result.reason}")
            PaymentResult.Processing-> println("В обработке")
        }
    }
}