package com.dubaiza.clean.demo.data.local.entity

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "employees")
data class EmployeeEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val designation: String,
    val department: String,
)
