package putriiiiiuta.androidlima.latihanchapterdelapan.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import putriiiiiuta.androidlima.latihanchapterdelapan.room.NotesDao
import putriiiiiuta.androidlima.latihanchapterdelapan.room.NotesDatabase
import putriiiiiuta.androidlima.latihanchapterdelapan.room.UserDao
import putriiiiiuta.androidlima.latihanchapterdelapan.room.UserDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDB(context: Application) : NotesDatabase {
        return  NotesDatabase.getInstance(context)!!
    }
    @Provides
    @Singleton
    fun provideDBU(context: Application) : UserDatabase {
        return  UserDatabase.getInstance(context)!!
    }

    @Provides
    @Singleton
    fun provideDao(noteDb : NotesDatabase) : NotesDao {
        return  noteDb.favoriteDao()
    }

    @Provides
    @Singleton
    fun provideDaoU(userDB : UserDatabase) : UserDao {
        return  userDB.userDao()
    }


}