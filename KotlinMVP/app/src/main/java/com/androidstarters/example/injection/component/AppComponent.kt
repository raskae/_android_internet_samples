package com.androidstarters.example.injection.component

import android.app.Application
import android.content.Context
import dagger.Component
import com.androidstarters.example.data.DataManager
import com.androidstarters.example.data.remote.PokemonApi
import com.androidstarters.example.injection.ApplicationContext
import com.androidstarters.example.injection.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager

    fun pokemonApi(): PokemonApi
}
