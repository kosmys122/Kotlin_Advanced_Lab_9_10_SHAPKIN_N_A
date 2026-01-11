package example

sealed class NetworkResult{
    data class Success(val data:String):NetworkResult()
    data class Error(val message:String,val code:Int):NetworkResult()
    object Loading:NetworkResult()
}

fun handleResult(result: NetworkResult){
    when (result){
        is NetworkResult.Success->{
            println("Успех: ${result.data}")
        }
        is NetworkResult.Error->{
            println("Ошибка ${result.code}: ${result.message}")
        }
        NetworkResult.Loading->{
            println("Загрузка...")
        }
    }
}

fun main(){
//    val success=NetworkResult.Success("Данные получены")
//    val error=NetworkResult.Error("Сервер не отвечает",500)
//    val loading=NetworkResult.Loading
//    handleResult(success)
//    handleResult(error)
//    handleResult(loading)
    handleOrder(OrderStatys.Created)
    handleOrder(OrderStatys.Paid)
    handleOrder(OrderStatys.Shipped)
    handleOrder(OrderStatys.Cancelled("Нет товара на складе"))
}
sealed class OrderStatys{
    object Created:OrderStatys()
    object Paid:OrderStatys()
    object Shipped:OrderStatys()
    data class Cancelled(val reason:String):OrderStatys()
}
fun handleOrder(statys: OrderStatys){
    when (statys){
        OrderStatys.Created-> println("Заказ создан")
        OrderStatys.Paid-> println("Заказ оплачен")
        OrderStatys.Shipped-> println("Заказ отправлен")
        is OrderStatys.Cancelled-> println("Отменён: ${statys.reason}")
    }
}