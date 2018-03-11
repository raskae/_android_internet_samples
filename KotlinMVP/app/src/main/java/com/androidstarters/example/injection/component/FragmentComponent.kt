package com.androidstarters.example.injection.component

import com.androidstarters.example.injection.PerFragment
import com.androidstarters.example.injection.module.FragmentModule
import dagger.Subcomponent

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent