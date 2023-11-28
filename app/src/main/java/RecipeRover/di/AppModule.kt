package com.fahad.RecipeRover.di

import android.content.Context
import androidx.room.Room
import com.fahad.RecipeRover.domain.repository.AuthRepository
import com.fahad.RecipeRover.data.local.dao.FavoriteDao
import com.fahad.RecipeRover.data.local.dao.ItemDao
import com.fahad.RecipeRover.data.local.database.AppDatabase
import com.fahad.RecipeRover.data.repository.AuthRepositoryImpl

import com.fahad.RecipeRover.ui.screen.UserDataViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  @Singleton
  @Provides
  fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
    return Room.databaseBuilder(
      context.applicationContext,
      AppDatabase::class.java,
      "list_food_database"
    ).build()
  }

  @Provides
  fun provideItemDao(database: AppDatabase): ItemDao = database.itemDao()

  @Provides
  fun provideFavoriteDao(database: AppDatabase): FavoriteDao = database.favoriteDao()

  @Provides
  fun provideAuthRepository(): AuthRepository {
    return AuthRepositoryImpl()
  }

  @Provides
  fun provideUserDataViewModel(): UserDataViewModel {
    return UserDataViewModel(
      authRepository = AuthRepositoryImpl()
    )
  }
}






