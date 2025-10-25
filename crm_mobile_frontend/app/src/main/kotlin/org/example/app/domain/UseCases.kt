package org.example.app.domain

import android.content.Context
import kotlinx.coroutines.flow.Flow
import org.example.app.data.entity.Contact
import org.example.app.data.entity.Deal
import org.example.app.data.entity.Task
import org.example.app.data.entity.Note

class GetContactsUseCase(context: Context) {
    private val repo = ContactRepository(context)
    operator fun invoke(): Flow<List<Contact>> = repo.getAll()
}

class GetDealsUseCase(context: Context) {
    private val repo = DealRepository(context)
    operator fun invoke(): Flow<List<Deal>> = repo.getAll()
}

class GetTasksUseCase(context: Context) {
    private val repo = TaskRepository(context)
    operator fun invoke(): Flow<List<Task>> = repo.getAll()
}

class GetNotesUseCase(context: Context) {
    private val repo = NoteRepository(context)
    operator fun invoke(parentType: String, parentId: Long) = repo.notesFor(parentType, parentId)
}
