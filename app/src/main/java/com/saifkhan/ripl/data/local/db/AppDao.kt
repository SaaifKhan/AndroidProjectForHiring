package com.saifkhan.ripl.data.local.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saifkhan.ripl.data.models.MasterModel

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEntry(model:MasterModel)

    @Query("SELECT * FROM MasterModel")
    fun getAllItem(): LiveData<List<MasterModel>>








}