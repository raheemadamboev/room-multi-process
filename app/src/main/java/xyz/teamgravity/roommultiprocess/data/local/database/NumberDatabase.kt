package xyz.teamgravity.roommultiprocess.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import xyz.teamgravity.roommultiprocess.data.local.constant.NumberConst
import xyz.teamgravity.roommultiprocess.data.local.dao.NumberDao
import xyz.teamgravity.roommultiprocess.data.local.entity.NumberEntity

@Database(
    entities = [NumberEntity::class],
    version = NumberConst.VERSION,
    exportSchema = false
)
abstract class NumberDatabase : RoomDatabase() {

    abstract fun numberDao(): NumberDao
}