package com.example.retrofitapplication.interfaces

import com.example.retrofitapplication.models.Product
import com.example.retrofitapplication.room.ProductEntity
import javax.inject.Inject

class CacheMapper
@Inject
constructor()
    : EntityMapper<ProductEntity, Product>{
    override fun mapFromEntity(entity: ProductEntity): Product {
        return Product(
            id = entity.id,
            title = entity.title,
            price = entity.price,
            description  = entity.description,
            category = entity.category,
            image = entity.image,
            rating = entity.rating
        )
    }

    override fun mapToEntity(domainModel: Product): ProductEntity {
        return ProductEntity(
            id = domainModel.id,
            title = domainModel.title,
            price = domainModel.price,
            description  = domainModel.description,
            category = domainModel.category,
            image = domainModel.image,
            rating = domainModel.rating
        )
    }

    fun mapFromEntityList(entities : List<ProductEntity>) : List<Product>{
        return entities.map { mapFromEntity(it) }
    }
}