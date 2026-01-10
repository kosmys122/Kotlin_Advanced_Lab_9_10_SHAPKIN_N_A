import java.lang.classfile.MethodModel

interface Movable{
    var speed:Int
    var model:String
    val number:String
    fun move()
    fun stop(){
        println("Останавливаемся...")
    }
}
class Car(
    override val model: String,
    override val number: String
) : Movable{
    override var speed=60
    override fun move(){
        println("Едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft(
    override val model: String,
    override val number:String
):Movable{
    override var speed=600
    override fun move(){
        println("Летим на самолёте со скоростью $speed км/ч")
    }
    override fun stop()= println("Приземляемся...")
}
fun travel(obj:Movable)=obj.move()
fun main(){
//    val car=Car()
//    val aircraft=Aircraft()
//    car.move()
//    aircraft.move()
//    travel(car)
//    travel(aircraft)
//    val car:Movable=Car()
//    val aircraft:Movable=Aircraft()
//    val pavel=WorkingStudent("Pavel")
//    pavel.work()
//    pavel.study()
//    aircraft.move()
//    aircraft.stop()
//    val car=Car("LADA","123LAD")
//    val aircraft=Aircraft("Boeing","737")
    val player=MediaPlayer()
    player.play()
}
interface Worker{
    fun work()
}
interface Student{
    fun study()
}
class WorkingStudent(val name:String):Worker,Student{
    override fun work()= println("$name работает")
    override fun study()= println("$name учится")
}
interface VideoPlayable{
    fun play()= println("Play video")
}
interface AudioPlayable{
    fun play()= println("Play audio")
}
class MediaPlayer:VideoPlayable,AudioPlayable{
    override fun play(){
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}


