package com.androidstarters.example.di;

import android.content.Context;

import com.androidstarters.example.App;
import com.androidstarters.example.data.CommentDao;
import com.androidstarters.example.data.CommentDatabase;
import com.androidstarters.example.data.LocalCommentDataStore;
import com.androidstarters.example.data.RemoteCommentDataStore;
import com.androidstarters.example.domain.LocalCommentRepository;
import com.androidstarters.example.domain.RemoteCommentRepository;
import com.androidstarters.example.domain.services.jobs.GcmJobService;
import com.androidstarters.example.domain.services.jobs.SchedulerJobService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This is where you will inject application-wide dependencies.
 */
@Module
public class AppModule {

    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    SchedulerJobService provideSchedulerJobService() {
        return new SchedulerJobService();
    }

    @Singleton
    @Provides
    GcmJobService provideGcmJobService() {
        return new GcmJobService();
    }

    @Singleton
    @Provides
    CommentDao provideCommentDao(Context context) {
        return CommentDatabase.getInstance(context).commentDao();
    }

    @Singleton
    @Provides
    LocalCommentRepository provideLocalCommentRepository(CommentDao commentDao) {
        return new LocalCommentDataStore(commentDao);
    }

    @Singleton
    @Provides
    RemoteCommentRepository provideRemoteCommentRepository() {
        return new RemoteCommentDataStore();
    }
}
