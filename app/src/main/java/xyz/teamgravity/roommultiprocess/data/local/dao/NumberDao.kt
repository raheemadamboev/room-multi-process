package xyz.teamgravity.roommultiprocess.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.roommultiprocess.data.local.constant.NumberConst.TABLE_NUMBER
import xyz.teamgravity.roommultiprocess.data.local.entity.NumberEntity

@Dao
interface NumberDao {

    ///////////////////////////////////////////////////////////////////////////
    // INSERT
    ///////////////////////////////////////////////////////////////////////////

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNumber(number: NumberEntity)

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    @Query("SELECT * FROM $TABLE_NUMBER ORDER BY id DESC LIMIT 1")
    fun getLastNumber(): Flow<NumberEntity?>
}