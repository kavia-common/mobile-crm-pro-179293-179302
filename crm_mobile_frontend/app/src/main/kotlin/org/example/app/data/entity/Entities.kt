package org.example.app.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val email: String? = null,
    val phone: String? = null
)

@Entity(tableName = "deals")
data class Deal(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val value: Int? = null,
    val contactId: Long? = null
)

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val status: String = "Open",
    val contactId: Long? = null,
    val dealId: Long? = null
)

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val parentType: String, // "contact" or "deal"
    val parentId: Long,
    val content: String
)
