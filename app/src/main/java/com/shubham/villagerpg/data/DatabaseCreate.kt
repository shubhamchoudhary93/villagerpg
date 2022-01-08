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

        inventoryDatabase.insert(
            Inventory(
                0,
                "Pepper Seed",
                "seed",
                9,
                0,
                0,
                0,
                60000,
                1,
                10,
                "Pepper",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                1,
                "Carrot Seed",
                "seed",
                18,
                0,
                0,
                0,
                120000,
                2,
                10,
                "Carrot",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                2,
                "Pea Seed",
                "seed",
                29,
                0,
                0,
                0,
                180000,
                4,
                0,
                "Pea",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                3,
                "Cucumber Seed",
                "seed",
                38,
                0,
                0,
                0,
                240000,
                6,
                0,
                "Cucumber",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                4,
                "Eggplant Seed",
                "seed",
                47,
                0,
                0,
                0,
                300000,
                8,
                0,
                "Eggplant",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                5,
                "Radish Seed",
                "seed",
                100,
                0,
                0,
                0,
                600000,
                10,
                0,
                "Radish",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                6,
                "Onion Seed",
                "seed",
                159,
                0,
                0,
                0,
                900000,
                12,
                0,
                "Onion",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                7,
                "Hops Seed",
                "seed",
                212,
                0,
                0,
                0,
                1200000,
                14,
                0,
                "Hops",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                8,
                "Patato Seed",
                "seed",
                267,
                0,
                0,
                0,
                1500000,
                16,
                0,
                "Patato",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                9,
                "Tomato Seed",
                "seed",
                330,
                0,
                0,
                0,
                1800000,
                18,
                0,
                "Tomato",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                10,
                "Leek Seed",
                "seed",
                680,
                0,
                0,
                0,
                3600000,
                20,
                0,
                "Leek",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                11,
                "Watermelon Seed",
                "seed",
                1400,
                0,
                0,
                0,
                7200000,
                23,
                0,
                "Watermelon",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                12,
                "Corn Seed",
                "seed",
                2960,
                0,
                0,
                0,
                14400000,
                26,
                0,
                "Corn",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                13,
                "Cabbage Seed",
                "seed",
                6080,
                0,
                0,
                0,
                28800000,
                30,
                0,
                "Cabbage",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                14,
                "Pumpkin Seed",
                "seed",
                9360,
                0,
                0,
                0,
                43200000,
                40,
                0,
                "Pumpkin",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                15,
                "Wheat Seed",
                "seed",
                19440,
                0,
                0,
                0,
                86400000,
                50,
                0,
                "Wheat",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                16,
                "Broccoli Seed",
                "seed",
                42880,
                0,
                0,
                0,
                172800000,
                60,
                0,
                "Broccoli",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                17,
                "Cotton Seed",
                "seed",
                84000,
                0,
                0,
                0,
                345600000,
                70,
                0,
                "Cotton",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                18,
                "Sunflower Seed",
                "seed",
                126000,
                0,
                0,
                0,
                518400000,
                80,
                0,
                "Sunflower",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                19,
                "Beet Seed",
                "seed",
                189000,
                0,
                0,
                0,
                777600000,
                90,
                0,
                "Beet",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20000,
                "Pepper",
                "crop",
                0,
                10,
                0,
                10,
                0,
                0,
                0,
                "Pepper Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20001,
                "Carrot",
                "crop",
                0,
                20,
                0,
                20,
                0,
                0,
                0,
                "Carrot Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20002,
                "Pea",
                "crop",
                0,
                32,
                0,
                30,
                0,
                0,
                0,
                "Pea Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20003,
                "Cucumber",
                "crop",
                0,
                42,
                0,
                40,
                0,
                0,
                0,
                "Cucumber Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20004,
                "Eggplant",
                "crop",
                0,
                53,
                0,
                50,
                0,
                0,
                0,
                "Eggplant Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20005,
                "Radish",
                "crop",
                0,
                113,
                0,
                100,
                0,
                0,
                0,
                "Radish Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20006,
                "Onion",
                "crop",
                0,
                180,
                0,
                150,
                0,
                0,
                0,
                "Onion Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20007,
                "Hops",
                "crop",
                0,
                240,
                0,
                200,
                0,
                0,
                0,
                "Hops Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20008,
                "Patato",
                "crop",
                0,
                303,
                0,
                250,
                0,
                0,
                0,
                "Patato Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20009,
                "Tomato",
                "crop",
                0,
                375,
                0,
                300,
                0,
                0,
                0,
                "Tomato Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20010,
                "Leek",
                "crop",
                0,
                775,
                0,
                600,
                0,
                0,
                0,
                "Leek Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20011,
                "Watermelon",
                "crop",
                0,
                1600,
                0,
                840,
                0,
                0,
                0,
                "Watermelon Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20012,
                "Corn",
                "crop",
                0,
                3400,
                0,
                1680,
                0,
                0,
                0,
                "Corn Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20013,
                "Cabbage",
                "crop",
                0,
                7000,
                0,
                3360,
                0,
                0,
                0,
                "Cabbage Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20014,
                "Pumpkin",
                "crop",
                0,
                10800,
                0,
                5040,
                0,
                0,
                0,
                "Pumpkin Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20015,
                "Wheat",
                "crop",
                0,
                22500,
                0,
                10080,
                0,
                0,
                0,
                "Wheat Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20016,
                "Broccoli",
                "crop",
                0,
                50000,
                0,
                20160,
                0,
                0,
                0,
                "Broccoli Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20017,
                "Cotton",
                "crop",
                0,
                100000,
                0,
                40320,
                0,
                0,
                0,
                "Cotton Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20018,
                "Sunflower",
                "crop",
                0,
                153000,
                0,
                60480,
                0,
                0,
                0,
                "Sunflower Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                20019,
                "Beet",
                "crop",
                0,
                23000,
                0,
                90720,
                0,
                0,
                0,
                "Beet Seed",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30000,
                "Iron",
                "raw",
                50,
                0,
                0,
                10,
                5000,
                0,
                0,
                "",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30001,
                "Stone",
                "raw",
                0,
                0,
                0,
                10,
                5000,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30002,
                "Straw",
                "raw",
                0,
                0,
                0,
                150,
                75000,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30003,
                "Nails",
                "raw",
                1,
                0,
                0,
                1,
                500,
                0,
                0,
                "",
                1,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30004,
                "Feathers",
                "raw",
                0,
                0,
                0,
                15,
                7500,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30005,
                "Wood",
                "raw",
                0,
                0,
                0,
                10,
                5000,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30006,
                "3-leaf Clover",
                "item",
                50,
                0,
                0,
                50,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30007,
                "4-leaf Clover",
                "item",
                2500,
                0,
                0,
                2000,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30008,
                "Acorn",
                "item",
                50,
                0,
                0,
                50,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30009,
                "Amber",
                "item",
                100000,
                0,
                0,
                5000,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30010,
                "Amethyst",
                "item",
                500,
                0,
                0,
                50,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30011,
                "Ancient Coin",
                "item",
                1000,
                0,
                0,
                1000,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30012,
                "Antler",
                "item",
                250,
                0,
                0,
                250,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30013,
                "Apple",
                "item",
                50,
                0,
                0,
                25,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30014,
                "Aquamarine",
                "item",
                250,
                0,
                0,
                250,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30015,
                "Arrowhead",
                "item",
                150,
                0,
                0,
                150,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30016,
                "Bacon",
                "item",
                5000,
                0,
                0,
                2500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30017,
                "Bird Egg",
                "item",
                300,
                0,
                0,
                300,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30018,
                "Blue Feathers",
                "item",
                10,
                0,
                0,
                150,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30019,
                "Bone",
                "item",
                150,
                0,
                0,
                150,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30020,
                "Carbon Sphere",
                "item",
                500,
                0,
                0,
                200,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30021,
                "Coal",
                "item",
                50,
                0,
                0,
                50,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30022,
                "Diamond",
                "item",
                100000,
                0,
                0,
                5000,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30023,
                "Dice",
                "item",
                1750,
                0,
                0,
                1750,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30024,
                "Emberstone",
                "item",
                500,
                0,
                0,
                500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30025,
                "Feathers",
                "item",
                1,
                0,
                0,
                15,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30026,
                "Fern Leaf",
                "item",
                1,
                0,
                0,
                25,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30027,
                "Glass Orb",
                "item",
                60,
                0,
                0,
                300,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30028,
                "Gold Feather",
                "item",
                5000,
                0,
                0,
                1500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30029,
                "Gold Leaf",
                "item",
                5000,
                0,
                0,
                1500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30030,
                "Herbs",
                "item",
                3500,
                0,
                0,
                3500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30031,
                "Hide",
                "item",
                150,
                0,
                0,
                150,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30032,
                "Horn",
                "item",
                250,
                0,
                0,
                250,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30033,
                "Lemon",
                "item",
                25,
                0,
                0,
                25,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30034,
                "Lemon Quartz",
                "item",
                350,
                0,
                0,
                100,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30035,
                "Magicite",
                "item",
                25000,
                0,
                0,
                3000,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30036,
                "Magna Quartz",
                "item",
                2500,
                0,
                0,
                2500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30037,
                "Moonstone",
                "item",
                10000,
                0,
                0,
                1500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30038,
                "Mushroom",
                "item",
                1,
                0,
                0,
                10,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30039,
                "Oak",
                "item",
                100,
                0,
                0,
                100,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30040,
                "Orange",
                "item",
                25,
                0,
                0,
                25,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30041,
                "Pine Cone",
                "item",
                300,
                0,
                0,
                300,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30042,
                "Pocket Watch",
                "item",
                1750,
                0,
                0,
                1750,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30043,
                "Prism Shard",
                "item",
                2500,
                0,
                0,
                500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30044,
                "Purple Flower",
                "item",
                1,
                0,
                0,
                15,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30045,
                "Red Berries",
                "item",
                1000,
                0,
                0,
                1500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30046,
                "Salt Rock",
                "item",
                500,
                0,
                0,
                500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30047,
                "Sandstone",
                "item",
                50,
                0,
                0,
                50,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30048,
                "Shimmer Quartz",
                "item",
                450,
                0,
                0,
                125,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30049,
                "Skull Coin",
                "item",
                100000,
                0,
                0,
                5000,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30050,
                "Slimestone",
                "item",
                150,
                0,
                0,
                150,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30051,
                "Sour Root",
                "item",
                1000,
                0,
                0,
                1500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30052,
                "Spectacles",
                "item",
                1750,
                0,
                0,
                1750,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30053,
                "Star",
                "item",
                1000,
                0,
                0,
                1750,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30054,
                "Stone",
                "item",
                1,
                0,
                0,
                10,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30055,
                "Strange Letter",
                "item",
                2000,
                0,
                0,
                2000,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30056,
                "Striped Feather",
                "item",
                1000,
                0,
                0,
                1500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30057,
                "Sweet Root",
                "item",
                50,
                0,
                0,
                50,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30058,
                "Thorns",
                "item",
                1000,
                0,
                0,
                1500,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30059,
                "Unpolished Emerald",
                "item",
                750,
                0,
                0,
                250,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30060,
                "Unpolished Garnet",
                "item",
                5000,
                0,
                0,
                5000,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30061,
                "Unpolished Ruby",
                "item",
                500,
                0,
                0,
                150,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30062,
                "Unpolished Shimmer Stone",
                "item",
                10,
                0,
                0,
                50,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30063,
                "Wooden Mask",
                "item",
                1750,
                0,
                0,
                1750,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                30064,
                "Yarn",
                "item",
                250,
                0,
                0,
                1750,
                0,
                0,
                0,
                "",
                0,
                0,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40000,
                "Amethyst Necklace",
                "product",
                50,
                800,
                1,
                1000,
                500000,
                5,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40001,
                "Apple Cider",
                "food",
                5000,
                5000,
                5,
                100,
                50000,
                30,
                0,
                "",
                0,
                1,
                1000
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40002,
                "Aquamarine Ring",
                "product",
                50,
                750,
                1,
                1000,
                500000,
                5,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40003,
                "Axe",
                "product",
                25,
                200,
                1,
                450,
                225000,
                3,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40004,
                "Black Powder",
                "product",
                50,
                60,
                1,
                1500,
                750000,
                12,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40005,
                "Board",
                "product",
                1,
                30,
                1,
                25,
                12500,
                1,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40006,
                "Bottle Rocket",
                "product",
                100,
                150,
                1,
                300,
                150000,
                12,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40007,
                "Broom",
                "product",
                15,
                300,
                1,
                250,
                125000,
                3,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40008,
                "Bucket",
                "product",
                5,
                90,
                1,
                250,
                125000,
                1,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40010,
                "Coin Purse",
                "product",
                25,
                250,
                1,
                750,
                375000,
                8,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40011,
                "Compass",
                "product",
                250000,
                100000,
                100,
                50000,
                25000000,
                70,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40012,
                "Emerald",
                "product",
                100,
                2000,
                2,
                450,
                225000,
                10,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40013,
                "Emerald Ring",
                "product",
                300,
                2500,
                3,
                2500,
                1250000,
                15,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40014,
                "Explosive",
                "product",
                100,
                300,
                1,
                350,
                175000,
                14,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40015,
                "Fancy Guitar",
                "product",
                8550,
                65000,
                65,
                55000,
                27500000,
                80,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40016,
                "Fancy Pipe",
                "product",
                150,
                5000,
                5,
                5000,
                2500000,
                46,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40017,
                "Fishing Net",
                "product",
                100,
                1000,
                1,
                1500,
                750000,
                19,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40018,
                "Flywheel",
                "product",
                50000,
                10000,
                10,
                2500,
                1250000,
                50,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40019,
                "Garnet",
                "product",
                750,
                15000,
                15,
                15000,
                7500000,
                43,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40020,
                "Garnet Ring",
                "product",
                1500,
                30000,
                30,
                30000,
                15000000,
                51,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40021,
                "Glass Bottle",
                "product",
                25,
                10,
                1,
                150,
                75000,
                5,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40022,
                "Glass Orb",
                "product",
                10,
                60,
                1,
                300,
                150000,
                5,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40023,
                "Grape Juice",
                "product",
                500,
                10000,
                10,
                100,
                50000,
                1,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40024,
                "Green Cloak",
                "product",
                2500,
                125000,
                125,
                125000,
                62500000,
                55,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40025,
                "Green Diary",
                "product",
                10,
                150,
                1,
                200,
                100000,
                6,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40026,
                "Green Dye",
                "product",
                2,
                35,
                1,
                500,
                250000,
                5,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40027,
                "Green Parchment",
                "product",
                2,
                50,
                1,
                100,
                50000,
                2,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40029,
                "Green Shield",
                "product",
                500,
                5500,
                6,
                5500,
                2750000,
                30,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40030,
                "Hammer",
                "product",
                10,
                150,
                1,
                350,
                175000,
                2,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40031,
                "Horn Canteen",
                "product",
                150,
                2500,
                3,
                2500,
                1250000,
                16,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40032,
                "Horseshoe",
                "product",
                100,
                1000,
                1,
                1000,
                500000,
                24,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40033,
                "Hourglass",
                "product",
                2000,
                25000,
                25,
                25000,
                12500000,
                59,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40034,
                "Inferno Sphere",
                "product",
                1000000,
                2000000,
                2000,
                50000,
                25000000,
                22,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40035,
                "Iron Cup",
                "product",
                15,
                165,
                1,
                100,
                50000,
                1,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40036,
                "Iron Ring",
                "product",
                10,
                110,
                1,
                25,
                12500,
                4,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40037,
                "Jade",
                "product",
                500,
                5000,
                5,
                3000,
                1500000,
                33,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40038,
                "Jade Charm",
                "product",
                1000,
                15000,
                15,
                8000,
                4000000,
                42,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40039,
                "Ladder",
                "product",
                10,
                500,
                1,
                500,
                250000,
                9,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40040,
                "Lantern",
                "product",
                4000,
                40000,
                40,
                40000,
                20000000,
                70,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40041,
                "Lava Sphere",
                "product",
                2000000,
                4000000,
                4000,
                150000,
                75000000,
                35,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40042,
                "Leather",
                "product",
                25,
                250,
                1,
                250,
                125000,
                1,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40043,
                "Leather Bag",
                "product",
                250,
                3000,
                3,
                3000,
                1500000,
                17,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40044,
                "Leather Diary",
                "product",
                25,
                250,
                1,
                250,
                125000,
                8,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40045,
                "Leather Waterskin",
                "product",
                275,
                3250,
                4,
                3250,
                1625000,
                18,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40046,
                "Lemon Quartz Ring",
                "product",
                75,
                1500,
                2,
                1000,
                500000,
                7,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40047,
                "Lemonade",
                "food",
                2,
                35,
                1,
                500,
                250000,
                5,
                0,
                "",
                0,
                1,
                100
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40048,
                "Looking Glass",
                "product",
                50,
                250,
                1,
                2500,
                1250000,
                8,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40049,
                "Magicite",
                "product",
                5000,
                25000,
                25,
                3000,
                1500000,
                21,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40050,
                "Magna Core",
                "product",
                500000,
                2000000,
                2000,
                50000,
                25000000,
                60,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40051,
                "Magnifying Glass",
                "product",
                300,
                5250,
                6,
                5250,
                2625000,
                25,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40052,
                "Mushroom Paste",
                "product",
                2,
                50,
                1,
                25,
                12500,
                3,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40053,
                "Mystic Ring",
                "product",
                600,
                5000,
                5,
                5000,
                2500000,
                23,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40054,
                "Orange Juice",
                "food",
                2,
                35,
                1,
                500,
                250000,
                5,
                0,
                "",
                0,
                1,
                500
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40055,
                "Pearl Necklace",
                "product",
                100,
                1000,
                1,
                1000,
                500000,
                16,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40056,
                "Purple Diary",
                "product",
                10,
                150,
                1,
                200,
                100000,
                6,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40057,
                "Purple Parchment",
                "product",
                2,
                50,
                1,
                100,
                50000,
                2,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40058,
                "Rope",
                "product",
                50,
                5,
                1,
                1500,
                750000,
                18,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40059,
                "Ruby",
                "product",
                50,
                1500,
                2,
                350,
                175000,
                8,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40060,
                "Ruby Ring",
                "product",
                100,
                2000,
                2,
                1500,
                750000,
                10,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40061,
                "Sand",
                "product",
                750,
                500,
                1,
                250,
                125000,
                44,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40062,
                "Scissors",
                "product",
                250,
                1750,
                2,
                1750,
                875000,
                37,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40063,
                "Shimmer Ring",
                "product",
                1000,
                5000,
                5,
                5000,
                2500000,
                26,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40064,
                "Shimmer Stone",
                "product",
                5,
                25,
                1,
                250,
                125000,
                4,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40065,
                "Shimmer Topaz",
                "product",
                500,
                2500,
                3,
                2500,
                1250000,
                19,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40066,
                "Shovel",
                "product",
                45,
                300,
                1,
                550,
                275000,
                4,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40068,
                "Steel",
                "product",
                250,
                800,
                1,
                100,
                50000,
                15,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40069,
                "Steel Wire",
                "product",
                100,
                2000,
                2,
                1000,
                500000,
                50,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40070,
                "Sturdy Box",
                "product",
                15,
                275,
                1,
                500,
                250000,
                7,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40071,
                "Sturdy Shield",
                "product",
                500,
                4000,
                4,
                4000,
                2000000,
                20,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40072,
                "Sturdy Sword",
                "product",
                1500,
                11000,
                11,
                11000,
                5500000,
                45,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40073,
                "Treasure Chest",
                "product",
                1000,
                7500,
                8,
                7500,
                3750000,
                32,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40074,
                "Twine",
                "product",
                10,
                150,
                1,
                250,
                125000,
                5,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40075,
                "Unpolished Shimmer Stone",
                "product",
                10,
                10,
                1,
                50,
                25000,
                65,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40076,
                "Wagon Wheel",
                "product",
                250,
                1750,
                2,
                1750,
                875000,
                31,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40077,
                "White Parchment",
                "product",
                2,
                50,
                1,
                100,
                50000,
                2,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40078,
                "Wine",
                "product",
                250,
                1000,
                1,
                2000,
                1000000,
                1,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40079,
                "Wizard Hat",
                "product",
                300,
                3300,
                4,
                3300,
                1650000,
                17,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40080,
                "Wood Plank",
                "product",
                2,
                50,
                1,
                50,
                25000,
                1,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40081,
                "Wooden Barrel",
                "product",
                25,
                315,
                1,
                350,
                175000,
                10,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40082,
                "Wooden Box",
                "product",
                10,
                165,
                1,
                200,
                100000,
                1,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40083,
                "Wooden Shield",
                "product",
                75,
                500,
                1,
                450,
                225000,
                13,
                0,
                "",
                0,
                1,
                0
            )
        )
        inventoryDatabase.insert(
            Inventory(
                40084,
                "Wooden Sword",
                "product",
                250,
                1750,
                2,
                1750,
                875000,
                27,
                0,
                "",
                0,
                1,
                0
            )
        )

        finishRequirementDatabase.insert(FinishRequirement(0, "Board", "Wood", 5))
        finishRequirementDatabase.insert(FinishRequirement(0, "Bucket", "Board", 5))
        finishRequirementDatabase.insert(FinishRequirement(0, "Bucket", "Iron", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Grape Juice", "Glass Bottle", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Grape Juice", "Grapes", 200))
        finishRequirementDatabase.insert(FinishRequirement(0, "Iron Cup", "Iron", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Iron Cup", "Stone", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Leather", "Hide", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wine", "Glass Bottle", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wine", "Grapes", 100))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wood Plank", "Board", 4))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wood Plank", "Nails", 4))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wooden Box", "Nails", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wooden Box", "Wood Plank", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Parchment", "Fern Leaf", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Hammer", "Board", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Hammer", "Iron", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Hammer", "Mushroom Paste", 1))
        finishRequirementDatabase.insert(
            FinishRequirement(
                0,
                "Purple Parchment",
                "Purple Flower",
                3
            )
        )
        finishRequirementDatabase.insert(FinishRequirement(0, "White Parchment", "Feathers", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Axe", "Board", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Axe", "Iron", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Axe", "Mushroom Paste", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Axe", "Nails", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Axe", "Stone", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Broom", "Board", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Broom", "Straw", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Mushroom Paste", "Mushroom", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Iron Ring", "Iron", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Iron Ring", "Stone", 1))
        finishRequirementDatabase.insert(
            FinishRequirement(
                0,
                "Shimmer Stone",
                "Unpolished Shimmer Stone",
                2
            )
        )
        finishRequirementDatabase.insert(FinishRequirement(0, "Shovel", "Board", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Shovel", "Iron", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Shovel", "Mushroom Paste", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Shovel", "Stone", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Amethyst Necklace", "Amethyst", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Amethyst Necklace", "Iron Ring", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Aquamarine Ring", "Aquamarine", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Aquamarine Ring", "Iron Ring", 1))
        finishRequirementDatabase.insert(
            FinishRequirement(
                0,
                "Aquamarine Ring",
                "Mushroom Paste",
                1
            )
        )
        finishRequirementDatabase.insert(FinishRequirement(0, "Glass Bottle", "Glass Orb", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Glass Bottle", "Stone", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Glass Orb", "Shimmer Stone", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Glass Orb", "Stone", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Dye", "Fern Leaf", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Dye", "Glass Bottle", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lemonade", "Glass Bottle", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lemonade", "Lemon", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Orange Juice", "Glass Bottle", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Orange Juice", "Orange", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Twine", "Straw", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Twine", "Wood", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Diary", "Green Parchment", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Diary", "Mushroom Paste", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Diary", "White Parchment", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Purple Diary", "Mushroom Paste", 1))
        finishRequirementDatabase.insert(
            FinishRequirement(
                0,
                "Purple Diary",
                "Purple Parchment",
                1
            )
        )
        finishRequirementDatabase.insert(FinishRequirement(0, "Purple Diary", "White Parchment", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lemon Quartz Ring", "Iron Ring", 1))
        finishRequirementDatabase.insert(
            FinishRequirement(
                0,
                "Lemon Quartz Ring",
                "Lemon Quartz",
                1
            )
        )
        finishRequirementDatabase.insert(
            FinishRequirement(
                0,
                "Lemon Quartz Ring",
                "Mushroom Paste",
                1
            )
        )
        finishRequirementDatabase.insert(FinishRequirement(0, "Sturdy Box", "Iron", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Sturdy Box", "Nails", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Sturdy Box", "Wood Plank", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Coin Purse", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Coin Purse", "Leather", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Leather Diary", "Leather", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Leather Diary", "Mushroom Paste", 1))
        finishRequirementDatabase.insert(
            FinishRequirement(
                0,
                "Leather Diary",
                "White Parchment",
                1
            )
        )
        finishRequirementDatabase.insert(FinishRequirement(0, "Looking Glass", "Board", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Looking Glass", "Glass Orb", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Looking Glass", "Iron", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Ruby", "Stone", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Ruby", "Unpolished Ruby", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Ladder", "Board", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Ladder", "Nails", 8))
        finishRequirementDatabase.insert(FinishRequirement(0, "Emerald", "Stone", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Emerald", "Unpolished Emerald", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Ruby Ring", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Ruby Ring", "Mushroom Paste", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Ruby Ring", "Ruby", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wooden Barrel", "Board", 10))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wooden Barrel", "Iron", 4))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wooden Barrel", "Nails", 10))
        finishRequirementDatabase.insert(FinishRequirement(0, "Black Powder", "Coal", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Bottle Rocket", "Black Powder", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Bottle Rocket", "Feathers", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Bottle Rocket", "Wood", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wooden Shield", "Iron", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wooden Shield", "Nails", 4))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wooden Shield", "Wood Plank", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Explosive", "Black Powder", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Explosive", "Board", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Explosive", "Feathers", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Explosive", "Nails", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Emerald Ring", "Emerald", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Emerald Ring", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Emerald Ring", "Mushroom Paste", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Steel", "Carbon Sphere", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Steel", "Glass Orb", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Steel", "Iron", 10))
        finishRequirementDatabase.insert(FinishRequirement(0, "Horn Canteen", "Horn", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Horn Canteen", "Iron Ring", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Horn Canteen", "Twine", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Horn Canteen", "Wood", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Pearl Necklace", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Pearl Necklace", "Pearl", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Pearl Necklace", "Twine", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Leather Bag", "Iron Ring", 4))
        finishRequirementDatabase.insert(FinishRequirement(0, "Leather Bag", "Leather", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Leather Bag", "Twine", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wizard Hat", "Leather", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wizard Hat", "Purple Flower", 10))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wizard Hat", "Twine", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Leather Waterskin", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Leather Waterskin", "Leather", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Leather Waterskin", "Twine", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Rope", "Twine", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Fishing Net", "Antler", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Fishing Net", "Iron", 4))
        finishRequirementDatabase.insert(FinishRequirement(0, "Fishing Net", "Rope", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Shimmer Topaz", "Shimmer Quartz", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Sturdy Shield", "Iron", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Sturdy Shield", "Nails", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Sturdy Shield", "Wood Plank", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Magicite", "Prism Shard", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Inferno Sphere", "Runestone 01", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Inferno Sphere", "Runestone 02", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Inferno Sphere", "Runestone 03", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Inferno Sphere", "Runestone 04", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Inferno Sphere", "Runestone 05", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Inferno Sphere", "Runestone 06", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Inferno Sphere", "Runestone 07", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Inferno Sphere", "Runestone 08", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Inferno Sphere", "Runestone 09", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Inferno Sphere", "Runestone 10", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Mystic Ring", "Aquamarine", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Mystic Ring", "Emerald", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Mystic Ring", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Mystic Ring", "Mushroom Paste", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Mystic Ring", "Stone", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Horseshoe", "Iron", 5))
        finishRequirementDatabase.insert(FinishRequirement(0, "Horseshoe", "Nails", 7))
        finishRequirementDatabase.insert(FinishRequirement(0, "Horseshoe", "Stone", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Magnifying Glass", "Board", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Magnifying Glass", "Glass Orb", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Magnifying Glass", "Iron", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Magnifying Glass", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Shimmer Ring", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Shimmer Ring", "Mushroom Paste", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Shimmer Ring", "Shimmer Topaz", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wooden Sword", "Board", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wooden Sword", "Iron", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wooden Sword", "Twine", 4))
        finishRequirementDatabase.insert(FinishRequirement(0, "Apple Cider", "Apple", 100))
        finishRequirementDatabase.insert(FinishRequirement(0, "Apple Cider", "Glass Bottle", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Apple Cider", "Orange", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Scarf", "Green Dye", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Scarf", "Yarn", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Shield", "Green Dye", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Shield", "Iron", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Shield", "Wooden Shield", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wagon Wheel", "Board", 12))
        finishRequirementDatabase.insert(FinishRequirement(0, "Wagon Wheel", "Nails", 14))
        finishRequirementDatabase.insert(FinishRequirement(0, "Treasure Chest", "Iron", 12))
        finishRequirementDatabase.insert(FinishRequirement(0, "Treasure Chest", "Nails", 22))
        finishRequirementDatabase.insert(FinishRequirement(0, "Treasure Chest", "Wood Plank", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Jade", "Stone", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Jade", "Unpolished Jade", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lava Sphere", "Runestone 11", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lava Sphere", "Runestone 12", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lava Sphere", "Runestone 13", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lava Sphere", "Runestone 14", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lava Sphere", "Runestone 15", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lava Sphere", "Runestone 16", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lava Sphere", "Runestone 17", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lava Sphere", "Runestone 18", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lava Sphere", "Runestone 19", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lava Sphere", "Runestone 20", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Scissors", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Scissors", "Nails", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Scissors", "Steel", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Scissors", "Stone", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Scissors", "Wood", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Jade Charm", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Jade Charm", "Jade", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Jade Charm", "Steel", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Jade Charm", "Stone", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Garnet", "Stone", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Garnet", "Unpolished Garnet", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Sand", "Leather", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Sand", "Sandstone", 5))
        finishRequirementDatabase.insert(FinishRequirement(0, "Sturdy Sword", "Iron", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Sturdy Sword", "Leather", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Sturdy Sword", "Mushroom Paste", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Sturdy Sword", "Steel", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Fancy Pipe", "Iron", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Fancy Pipe", "Iron Ring", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Fancy Pipe", "Wood", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Flywheel", "Small Gear", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Flywheel", "Small Screw", 7))
        finishRequirementDatabase.insert(FinishRequirement(0, "Flywheel", "Steel", 20))
        finishRequirementDatabase.insert(FinishRequirement(0, "Steel Wire", "Carbon Sphere", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Steel Wire", "Iron", 10))
        finishRequirementDatabase.insert(FinishRequirement(0, "Steel Wire", "Stone", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Garnet Ring", "Garnet", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Garnet Ring", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Garnet Ring", "Mushroom Paste", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Cloak", "Cotton", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Cloak", "Green Dye", 10))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Cloak", "Leather", 5))
        finishRequirementDatabase.insert(FinishRequirement(0, "Green Cloak", "Twine", 10))
        finishRequirementDatabase.insert(FinishRequirement(0, "Hourglass", "Glass Bottle", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Hourglass", "Mushroom Paste", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Hourglass", "Sand", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Hourglass", "Wood", 6))
        finishRequirementDatabase.insert(FinishRequirement(0, "Magna Core", "Cogwheel", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Magna Core", "Flywheel", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Magna Core", "Magna Quartz", 25))
        finishRequirementDatabase.insert(FinishRequirement(0, "Magna Core", "Seeing Stone", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Magna Core", "Small Screw", 10))
        finishRequirementDatabase.insert(FinishRequirement(0, "Magna Core", "Small Spring", 5))
        finishRequirementDatabase.insert(FinishRequirement(0, "Magna Core", "Steel", 40))
        finishRequirementDatabase.insert(
            FinishRequirement(
                0,
                "Unpolished Shimmer Stone",
                "Emberstone",
                1
            )
        )
        finishRequirementDatabase.insert(
            FinishRequirement(
                0,
                "Unpolished Shimmer Stone",
                "Sandstone",
                1
            )
        )
        finishRequirementDatabase.insert(FinishRequirement(0, "Compass", "Aquamarine", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Compass", "Glass Orb", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Compass", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Compass", "Magna Core", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Compass", "Ruby", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Compass", "Small Screw", 4))
        finishRequirementDatabase.insert(FinishRequirement(0, "Compass", "Twine", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Compass", "Wood", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lantern", "Coal", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lantern", "Glass Bottle", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lantern", "Iron", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lantern", "Iron Ring", 1))
        finishRequirementDatabase.insert(FinishRequirement(0, "Lantern", "Twine", 2))
        finishRequirementDatabase.insert(FinishRequirement(0, "Fancy Guitar", "Iron", 4))
        finishRequirementDatabase.insert(FinishRequirement(0, "Fancy Guitar", "Mushroom Paste", 3))
        finishRequirementDatabase.insert(FinishRequirement(0, "Fancy Guitar", "Oak", 5))
        finishRequirementDatabase.insert(FinishRequirement(0, "Fancy Guitar", "Steel Wire", 6))

        questDatabase.insert(Quest(0, "Quest 1", "Quest 1","Wood", 5, "", 0, 0))
        questDatabase.insert(Quest(0, "Quest 1", "Quest 1","Iron", 5, "", 0, 0))
        questDatabase.insert(Quest(0, "Quest 2", "Quest 2","Wood", 10, "", 0, 0))
        questDatabase.insert(Quest(0, "Quest 2", "Quest 2","Iron", 10, "", 0, 0))

        questRewardDatabase.insert(QuestReward(0,"Quest 1","Money", 100 ))
        questRewardDatabase.insert(QuestReward(0,"Quest 1","Wood", 10 ))
        questRewardDatabase.insert(QuestReward(0,"Quest 1","Iron", 10 ))
        questRewardDatabase.insert(QuestReward(0,"Quest 1","Gold", 10 ))

    }
}
