package org.example.app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.example.app.data.dao.ContactDao
import org.example.app.data.dao.DealDao
import org.example.app.data.dao.TaskDao
import org.example.app.data.dao.NoteDao
import org.example.app.data.entity.Contact
import org.example.app.data.entity.Deal
import org.example.app.data.entity.Task
import org.example.app.data.entity.Note

@Database(
    entities = [Contact::class, Deal::class, Task::class, Note::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
    abstract fun dealDao(): DealDao
    abstract fun taskDao(): TaskDao
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun get(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "crm.db"
                ).fallbackToDestructiveMigration().build().also { INSTANCE = it }
            }
    }
}
