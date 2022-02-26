package com.fiap.vivo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val cpfCnpj: String,
    val email: String,
    val planos: String,
    val senha: String
)





