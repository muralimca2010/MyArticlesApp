package com.otb.githubissues.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.otb.githubissues.scene.issues.IssuesModels
import retrofit2.http.Query

@Dao
interface IssuesDao {

    @Query("DELETE FROM issue")
    suspend fun clear()
}