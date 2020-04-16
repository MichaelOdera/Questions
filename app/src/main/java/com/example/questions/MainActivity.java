package com.example.questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.questions.adapters.QuestionsAdapter;
import com.example.questions.network.RetrofitInstance;
import com.example.questions.network.RetrofitInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.myRecyclerView)
    RecyclerView mRecyclerView;
     private QuestionsAdapter mAdapter;

    private List<MyQuestionResponse> mQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        RetrofitInterface client = RetrofitInstance.getClient();


        Call<List<MyQuestionResponse>> call = client.getQuestions();

        call.enqueue(new Callback<List<MyQuestionResponse>>() {
            @Override
            public void onResponse(Call<List<MyQuestionResponse>> call, Response<List<MyQuestionResponse>> response) {
                if(response.isSuccessful()){
                    Log.d("Success", "Successful");
                    assert response.body() != null;
                    mQuestions= response.body();
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    mAdapter = new QuestionsAdapter(MainActivity.this, mQuestions);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                }
            }

            @Override
            public void onFailure(Call<List<MyQuestionResponse>> call, Throwable t) {

            }
        });


    }
}
