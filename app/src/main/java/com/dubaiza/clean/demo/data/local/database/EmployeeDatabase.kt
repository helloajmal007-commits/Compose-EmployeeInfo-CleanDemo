package com.dubaiza.clean.demo.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room
import com.dubaiza.clean.demo.data.local.dao.EmployeeDao
import com.dubaiza.clean.demo.data.local.entity.EmployeeEntity

@Database(entities = [EmployeeEntity::class], version = 1, exportSchema = false)
abstract class EmployeeDatabase : RoomDatabase(){

    abstract fun employeeDao(): EmployeeDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "employee_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}