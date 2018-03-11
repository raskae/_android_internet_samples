/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.androidstarters.example.statistics;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.androidstarters.example.R;
import com.androidstarters.example.data.FakeTasksRemoteDataSource;
import com.androidstarters.example.data.Task;
import com.androidstarters.example.data.source.TasksRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

/**
 * Tests for the statistics screen.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class StatisticsScreenTest {

    /**
     * {@link ActivityTestRule} is a JUnit {@link Rule @Rule} to launch your activity under test.
     *
     * <p>
     * Rules are interceptors which are executed for each test method and are important building
     * blocks of Junit tests.
     */
    @Rule
    public ActivityTestRule<StatisticsActivity> mStatisticsActivityTestRule =
            new ActivityTestRule<>(StatisticsActivity.class, true, false);

    @Before
    public void startWithTwoTasks() {
        // Given some tasks
        TasksRepository.destroyInstance();
        FakeTasksRemoteDataSource.getInstance().deleteAllTasks();
        FakeTasksRemoteDataSource.getInstance().addTasks(new Task("Title1", "", false));
        FakeTasksRemoteDataSource.getInstance().addTasks(new Task("Title2", "", true));

        // Lazily start the Activity from the ActivityTestRule
        Intent startIntent = new Intent();
        mStatisticsActivityTestRule.launchActivity(startIntent);
    }

    @Test
    public void Tasks_ShowsNonEmptyMessage() throws Exception {
        // Check that the active and completed tasks text is displayed
        String expectedActiveTaskText = InstrumentationRegistry.getTargetContext()
                .getString(R.string.statistics_active_tasks, 1);
        onView(withText(containsString(expectedActiveTaskText))).check(matches(isDisplayed()));
        String expectedCompletedTaskText = InstrumentationRegistry.getTargetContext()
                .getString(R.string.statistics_completed_tasks, 1);
        onView(withText(containsString(expectedCompletedTaskText))).check(matches(isDisplayed()));
    }
}
