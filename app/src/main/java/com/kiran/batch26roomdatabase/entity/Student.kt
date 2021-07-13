package com.kiran.batch26roomdatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    val stdId : Int = 0,

)