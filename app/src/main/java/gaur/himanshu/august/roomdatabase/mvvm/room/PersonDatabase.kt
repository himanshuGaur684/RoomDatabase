package gaur.himanshu.august.roomdatabase.mvvm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class PersonDatabase : RoomDatabase() {


    companion object {
        fun getInstance(context: Context): PersonDatabase {
            return Room.databaseBuilder(context, PersonDatabase::class.java, "db")
                .fallbackToDestructiveMigration().build()
        }
    }


    abstract fun getPersonDao(): PersonDao


}