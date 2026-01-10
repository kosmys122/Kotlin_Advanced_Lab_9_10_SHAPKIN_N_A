package resources

data class OutpostResource(
    val id:Int,
    val name:String,
    val amount:Int
){
    override fun toString(): String {
        return "Ваш ресурс: $id | Имя: $name | Количество: $amount"
    }
    fun main(){
        val gas= OutpostResource(1,"Gas",100)
        val mineral= OutpostResource(2,"Minerals",250)
        println("Успех! Вы добыли дополнительное количество минералов:" +
                "${mineral.amount+50}")
        val bonusMineral=mineral.copy(id=3,name="Minerals Bonus",amount=mineral.amount+50)
        println(gas.toString())
        println(mineral.toString())
        println(bonusMineral.toString())
    }
}
