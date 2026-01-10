var age:Int=18
    set(value){
        if ((value>0) and (value<110))
            field=value
    }

fun main(){
//    println(age)
//    age=45
//    println(age)
//    age=-345
//    println(age)
    val hero=Hero("Утер")
    hero.health=150
    println(hero.health)
    println(hero.stamina)
    //hero.level=10
    hero.leverUp()
}