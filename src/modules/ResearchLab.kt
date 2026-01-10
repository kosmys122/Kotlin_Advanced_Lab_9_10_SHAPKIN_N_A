package modules

import resources.ResourceManager

class ResearchLab: OutpostModule("»сследовательска€ лаборатори€") {
    override fun performAction(manager: ResourceManager) {
        val minerals=manager.get("Minerals")
        if (minerals==null || minerals.amount<30){
            println("Ќедостаточно минералов дл€ исследовани€")
            return
        }
        minerals.amount
        println("Ћаботарори€ проводит исследование (минералы -30)")
    }
}