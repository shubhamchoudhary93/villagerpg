package com.shubham.villagerpg.data

import com.shubham.villagerpg.databinding.ManufacturePageBinding
import com.shubham.villagerpg.databinding.ProducePageBinding

object IDAssign {

    fun assign(binding: ProducePageBinding) {
        10000.also { binding.farmOne.id = it }
        10001.also { binding.farmTwo.id = it }
        10002.also { binding.farmThree.id = it }
        10003.also { binding.farmFour.id = it }
        10004.also { binding.farmFive.id = it }
        10005.also { binding.farmSix.id = it }
        10006.also { binding.farmSeven.id = it }
        10007.also { binding.farmEight.id = it }

        30000.also { binding.campOne.id = it }
        30001.also { binding.campTwo.id = it }
        30002.also { binding.campThree.id = it }
        30003.also { binding.campFour.id = it }
        30004.also { binding.campFive.id = it }
        30005.also { binding.campSix.id = it }
        30006.also { binding.campSeven.id = it }
        30007.also { binding.campEight.id = it }
    }

    fun assign(binding: ManufacturePageBinding) {
        10000.also { binding.factoryOne.id = it }
        10001.also { binding.factoryTwo.id = it }
        10002.also { binding.factoryThree.id = it }
        10003.also { binding.factoryFour.id = it }
        10004.also { binding.factoryFive.id = it }
        10005.also { binding.factorySix.id = it }
        10006.also { binding.factorySeven.id = it }
        10007.also { binding.factoryEight.id = it }


        20000.also { binding.kitchenOne.id = it }
        20001.also { binding.kitchenTwo.id = it }
        20002.also { binding.kitchenThree.id = it }
        20003.also { binding.kitchenFour.id = it }
        20004.also { binding.kitchenFive.id = it }
        20005.also { binding.kitchenSix.id = it }
        20006.also { binding.kitchenSeven.id = it }
        20007.also { binding.kitchenEight.id = it }
    }

}