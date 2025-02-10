package com.zywczas.storehistory.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zywczas.storehistory.entity.LocationLocal

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(model: LocationLocal): Long

    @Query("SELECT * FROM Location")
    suspend fun getLocations(): List<LocationLocal>
}
