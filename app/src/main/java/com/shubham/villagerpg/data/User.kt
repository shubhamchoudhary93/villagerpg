package com.shubham.villagerpg.data

data class User(
    var name: String = "Shubham",
    var xp: Long = 0L,
    var level: Int = 0,
    var nextXp:Long = 1250L,
    var money: Long = 0L,
    var food: Long = 100L,
    var gold: Int = 0,
    var lastOnline: Long = 0L,
    var farmStatus: MutableList<Int> = mutableListOf<Int>(
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
    ),
    var campStatus: MutableList<Int> = mutableListOf<Int>(
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
    ),
    var factoryStatus: MutableList<Int> = mutableListOf<Int>(
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
    ),
    var kitchenStatus: MutableList<Int> = mutableListOf<Int>(
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
    ),
    var farmCrop: MutableList<String> = mutableListOf<String>(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    ),
    var produceItem: MutableList<String> = mutableListOf<String>(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    ),
    var manufactureItem: MutableList<String> = mutableListOf<String>(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    ),
    var foodItem: MutableList<String> = mutableListOf<String>(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    ),
    var plantStopTime: MutableList<Long> = mutableListOf<Long>(
        0L,
        0L,
        0L,
        0L,
        0L,
        0L,
        0L,
        0L
    ),
    var produceStopTime: MutableList<Long> = mutableListOf<Long>(
        0L,
        0L,
        0L,
        0L,
        0L,
        0L,
        0L,
        0L
    ),
    var manufactureStopTime: MutableList<Long> = mutableListOf<Long>(
        0L,
        0L,
        0L,
        0L,
        0L,
        0L,
        0L,
        0L
    ),
    var cookingStopTime: MutableList<Long> = mutableListOf<Long>(
        0L,
        0L,
        0L,
        0L,
        0L,
        0L,
        0L,
        0L
    )
)


