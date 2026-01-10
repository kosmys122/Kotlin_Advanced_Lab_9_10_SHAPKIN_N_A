package characters

class Hero (val name:String){
    var health:Int=100
        set(value){
            field=value.coerceIn(0,100)
        }
    var stamina:Int=50
        get()=field+10
    var level:Int=1
        private  set
    fun leverUp(){
        level++
        println("$name повысил уровень до $level!")
    }
}