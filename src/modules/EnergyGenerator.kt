package modules

import resources.OutpostResource
import resources.ResourceManager

class EnergyGenerator: OutpostModule("Генератор энергии") {
    override fun performAction(manager: ResourceManager):ModuleResult {
        println("Генератор работает... Производит 20 энергии")
        val energy=manager.get("Energy")
        return if (energy!=null){
            energy.amount
            ModuleResult.ResourceProduced("Energy",20)
        } else {
            manager.add(OutpostResource(99, "Energy", 20))
            ModuleResult.Success("Энергия создана впервые")
        }
    }
}