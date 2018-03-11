package com.androidstarters.example.data;

import com.androidstarters.example.domain.RemoteCommentRepository;
import com.androidstarters.example.domain.services.jobs.JobManagerFactory;
import com.androidstarters.example.domain.services.jobs.SyncCommentJob;
import com.androidstarters.example.model.Comment;

import io.reactivex.Completable;

public class RemoteCommentDataStore implements RemoteCommentRepository {

    @Override
    public Completable sync(Comment comment) {
        return Completable.fromAction(() ->
                JobManagerFactory.getJobManager().addJobInBackground(new SyncCommentJob(comment)));
    }
}
