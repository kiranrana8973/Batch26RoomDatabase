package com.kiran.batch26roomdatabase.db

import android.content.Context
import android.view.GestureDetector
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kiran.batch26roomdatabase.dao.StudentDAO
import com.kiran.batch26roomdatabase.dao.UserDAO
import com.kiran.batch26roomdatabase.entity.Student
import com.kiran.batch26roomdatabase.entity.User

@Database(
    entities = [(Student::class), (User::class)],
    version = 1
)

abstract class StudentDB : RoomDatabase() {

    abstract fun getUserDAO() : UserDAO
    abstract fun getStudentDAO() : StudentDAO

    companion object {
        @Volatile
        private var instance: StudentDB? = null

        fun getInstance(context: Context): StudentDB {
            if (instance == null) {
                synchronized(StudentDB::class) {
                    instance = createDatabase(context)
                }
            }
            return instance!!
        }

        //Create Database
        private fun createDatabase(context: Context): StudentDB {
            return Room.databaseBuilder(
                context.applicationContext,
                StudentDB::class.java,
                "StudentDB"
            ).build()
        }
    }
}
