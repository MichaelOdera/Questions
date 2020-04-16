package com.example.questions.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.questions.MyQuestionResponse;
import com.example.questions.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder> {
    Context mContext;
    List<MyQuestionResponse> mQuestions;

    public QuestionsAdapter(Context context, List<MyQuestionResponse> questions){
        mContext = context;
        mQuestions = questions;
    }


    @NonNull
    @Override
    public QuestionsAdapter.QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_list_item, parent, false);
        QuestionViewHolder viewHolder = new QuestionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsAdapter.QuestionViewHolder holder, int position) {
        holder.bindQuestions(mQuestions.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.questionTitle)
        TextView mQuestionTitle;
        @BindView(R.id.questionBody) TextView mQuestionBody;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindQuestions(MyQuestionResponse myQuestionResponse) {
            mQuestionTitle.setText(myQuestionResponse.getTitle());
            mQuestionBody.setText(myQuestionResponse.getBody());
        }
    }
}
