package com.androidstarters.example.domain;

import com.androidstarters.example.model.Comment;
import com.androidstarters.example.model.ModelConstants;

import java.util.List;

import io.reactivex.Flowable;

public class GetCommentsUseCase {
    private final LocalCommentRepository localCommentRepository;

    public GetCommentsUseCase(LocalCommentRepository localCommentRepository) {
        this.localCommentRepository = localCommentRepository;
    }

    public Flowable<List<Comment>> getComments() {
        return localCommentRepository.getComments(ModelConstants.DUMMY_PHOTO_ID);
    }
}
