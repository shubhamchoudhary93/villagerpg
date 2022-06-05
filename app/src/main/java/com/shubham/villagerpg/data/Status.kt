package com.shubham.villagerpg.data

//farm,produce,manufacture,kitchen[status-- Int 0 or 1, item-- string, stopTime-- long]
data class Status(
    var status: Int = 0,
    var item: String = "",
    var stopTime: Long = 0L
)
