package com.androidstarters.example.domain.services.networking;

import com.androidstarters.example.model.Comment;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

interface RemoteCommentEndpoint {

    @POST("comments")
    Call<Comment> addComment(@Body Comment comment);
}
