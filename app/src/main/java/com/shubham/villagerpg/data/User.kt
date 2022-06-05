package com.shubham.villagerpg.data

data class User(
    var name: String = "Shubham",
    var xp: Long = 0L,
    var level: Int = 0,
    var nextXp: Long = 1250L,
    var money: Long = 0L,
    var food: Long = 100L,
    var gold: Int = 0,
    var lastOnline: Long = 0L,
    var lastOnlineStamina: Long = 0L,
    var farm: MutableList<Status> = mutableListOf(
        Status(),
        Status(),
        Status(),
        Status(),
        Status(),
        Status(),
        Status(),
        Status()
    ),
    var camp: MutableList<Status> = mutableListOf(
        Status(),
        Status(),
        Status(),
        Status(),
        Status(),
        Status(),
        Status(),
        Status()
    ),
    var factory: MutableList<Status> = mutableListOf(
        Status(),
        Status(),
        Status(),
        Status(),
        Status(),
        Status(),
        Status(),
        Status()
    ),
    var kitchen: MutableList<Status> = mutableListOf(
        Status(),
        Status(),
        Status(),
        Status(),
        Status(),
        Status(),
        Status(),
        Status()
    )
)


