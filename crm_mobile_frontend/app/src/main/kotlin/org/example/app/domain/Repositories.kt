package org.example.app.domain

import android.content.Context
import kotlinx.coroutines.flow.Flow
import org.example.app.data.AppDatabase
import org.example.app.data.entity.Contact
import org.example.app.data.entity.Deal
import org.example.app.data.entity.Task
import org.example.app.data.entity.Note

class ContactRepository(context: Context) {
    private val dao = AppDatabase.get(context).contactDao()
    fun getAll(): Flow<List<Contact>> = dao.getAll()
    suspend fun add(c: Contact) = dao.insert(c)
    suspend fun update(c: Contact) = dao.update(c)
    suspend fun delete(c: Contact) = dao.delete(c)
}

class DealRepository(context: Context) {
    private val dao = AppDatabase.get(context).dealDao()
    fun getAll(): Flow<List<Deal>> = dao.getAll()
    suspend fun add(d: Deal) = dao.insert(d)
    suspend fun update(d: Deal) = dao.update(d)
    suspend fun delete(d: Deal) = dao.delete(d)
}

class TaskRepository(context: Context) {
    private val dao = AppDatabase.get(context).taskDao()
    fun getAll(): Flow<List<Task>> = dao.getAll()
    suspend fun add(t: Task) = dao.insert(t)
    suspend fun update(t: Task) = dao.update(t)
    suspend fun delete(t: Task) = dao.delete(t)
}

class NoteRepository(context: Context) {
    private val dao = AppDatabase.get(context).noteDao()
    fun notesFor(parentType: String, parentId: Long) = dao.notesFor(parentType, parentId)
    suspend fun add(n: Note) = dao.insert(n)
    suspend fun update(n: Note) = dao.update(n)
    suspend fun delete(n: Note) = dao.delete(n)
}
