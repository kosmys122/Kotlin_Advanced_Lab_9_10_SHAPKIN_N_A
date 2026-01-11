package example

import java.lang.classfile.MethodModel

object GameSession{
    init{
        println("Игровая сессия создана")
    }
    var isActive:Boolean=false
    fun start(){
        isActive=true
        println("Игра началась")
    }
    fun end(){
        isActive=false
        println("Игра завершена")
    }
}
fun main(){
//    println("Программа запущена")
//    println("Проверяем состояние, но не трогаем GameSession")
//    println("Теперь запускаем игру")
//    println("Проверяем состояние ещё раз")
//    println("Активна ли сессия: ${GameSession.isActive}")
//    Logger.log("Первое сообщение")
//    Logger.log("Второе сообщение")
//    val logger1=Logger
//    val logger2=Logger
//    println(logger1===logger2)
//    println(Colors.RED)
//    println(Colors.GREEN)
//    println(Colors.BLUE)
//    val handler=object {
//        val name="Обработчик"
//        fun handle(){
//            println("Обрабатываю...")
//        }
//    }
//    println(handler.name)
//    handler.handle()
    MyCar("Toyota")
    MyCar("BMW")
    TrafficController.carPassed()
}

object Logger{
    var count=0
    fun log(message:String){
        count++
        println("[$count] $message")
    }
}

object AppSettings{
    val version="1.0.0"
    var isDarkMode=true
    fun toggleTheme(){
        isDarkMode=!isDarkMode
    }
    fun checkTheme(){
        if (AppSettings.isDarkMode){
            println("Темная тема включена")
        }
    }
}
object Colors{
    const val RED="#FF0000"
    const val GREEN="#00FF00"
    const val BLUE="#0000FF"
}
class MyCar(val model: String){
    fun drive()= println("$model едет")
}
object TrafficController{
    var carCount=0
    fun carPassed(){
        carCount++
    }
}