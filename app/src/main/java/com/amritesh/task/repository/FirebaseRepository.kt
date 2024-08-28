package com.amritesh.task.repository

import com.amritesh.task.data.ColorEntity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseRepository {

    private val database = Firebase.database.reference

    fun syncColorsToFirebase(colors: List<ColorEntity>, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val colorList = colors.map { color ->
            mapOf(
                "colorCode" to color.colorCode,
                "creationTime" to color.creationTime
            )
        }

        database.child("colors").setValue(colorList)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it)
            }
    }
}
