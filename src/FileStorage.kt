import modules.ModuleResult
import resources.OutpostResource
import java.io.File
object FileStorage{
    private const val FILE_NAME="outpost_state.txt"
    fun load(): List<OutpostResource>{
        val file=File("FILE_NAME")
        if (!file.exists()) return emptyList()
        println("Загрузка состояния базы из файла")
        return file.readLines().map{
            val (id,name,amount)=it.split(";")
            OutpostResource(id.toInt(),name,amount.toInt())
        }
    }
    fun save(resources: List<OutpostResource>){
        val file=File("FILE_NAME")
        file.writeText(
            resources.joinToString("\n"){
                "${it.id.toString().padEnd(3)} | ${it.name.padEnd(10)} | ${it.amount}"
            }
        )
        println("Состояние базы сохранено в файл")
    }
}