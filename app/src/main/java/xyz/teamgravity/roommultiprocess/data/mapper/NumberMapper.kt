package xyz.teamgravity.roommultiprocess.data.mapper

import xyz.teamgravity.roommultiprocess.data.local.entity.NumberEntity
import xyz.teamgravity.roommultiprocess.data.model.NumberModel

fun NumberEntity.toModel(): NumberModel {
    return NumberModel(
        id = id,
        number = number
    )
}

fun NumberModel.toEntity(): NumberEntity {
    return NumberEntity(
        id = id,
        number = number
    )
}