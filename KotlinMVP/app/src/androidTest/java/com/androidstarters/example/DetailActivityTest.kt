package com.androidstarters.example

import com.androidstarters.example.common.TestComponentRule
import com.androidstarters.example.common.TestDataFactory
import com.androidstarters.example.data.model.Pokemon
import com.androidstarters.example.features.detail.DetailActivity
import com.androidstarters.example.util.ErrorTestUtil
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.`when`

@RunWith(AndroidJUnit4::class)
class DetailActivityTest {

    val component = TestComponentRule(InstrumentationRegistry.getTargetContext())
    val main = ActivityTestRule(DetailActivity::class.java, false, false)

    // TestComponentRule needs to go first to make sure the Dagger ApplicationTestComponent is set
    // in the Application before any Activity is launched.
    @Rule @JvmField
    var chain: TestRule = RuleChain.outerRule(component).around(main)

    @Test
    fun checkPokemonDisplays() {
        val pokemon = TestDataFactory.makePokemon("id")
        stubDataManagerGetPokemon(Single.just(pokemon))
        main.launchActivity(
                DetailActivity.getStartIntent(InstrumentationRegistry.getContext(), pokemon.name))

        for (stat in pokemon.stats) {
            onView(withText(stat.stat?.name))
                    .check(matches(isDisplayed()))
        }
    }

    @Test
    fun checkErrorViewDisplays() {
        stubDataManagerGetPokemon(Single.error<Pokemon>(RuntimeException()))
        val pokemon = TestDataFactory.makePokemon("id")
        main.launchActivity(
                DetailActivity.getStartIntent(InstrumentationRegistry.getContext(), pokemon.name))
        ErrorTestUtil.checkErrorViewsDisplay()
    }

    fun stubDataManagerGetPokemon(single: Single<Pokemon>) {
        `when`(component.mockDataManager.getPokemon(ArgumentMatchers.anyString()))
                .thenReturn(single)
    }

}