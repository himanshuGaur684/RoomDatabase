package gaur.himanshu.august.roomdatabase.mvvm.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    val name:String,
    val age:Int,
    @PrimaryKey(autoGenerate = true)
    val aadarCardNumber:Int=0
) {
}