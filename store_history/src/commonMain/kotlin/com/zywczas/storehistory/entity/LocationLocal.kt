package com.zywczas.storehistory.entity

//todo update to KMM

//@Entity("Location")
data class LocationLocal(
//    @PrimaryKey @ColumnInfo(name = "name")
    val name: String,
//    @ColumnInfo(name = "lat")
    val lat: Double,
//    @ColumnInfo(name = "lon")
    val lon: Double,
)
