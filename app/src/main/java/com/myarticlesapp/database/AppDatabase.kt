package com.otb.githubissues.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [IssuesModels.IssueEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun issuesDao(): IssuesDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "my-articles.db").build()
                }
            }
            return instance!!
        }
    }
}