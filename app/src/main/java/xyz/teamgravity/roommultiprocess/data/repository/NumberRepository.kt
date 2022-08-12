package xyz.teamgravity.roommultiprocess.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import xyz.teamgravity.roommultiprocess.data.local.dao.NumberDao
import xyz.teamgravity.roommultiprocess.data.mapper.toEntity
import xyz.teamgravity.roommultiprocess.data.mapper.toModel
import xyz.teamgravity.roommultiprocess.data.model.NumberModel

class NumberRepository(
    private val dao: NumberDao,
) {

    ///////////////////////////////////////////////////////////////////////////
    // INSERT
    ///////////////////////////////////////////////////////////////////////////

    suspend fun insertNumber(number: NumberModel) {
        withContext(Dispatchers.IO) {
            dao.insertNumber(number.toEntity())
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    fun getLastNumber(): Flow<NumberModel?> {
        return dao.getLastNumber().map { it?.toModel() }
    }
}