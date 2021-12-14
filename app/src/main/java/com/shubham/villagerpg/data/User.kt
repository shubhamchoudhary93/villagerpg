package com.shubham.villagerpg.data

data class User(
    var name: String = "Shubham",
    var xp: Long = 0L,
    var level: Int = 0,
    var money: Long = 0L,
    var stamina: Long = 100L,
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
    var farmCrop: MutableList<Int> = mutableListOf<Int>(
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
    ),
    var produceItem: MutableList<Int> = mutableListOf<Int>(
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
    ),
    var manufactureItem: MutableList<Int> = mutableListOf<Int>(
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
    ),
    var foodItem: MutableList<Int> = mutableListOf<Int>(
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
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


