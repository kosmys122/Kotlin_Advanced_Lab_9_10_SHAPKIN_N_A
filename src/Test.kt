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
//    val hero=Hero("Утер")
//    hero.health=150
//    println(hero.health)
//    println(hero.stamina)
//    //hero.level=10
//    hero.leverUp()
    val worker=OutpostWorker("Алексей")
    println("Энергия: ${worker.energy}")
    println("Настроение: ${worker.mood}")
    worker.work()
    worker.work()
    worker.work()
    println("Энергия ${worker.energy}")
    println("Настроение ${worker.mood}")
    worker.rest()
    worker.energy=150
    //worker.level=5
    worker.levelUp()
}
