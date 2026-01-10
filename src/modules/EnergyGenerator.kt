package modules

import resources.OutpostResource
import resources.ResourceManager

class EnergyGenerator: OutpostModule("Генератор энергии") {
    override fun performAction(manager: ResourceManager) {
        println("Генератор работает... Производит 20 энергии")
        val energy=manager.get("Energy")
        if (energy!=null){
            energy.amount
        } else {
            manager.add(OutpostResource(99, "Energy", 20))
        }
    }
}