package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1XmlLocalDataSource(context : Context) {
    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.app_name), Context.MODE_PRIVATE)
    private val gson = Gson()

    fun getUsers(): List<User> {
        val list = mutableListOf<User>()
        val user = sharedPref.all.filter { it.key.contains("user") }

        user.forEach {
            list.add(gson.fromJson(it.value.toString(), User::class.java))
        }
        return list
    }
    fun getProducts(): List<Item> {
        val list = mutableListOf<Item>()
        val product = sharedPref.all.filter { it.key.contains("product")  }

        product.forEach {
            list.add(gson.fromJson(it.value.toString(), Item::class.java))
        }
        return list

    }

    fun getServices(): List<Services> {
       val list = mutableListOf<Services>()
        val service = sharedPref.all.filter { it.key.contains("service") }

        service.forEach {
            list.add(gson.fromJson(it.value.toString(), Services::class.java))
        }
        return list

    }
    fun saveUsers(users: List<User>) {
        users.forEach {
            sharedPref.edit().putString("user${it.id}", gson.toJson(it)).apply()
        }
    }
    fun saveProducts(products: List<Item>) {
        products.forEach {
            sharedPref.edit().putString("product${it.id}", gson.toJson(it)).apply()
        }
    }
    fun saveServices(services: List<Services>) {
        services.forEach {
            sharedPref.edit().putString("service${it.id}", gson.toJson(it)).apply()
        }
    }

}