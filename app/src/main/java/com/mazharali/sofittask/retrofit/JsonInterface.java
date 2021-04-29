package com.mazharali.sofittask.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonInterface {

    @GET("posts")
    Call<List<JsonPojo>> getAllPosts();
}
