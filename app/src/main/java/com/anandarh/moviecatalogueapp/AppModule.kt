package com.anandarh.moviecatalogueapp

import android.content.Context
import com.anandarh.moviecatalogueapp.data.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideMovieRepository(@ApplicationContext app: Context): MovieRepository {
        return MovieRepository(app)
    }

}