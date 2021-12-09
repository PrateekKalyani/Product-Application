package com.example.retrofitapplication.interfaces

import com.example.retrofitapplication.models.Product
import com.example.retrofitapplication.ProductModel
import javax.inject.Inject

class NetworkMapper
    @Inject
    constructor()
    : EntityMapper<ProductModel, Product>
{
    override fun mapFromEntity(entity: ProductModel): Product {

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

    override fun mapToEntity(domainModel: Product): ProductModel {

        return ProductModel(
            id = domainModel.id,
            title = domainModel.title,
            price = domainModel.price,
            description  = domainModel.description,
            category = domainModel.category,
            image = domainModel.image,
            rating = domainModel.rating
        )
    }

    fun mapFromEntityList(entities : List<ProductModel>) : List<Product>{
        return entities.map { mapFromEntity(it) }
    }
}