package com.kiran.batch26roomdatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Int=0,
    val fName : String? = null,
    val lName: String? = null,
    val username: String? = null,
    val password: String? = null
)
