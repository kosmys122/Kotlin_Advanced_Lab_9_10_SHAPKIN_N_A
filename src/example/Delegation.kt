package example
import kotlin.properties.Delegates
interface Base{
    fun someFun()
}
class BaseImpl():Base{
    override fun someFun() {}
}
class Derived(someBase: Base):Base by someBase
interface Messenger{
    fun sendTextMessage()
    fun sendVideoMessage()
}
class InstantMessenger(val prograName:String):Messenger{
    override fun sendTextMessage()= println("Send text message")
    override fun sendVideoMessage()= println("Send video message")
}
//class SmartPhone(val name:String,m:Messenger):Messenger by m
fun main(){
    counter=1
    counter=5
    val max=InstantMessenger("MAX")
    //val photoCamera=PhotoCamera()
    val yotaPhone=SmartPhone("YotaPhone",max)
    yotaPhone.sendTextMessage()
    yotaPhone.sendVideoMessage()
//    yotaPhone.send("Hello Kotlin")
//    yotaPhone.send("Learn delegation")
//    yotaPhone.takePhoto()
}
interface PhotoDevice{
    fun takePhoto()
}
class PhotoCamera:PhotoDevice{
    override fun takePhoto()= println("Take a photo")
}
class SmartPhone(val name:String,m:Messenger):Messenger by m{
    override fun sendTextMessage()= println("Send sms")
}
var counter:Int by Delegates.observable(0){_,old,new -> println("Счётчик изменился: $old -> $new") }
class User{
    var name:String by Delegates.observable("<no name>") { _,old,new-> println("Имя изменено: '$old' -> '$new'") }
}


