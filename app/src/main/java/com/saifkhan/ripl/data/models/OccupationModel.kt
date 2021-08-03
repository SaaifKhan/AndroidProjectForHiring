package com.saif.hiringproject.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OccupationModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val occName: String?,
)