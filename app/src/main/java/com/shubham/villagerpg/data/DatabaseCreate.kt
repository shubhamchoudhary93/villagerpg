package com.shubham.villagerpg.data

import android.content.Context

object DatabaseCreate {

    private lateinit var inventoryDatabase: InventoryDatabaseDao
    private lateinit var questDatabase: QuestDatabaseDao
    private lateinit var finishRequirementDatabase: FinishRequirementDatabaseDao
    private lateinit var questRewardDatabase: QuestRewardDatabaseDao

    fun createFirst(context: Context) {

        inventoryDatabase = InventoryDatabase.getInstance(context).inventoryDatabaseDao
        finishRequirementDatabase =
            FinishRequirementDatabase.getInstance(context).finishRequirementDatabaseDao
        questDatabase = QuestDatabase.getInstance(context).questDatabaseDao
        questRewardDatabase = QuestRewardDatabase.getInstance(context).questRewardDatabaseDao

        inventoryDatabase.insert(Inventory(0,"Pepper Seed","seed",9,0,0,0,60000,0,10,"Pepper",1,0,0))
        inventoryDatabase.insert(Inventory(1,"Carrot Seed","seed",18,0,0,0,120000,1,10,"Carrot",1,0,0))
        inventoryDatabase.insert(Inventory(20000,"Pepper","crop",0,10,0,10,0,0,0,"Pepper Seed",0,1,0))
        inventoryDatabase.insert(Inventory(20001,"Carrot","crop",0,20,0,20,0,1,0,"Carrot Seed",0,1,0))
        inventoryDatabase.insert(Inventory(30000,"Wood","raw",1,0,0,10,5000,0,0,"",0,0,0))
        inventoryDatabase.insert(Inventory(30002,"Stone","raw",1,0,0,10,5000,1,0,"",0,0,0))
        inventoryDatabase.insert(Inventory(40000,"Stool","product",10,20,1,20,10000,0,0,"",0,1,0))
        inventoryDatabase.insert(Inventory(40001,"Axe","product",15,30,1,30,15000,1,0,"",0,1,0))
        inventoryDatabase.insert(Inventory(50000,"Pepper Paste","food",0,0,0,10,60000,1,0,"Pepper",0,0,100))
        inventoryDatabase.insert(Inventory(50001,"Carrot Paste","food",0,0,0,20,60000,2,0,"Carrot",0,0,200))

        finishRequirementDatabase.insert(FinishRequirement(0,"Stool","Wood",1))
        finishRequirementDatabase.insert(FinishRequirement(0,"Stool","Stone",4))
        finishRequirementDatabase.insert(FinishRequirement(0,"Axe","Wood",10))
        finishRequirementDatabase.insert(FinishRequirement(0,"Axe","Stone",10))

        questDatabase.insert(Quest(0, "Quest 1", "Need Food","Pepper", 5, "", 0, 0))
        questDatabase.insert(Quest(0, "Quest 1", "Need Food","Carrot", 5, "", 0, 0))
        questDatabase.insert(Quest(0, "Quest 2", "Need Material","Wood", 10, "", 1, 0))
        questDatabase.insert(Quest(0, "Quest 2", "Need Material","Stone", 10, "", 1, 0))
        questDatabase.insert(Quest(0, "Quest 3", "Need Table","Stool", 5, "", 0, 0))
        questDatabase.insert(Quest(0, "Quest 4", "Need Material","Pepper Paste", 10, "", 2, 0))
        questDatabase.insert(Quest(0, "Quest 4", "Need Material","Carrot Paste", 10, "", 2, 0))

        questRewardDatabase.insert(QuestReward(0,"Quest 1","Money", 100 ))
        questRewardDatabase.insert(QuestReward(0,"Quest 2","Wood", 10 ))
        questRewardDatabase.insert(QuestReward(0,"Quest 2","Stone", 10 ))
        questRewardDatabase.insert(QuestReward(0,"Quest 3","Money", 400 ))
        questRewardDatabase.insert(QuestReward(0,"Quest 3","Gold", 10 ))
        questRewardDatabase.insert(QuestReward(0,"Quest 4","Money", 600 ))
        questRewardDatabase.insert(QuestReward(0,"Quest 4","Gold", 10 ))

    }
}
