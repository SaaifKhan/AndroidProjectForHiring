package com.saif.hiringproject.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TeshsilModel(


    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val tehName: String?,
)