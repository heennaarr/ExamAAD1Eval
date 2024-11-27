package edu.iesam.examaad1eval.features.ex1.data

import android.util.Log
import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1DataRepository (
    private val remoteDataSource: MockEx1RemoteDataSource,
    private val localDataSource: Ex1XmlLocalDataSource
): Ex1Repository {
    override fun getUsers(): List<User> {
        return if (localDataSource.getUsers().isEmpty()) {
            val users = remoteDataSource.getUsers()
            localDataSource.saveUsers(users)
            users
        } else {
            localDataSource.getUsers()

        }
    }
    override fun getItems(): List<Item> {
        return if (localDataSource.getProducts().isEmpty()) {
            val items = remoteDataSource.getItems()
            localDataSource.saveProducts(items)
            items
        } else {
            localDataSource.getProducts()

        }
    }
    override fun getServices(): List<Services> {
        return if (localDataSource.getServices().isEmpty()) {
            val services = remoteDataSource.getServices()
            localDataSource.saveServices(services)
            services
        } else {
            localDataSource.getServices()
        }
    }
}
