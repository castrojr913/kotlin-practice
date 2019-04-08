package com.jacr.pruebatecnica.model.data.mapper

/**
 * Created: 4/7/19.
 * Author: jesus.castro
 */
abstract class ModelMapper<Entity, Dto> {

    abstract fun fromEntity(entity: Entity?): Dto

}