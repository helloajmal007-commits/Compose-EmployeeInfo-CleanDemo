package com.dubaiza.clean.demo.data.local.database

import com.dubaiza.clean.demo.data.local.dao.EmployeeDao
import com.dubaiza.clean.demo.data.local.entity.EmployeeEntity




import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [EmployeeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao
}

