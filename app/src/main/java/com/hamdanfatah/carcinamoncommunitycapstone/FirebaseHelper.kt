package com.hamdanfatah.carcinamoncommunitycapstone

import com.google.firebase.database.FirebaseDatabase

class FirebaseHelper {
    private val database = FirebaseDatabase.getInstance()
    private val usersRef = database.getReference("users")

    fun writeData(name: String, email: String, age: Int) {
        val userId = usersRef.push().key // Membuat ID unik untuk data baru

        val userData = HashMap<String, Any>()
        userData["name"] = name
        userData["email"] = email
        userData["age"] = age

        if (userId != null) {
            usersRef.child(userId).setValue(userData)
                .addOnSuccessListener {
                    // Data berhasil ditulis
                }
                .addOnFailureListener { exception ->
                    // Gagal menulis data
                }
        }
    }
}
