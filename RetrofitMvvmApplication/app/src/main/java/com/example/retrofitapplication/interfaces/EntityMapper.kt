package com.example.retrofitapplication.interfaces

interface EntityMapper <Entity, DomainModel> {

    fun mapFromEntity(entity: Entity) : DomainModel

    fun mapToEntity(domainModel : DomainModel) : Entity
}