package camp.nextstep.edu.calculator.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MemoryEntity::class], version = 1)
abstract class MemoryDatabase : RoomDatabase() {
    abstract fun memoryDao(): MemoryDao

    companion object {
        private const val databaseName = "memory.db"
        private var instance: MemoryDatabase? = null

        fun getInstance(context: Context): MemoryDatabase? {
            if (instance == null) {
                synchronized(MemoryDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MemoryDatabase::class.java,
                        databaseName
                    ).build()
                }
            }
            return instance
        }
    }
}
