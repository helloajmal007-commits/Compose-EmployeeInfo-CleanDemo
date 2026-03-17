package com.dubaiza.clean.demo.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dubaiza.clean.demo.data.local.entity.EmployeeEntity
 import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployee(employee: EmployeeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployees(employees: List<EmployeeEntity>)

    @Update
    suspend fun updateEmployee(employee: EmployeeEntity)

    @Delete
    suspend fun deleteEmployee(employee: EmployeeEntity)

    @Query("DELETE FROM employees")
    suspend fun deleteAllEmployees()

    @Query("SELECT * FROM employees ORDER BY name ASC")
    fun getAllEmployees(): Flow<List<EmployeeEntity>>

    @Query("SELECT * FROM employees WHERE id = :id")
    suspend fun getEmployeeById(id: Int): EmployeeEntity?

}