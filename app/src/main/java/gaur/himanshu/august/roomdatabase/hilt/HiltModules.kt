package gaur.himanshu.august.roomdatabase.hilt

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import gaur.himanshu.august.roomdatabase.mvvm.PersonRepo
import gaur.himanshu.august.roomdatabase.mvvm.room.PersonDao
import gaur.himanshu.august.roomdatabase.mvvm.room.PersonDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HiltModules {




    @Provides
    @Singleton
    fun providePersonDao(@ApplicationContext context:Context):PersonDao{
        return PersonDatabase.getInstance(context).getPersonDao()
    }


    @Singleton
    @Provides
    fun personRepo(personDao: PersonDao):PersonRepo{
        return PersonRepo(personDao)
    }

}