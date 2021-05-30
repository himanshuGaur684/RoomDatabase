package gaur.himanshu.august.roomdatabase.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gaur.himanshu.august.roomdatabase.mvvm.room.Person
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(private val personRepo: PersonRepo) : ViewModel() {


    private val _list = MutableLiveData<List<Person>>()
    val list: LiveData<List<Person>> = _list


    fun insert(person: Person) = viewModelScope.launch {
        personRepo.insert(person)
        _list.postValue(personRepo.getAllPersons())
    }


    fun delete(person: Person) = viewModelScope.launch {
        personRepo.delete(person)
        _list.postValue(personRepo.getAllPersons())
    }


    fun update(person: Person) = viewModelScope.launch {
        personRepo.update(person)
        _list.postValue(personRepo.getAllPersons())
    }

    fun getAllPersons() = viewModelScope.launch {
        _list.postValue(personRepo.getAllPersons())
    }


}