package org.example.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.example.app.data.entity.Contact
import org.example.app.data.entity.Deal
import org.example.app.data.entity.Task
import org.example.app.data.entity.Note

@Dao
interface ContactDao {
    @Query("SELECT * FROM contacts ORDER BY name ASC")
    fun getAll(): Flow<List<Contact>>

    @Insert
    suspend fun insert(contact: Contact): Long

    @Update
    suspend fun update(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)
}

@Dao
interface DealDao {
    @Query("SELECT * FROM deals ORDER BY id DESC")
    fun getAll(): Flow<List<Deal>>

    @Insert
    suspend fun insert(deal: Deal): Long

    @Update
    suspend fun update(deal: Deal)

    @Delete
    suspend fun delete(deal: Deal)
}

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun getAll(): Flow<List<Task>>

    @Insert
    suspend fun insert(task: Task): Long

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)
}

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes WHERE parentType = :parentType AND parentId = :parentId ORDER BY id DESC")
    fun notesFor(parentType: String, parentId: Long): Flow<List<Note>>

    @Insert
    suspend fun insert(note: Note): Long

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)
}
