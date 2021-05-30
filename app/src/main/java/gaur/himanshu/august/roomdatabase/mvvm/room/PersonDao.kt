package gaur.himanshu.august.roomdatabase.mvvm.room

import androidx.room.*

@Dao
interface PersonDao {

    /** This is the interface which is implemented by our Room library */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(person: Person)

    @Delete
    suspend fun delete(person: Person)

    @Update
    suspend fun update(person: Person)

    @Query("SELECT * FROM Person")
    suspend fun getAllPerson(): List<Person>


}