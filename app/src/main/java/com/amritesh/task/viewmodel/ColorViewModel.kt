package com.amritesh.task.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.amritesh.task.data.ColorDao
import com.amritesh.task.data.ColorDatabase
import com.amritesh.task.data.ColorEntity
import com.amritesh.task.repository.ColorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ColorViewModel(application: Application) : AndroidViewModel(application) {

    private val colorDao: ColorDao = ColorDatabase.getDatabase(application).colorDao()
    private val colorRepository = ColorRepository(colorDao)

    private val _unsyncedCount = MutableLiveData<Int>(0)
    val unsyncedCount: LiveData<Int> = _unsyncedCount

    // LiveData to observe all colors from the database
    val allColors: LiveData<List<ColorEntity>> = colorDao.getAllColors()

    // Function to add a color to the Room database
    fun addColor(colorCode: String, creationTime: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            colorDao.insert(ColorEntity(colorCode = colorCode, creationTime = creationTime))
        }
    }

    // Function to sync colors with Firebase
    fun syncColors() {
        viewModelScope.launch(Dispatchers.IO) {
            val unsyncedColors = colorDao.getUnsyncedColors()
            if (unsyncedColors.isNotEmpty()) {
                colorRepository.syncColorsToCloud()
            }
        }
    }
}
