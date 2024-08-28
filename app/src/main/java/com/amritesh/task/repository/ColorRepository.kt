package com.amritesh.task.repository

import com.amritesh.task.data.ColorDao
import com.amritesh.task.data.ColorEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ColorRepository(private val colorDao: ColorDao) {

    suspend fun getAllColors(): List<ColorEntity> = withContext(Dispatchers.IO) {
        colorDao.getAllColors().value ?: emptyList() // Access the LiveData value
    }

    suspend fun insertColor(colorEntity: ColorEntity) = withContext(Dispatchers.IO) {
        colorDao.insert(colorEntity)
    }

    suspend fun getUnsyncedCount(): Int = withContext(Dispatchers.IO) {
        colorDao.getUnsyncedColorsCount()
    }

    suspend fun syncColorsToCloud() = withContext(Dispatchers.IO) {
        val unsyncedColors = colorDao.getUnsyncedColors()

        if (unsyncedColors.isNotEmpty()) {
            syncColors(unsyncedColors)
        }
    }

    private suspend fun syncColors(colors: List<ColorEntity>) {
        for (color in colors) {
            try {
                // Add Firebase or Google Sheets syncing logic here
                // Example: Firebase.firestore.collection("colors").add(color)

                // Update color entry as synced after successful upload
                colorDao.updateSyncStatus(color.id, true)
            } catch (e: Exception) {
                // Handle exceptions more robustly in production
                e.printStackTrace()
            }
        }
    }
}
