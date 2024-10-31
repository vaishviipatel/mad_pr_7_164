package com.example.mad_p7

import org.json.JSONObject
import java.io.Serializable

data class Person(
    val id: String,
    val name: String,
    val emailId: String,
    val phoneNo: String,
    val address: String,
    val latitude: Double,
    val longitude: Double
) : Serializable {
    companion object {
        fun fromJson(jsonObject: JSONObject): Person {
            // Extracting main fields
            val id = jsonObject.getString("id")
            val emailId = jsonObject.getString("email")
            val phoneNo = jsonObject.getString("phone")

            // Extracting nested fields
            val profileObject = jsonObject.getJSONObject("profile")
            val name = profileObject.getString("name")
            val address = profileObject.getString("address")

            val locationObject = profileObject.getJSONObject("location")
            val latitude = locationObject.getDouble("lat")
            val longitude = locationObject.getDouble("long")

            // Creating and returning the Person object
            return Person(
                id = id,
                name = name,
                emailId = emailId,
                phoneNo = phoneNo,
                address = address,
                latitude = latitude,
                longitude = longitude
            )
        }
    }
}
