package com.zywczas.storehistory.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zywczas.storehistory.dao.LocationDao
import com.zywczas.storehistory.entity.LocationLocal

@Database(
    entities = [
        LocationLocal::class
    ],
    version = 1
)
internal abstract class HistoryDatabase : RoomDatabase() {

    abstract fun locationDao(): LocationDao
}
