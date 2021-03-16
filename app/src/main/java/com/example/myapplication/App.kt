package com.example.myapplication

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import io.socket.client.IO
import io.socket.client.Socket
import timber.log.Timber
import timber.log.Timber.DebugTree


@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(DebugTree())
    }
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun getBaseUrl(): String = "https://px-socket-api.herokuapp.com/"

    @Provides
    fun getSocket(): Socket = IO.socket(getBaseUrl())
}