package com.androidstarters.example.injection.component

import com.androidstarters.example.injection.PerActivity
import com.androidstarters.example.injection.module.ActivityModule
import com.androidstarters.example.features.base.BaseActivity
import com.androidstarters.example.features.detail.DetailActivity
import com.androidstarters.example.features.main.MainActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(detailActivity: DetailActivity)
}
