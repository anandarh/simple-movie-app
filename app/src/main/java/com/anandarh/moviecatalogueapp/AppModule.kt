package com.anandarh.moviecatalogueapp

import android.content.Context
import com.anandarh.moviecatalogueapp.models.ResourceMovieModel
import com.anandarh.moviecatalogueapp.utilities.ReadFile
import com.google.gson.Gson
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
    fun provideDummyData(@ApplicationContext app: Context): ResourceMovieModel {
        val jsonString =
            ReadFile().getJsonFromAsset(app, "resource.json")
        return Gson().fromJson(jsonString, ResourceMovieModel::class.java)
    }

}