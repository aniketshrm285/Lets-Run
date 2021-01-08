package com.androiddevs.runningappyt.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run:Run)

    @Delete
    suspend fun deleteRun(run:Run)

    @Query("SELECT * FROM running_table ORDER BY timeStamp DESC") // Latest runs will be on top
    fun getAllRunsSortedByDate():LiveData<List<Run>>  // Not a suspend function because we want to observe it with live data.


    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC") // Latest runs will be on top
    fun getAllRunsSortedByTimeInMillis():LiveData<List<Run>>  // Not a suspend function because we want to observe it with live data.

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC") // Latest runs will be on top
    fun getAllRunsSortedByCaloriesBurned():LiveData<List<Run>>  // Not a suspend function because we want to observe it with live data.

    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMH DESC") // Latest runs will be on top
    fun getAllRunsSortedByAverageSpeed():LiveData<List<Run>>  // Not a suspend function because we want to observe it with live data.

    @Query("SELECT * FROM running_table ORDER BY distanceInMeter DESC") // Latest runs will be on top
    fun getAllRunsSortedByDistance():LiveData<List<Run>>  // Not a suspend function because we want to observe it with live data.


    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis() : LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned() : LiveData<Int>

    @Query("SELECT SUM(distanceInMeter) FROM running_table")
    fun getTotalDistance() : LiveData<Int>

    @Query("SELECT AVG(avgSpeedInKMH) FROM running_table")
    fun getTotalAverageSpeed() : LiveData<Float>
}