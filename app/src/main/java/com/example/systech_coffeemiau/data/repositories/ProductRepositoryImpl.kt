package com.example.systech_coffeemiau.data.repositories

import com.example.systech_coffeemiau.data.sources.local.LocalProductoDataSource
import com.example.systech_coffeemiau.data.sources.remote.RemoteProductoDataSource
import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.domain.repositories.IProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteProductoDataSource,
    private val localDataSource: LocalProductoDataSource
): IProductRepository {
    override suspend fun getProductList(): List<Product> {
        return try {
            remoteDataSource.getProductListFromApi()
        } catch (e: Exception) {
            remoteDataSource.getProductListFromApi()
        }
    }

    override suspend fun getProduct(id: Long): Product {
        return try {
            remoteDataSource.getProductFromApi(id)
        } catch (e: Exception) {
            localDataSource.getProductFromJson(id)
        }
    }
}