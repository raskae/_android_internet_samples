package com.androidstarters.example.features.detail

import com.androidstarters.example.data.model.Pokemon
import com.androidstarters.example.data.model.Statistic
import com.androidstarters.example.features.base.MvpView

interface DetailMvpView : MvpView {

    fun showPokemon(pokemon: Pokemon)

    fun showStat(statistic: Statistic)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}