package com.zywczas.storehistory.dao

import com.zywczas.storehistory.entity.LocationLocal
//todo update to KMM

//@Dao
interface LocationDao {

//    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(model: LocationLocal): Long

//    @Query("SELECT * FROM Location")
    suspend fun getLocations(): List<LocationLocal>
}
