package com.amritesh.task.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "colors")
data class ColorEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "colorCode") val colorCode: String,
    @ColumnInfo(name = "creationTime") val creationTime: Long,
    @ColumnInfo(name = "synced") val synced: Boolean = false
)


