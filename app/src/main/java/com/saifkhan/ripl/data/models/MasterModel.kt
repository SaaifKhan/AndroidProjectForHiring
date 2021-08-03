package com.saifkhan.ripl.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MasterModel(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val disId: Int,
        val disName: String?,
        val provId: Int,
        val ProvName: String?,
        val tehId: Int,
        val tehName: String?,
        val SerialNum: Int,
        val NameOfPerson: String?,
        val FatherName: String,
        val MotherName: String?,
        val Address: String,
        val mobileNumber: String?,
        val DateofBirth: String,
        val Age: String?,
        val Gender: String,
        val MartialStatus: String?,
        val education: String?,
        val occupation: String?,
        val noOfChildren: String?,
        val Pregnant: String?,
)