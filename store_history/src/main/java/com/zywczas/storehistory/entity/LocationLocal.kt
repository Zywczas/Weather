package com.zywczas.storehistory.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Location")
data class LocationLocal(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "lat") val lat: Double = 0.0,
    @ColumnInfo(name = "lon") val lon: Double = 0.0,
)
