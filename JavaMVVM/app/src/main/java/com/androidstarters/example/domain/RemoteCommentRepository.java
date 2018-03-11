package com.androidstarters.example.domain;

import com.androidstarters.example.model.Comment;

import io.reactivex.Completable;

public interface RemoteCommentRepository {
    Completable sync(Comment comment);
}
