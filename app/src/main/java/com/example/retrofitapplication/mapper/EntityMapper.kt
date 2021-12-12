package com.example.retrofitapplication.mapper

import com.example.retrofitapplication.models.ProductModel
import com.example.retrofitapplication.models.RatingModel
import com.example.retrofitapplication.room.ProductEntity
import javax.inject.Inject

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity) : DomainModel

    fun mapToEntity(domainModel : DomainModel) : Entity

    fun mapFromEntityList(entityList : List<Entity>) : List<DomainModel>

    fun mapToEntityList(domainModelList : List<DomainModel>) : List<Entity>
}

class CacheMapper
@Inject
constructor() : EntityMapper<ProductEntity, ProductModel> {

    override fun mapFromEntity(entity: ProductEntity): ProductModel {
        return ProductModel(
            id = entity.id,
            title = entity.title,
            price = entity.price,
            description  = entity.description,
            category = entity.category,
            image = entity.image,
            rating = RatingModel(
                rate = entity.rate,
                count = entity.count
            )
        )
    }

    override fun mapToEntity(domainModel: ProductModel): ProductEntity {
        return ProductEntity(
            id = domainModel.id,
            title = domainModel.title,
            price = domainModel.price,
            description  = domainModel.description,
            category = domainModel.category,
            image = domainModel.image,
            rate = domainModel.rating.rate,
            count = domainModel.rating.count
        )
    }

    override fun mapFromEntityList(entityList : List<ProductEntity>) : List<ProductModel> {
        return entityList.map { mapFromEntity(it) }
    }

    override fun mapToEntityList(domainModelList: List<ProductModel>): List<ProductEntity> {
        return domainModelList.map { mapToEntity(it) }
    }
}