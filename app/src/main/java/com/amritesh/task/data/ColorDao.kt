package com.amritesh.task.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ColorDao {

    @Query("SELECT * FROM colors")
    fun getAllColors(): LiveData<List<ColorEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(colorEntity: ColorEntity)

    @Query("SELECT COUNT(*) FROM colors WHERE synced = 0")
    suspend fun getUnsyncedColorsCount(): Int

    @Query("SELECT * FROM colors WHERE synced = 0")
    suspend fun getUnsyncedColors(): List<ColorEntity>

    @Query("UPDATE colors SET synced = :isSynced WHERE id = :colorId")
    suspend fun updateSyncStatus(colorId: Int, isSynced: Boolean)


}

