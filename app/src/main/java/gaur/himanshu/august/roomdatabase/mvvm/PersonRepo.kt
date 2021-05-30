package gaur.himanshu.august.roomdatabase.mvvm

import gaur.himanshu.august.roomdatabase.mvvm.room.Person
import gaur.himanshu.august.roomdatabase.mvvm.room.PersonDao

class PersonRepo(val personDao: PersonDao) {


    suspend fun insert(person: Person) {
        personDao.insert(person)
    }

    suspend fun delete(person: Person) {
        personDao.delete(person)
    }

    suspend fun update(person: Person) {
        personDao.update(person)
    }

    suspend fun getAllPersons(): List<Person> {
        return personDao.getAllPerson()
    }


}