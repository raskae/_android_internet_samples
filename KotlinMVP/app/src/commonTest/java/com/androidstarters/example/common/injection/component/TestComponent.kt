package com.androidstarters.example.common.injection.component

import dagger.Component
import com.androidstarters.example.common.injection.module.ApplicationTestModule
import com.androidstarters.example.injection.component.AppComponent
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationTestModule::class))
interface TestComponent : AppComponent