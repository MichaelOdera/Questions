package com.example.questions.network;

import com.example.questions.MyQuestionResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("api/v1/question")
    Call<List<MyQuestionResponse>> getQuestions();
}
