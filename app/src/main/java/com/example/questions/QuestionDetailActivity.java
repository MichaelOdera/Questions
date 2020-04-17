package com.example.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionDetailActivity extends AppCompatActivity {

    private MyQuestionResponse question;

    @BindView(R.id.questionId)
    TextView mQuestionId;
    @BindView(R.id.questionTitle)
    TextView mQuestionTitle;
    @BindView(R.id.questionDescription)
    TextView mQuestionDescription;
    @BindView(R.id.questionBody)
    TextView mQuestionBody;
    @BindView(R.id.addAnswerButton)
    Button mAddAnswer;
    @BindView(R.id.questionPostedBy)
    TextView mQuestionPostedBy;
    @BindView(R.id.questionPostedAt)
    TextView mQuestionPostedAt;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);
        ButterKnife.bind(this);

        question = Parcels.unwrap(getIntent().getParcelableExtra("question"));

        mQuestionId.setText(question.getId().toString());
        mQuestionTitle.setText(question.getTitle());
        mQuestionDescription.setText(question.getDescription());
        mQuestionBody.setText(question.getBody());
        //mQuestionPostedBy.setText(question.getPoster());
        mQuestionPostedAt.setText(question.getCreated());

    }
}
