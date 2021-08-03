package com.saifkhan.ripl.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saif.hiringproject.data.models.DistrictModel
import com.saif.hiringproject.data.models.ProvinceModel
import com.saif.hiringproject.data.models.TeshsilModel
import com.saifkhan.ripl.constants.AppConstants
import com.saifkhan.ripl.data.models.MasterModel
import com.saifkhan.ripl.data.models.PostsResponseItem


@Database(
    entities = [DistrictModel::class, TeshsilModel::class, ProvinceModel::class, MasterModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

    companion object {

        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
                instance ?: synchronized(this) {
                            instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
                Room.databaseBuilder(appContext, AppDatabase::class.java, AppConstants.DbConfiguration.DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
    }

}

private lateinit var INSTANCE: AppDatabase

