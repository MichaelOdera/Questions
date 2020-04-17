package com.example.questions.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.questions.MyQuestionResponse;
import com.example.questions.QuestionDetailActivity;
import com.example.questions.R;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder> {
    Context mContext;
    List<MyQuestionResponse> mQuestions;
    MyQuestionResponse question;

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

    public class QuestionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.questionTitle)
        TextView mQuestionTitle;
        @BindView(R.id.questionBody) TextView mQuestionBody;
        MyQuestionResponse question;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindQuestions(MyQuestionResponse myQuestionResponse) {
            mQuestionTitle.setText(myQuestionResponse.getTitle());
            mQuestionBody.setText(myQuestionResponse.getBody());
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            Intent intent = new Intent(mContext, QuestionDetailActivity.class);
            question = mQuestions.get(position);
            //intent.putExtra("description", description);
            intent.putExtra("question", Parcels.wrap(question));
            intent.putExtra("position", position);
            mContext.startActivity(intent);

        }
    }
}
