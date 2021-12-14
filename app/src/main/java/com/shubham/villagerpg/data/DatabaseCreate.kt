package com.shubham.villagerpg.data

import android.content.Context

object DatabaseCreate {

    private lateinit var inventoryDatabase: InventoryDatabaseDao

    private lateinit var finishRequirementDatabase: FinishRequirementDatabaseDao

    fun createFirst(context: Context) {

        inventoryDatabase = InventoryDatabase.getInstance(context).inventoryDatabaseDao
        finishRequirementDatabase =
            FinishRequirementDatabase.getInstance(context).finishRequirementDatabaseDao

        inventoryDatabase.insert(
            Inventory(
                0,
                "CarrotSeed",
                "seed",
                10,
                0,
                0,
                10,
                10000,
                0,
                10,
                20000,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                1,
                "PeasSeed",
                "seed",
                12,
                0,
                0,
                12,
                20000,
                0,
                10,
                20001,
                1,
                0
            )
        )


        inventoryDatabase.insert(Inventory(20000, "Carrot", "crop", 0, 12, 0, 10, 0, 0, 0, 0, 0, 1))
        inventoryDatabase.insert(Inventory(20001, "Peas", "crop", 0, 15, 0, 12, 0, 0, 0, 1, 0, 1))

        inventoryDatabase.insert(Inventory(30000, "Wood", "item", 20, 0, 0, 20, 10000, 0, 10, 1, 0))
        inventoryDatabase.insert(
            Inventory(
                30001,
                "Metal",
                "item",
                22,
                0,
                0,
                22,
                20000,
                0,
                10,
                1,
                0
            )
        )

        inventoryDatabase.insert(
            Inventory(
                40000,
                "Table",
                "product",
                50,
                100,
                0,
                100,
                10000,
                0,
                0,
                40000,
                0,
                1
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40001,
                "Chair",
                "product",
                52,
                120,
                0,
                102,
                20000,
                0,
                0,
                40001,
                0,
                1
            )
        )

        inventoryDatabase.insert(
            Inventory(
                40002,
                "Salad",
                "food",
                50,
                100,
                0,
                100,
                10000,
                0,
                0,
                40002,
                0,
                1,
                100
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40003,
                "gravy",
                "food",
                52,
                120,
                0,
                102,
                20000,
                0,
                0,
                40003,
                0,
                1,
                110
            )
        )

        finishRequirementDatabase.insert(FinishRequirement(0, 40000, 30000, 5))
        finishRequirementDatabase.insert(FinishRequirement(0, 40000, 30001, 5))
        finishRequirementDatabase.insert(FinishRequirement(0, 40001, 30000, 5))
        finishRequirementDatabase.insert(FinishRequirement(0, 40001, 30001, 5))
        finishRequirementDatabase.insert(FinishRequirement(0, 40002, 20000, 5))
        finishRequirementDatabase.insert(FinishRequirement(0, 40002, 20001, 5))
        finishRequirementDatabase.insert(FinishRequirement(0, 40003, 20000, 5))
        finishRequirementDatabase.insert(FinishRequirement(0, 40003, 20001, 5))

    }
}
