package xyz.teamgravity.roommultiprocess.injection.provide

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.teamgravity.roommultiprocess.data.local.constant.NumberConst
import xyz.teamgravity.roommultiprocess.data.local.dao.NumberDao
import xyz.teamgravity.roommultiprocess.data.local.database.NumberDatabase
import xyz.teamgravity.roommultiprocess.data.repository.NumberRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideNumberDatabase(application: Application): NumberDatabase =
        Room.databaseBuilder(application, NumberDatabase::class.java, NumberConst.NAME)
            .fallbackToDestructiveMigration()
            .enableMultiInstanceInvalidation()
            .build()

    @Provides
    @Singleton
    fun provideNumberDao(numberDatabase: NumberDatabase): NumberDao = numberDatabase.numberDao()

    @Provides
    @Singleton
    fun provideNumberRepository(numberDao: NumberDao): NumberRepository = NumberRepository(numberDao)
}