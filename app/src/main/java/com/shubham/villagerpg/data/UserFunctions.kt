package com.shubham.villagerpg.data

import android.content.SharedPreferences
import com.google.gson.Gson

object UserFunctions {
    fun fetchUser(data: SharedPreferences): User {
        val gson = Gson()
        val json: String? = data.getString("User", "")
        return gson.fromJson(json, User::class.java)
    }

    fun saveUser(user: User, data: SharedPreferences) {
        val prefsEditor: SharedPreferences.Editor = data.edit()
        val gson = Gson()
        val json: String = gson.toJson(user)
        prefsEditor.putString("User", json)
        prefsEditor.apply()
    }
}