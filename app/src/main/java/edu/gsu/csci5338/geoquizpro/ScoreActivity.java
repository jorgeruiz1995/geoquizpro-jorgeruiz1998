package edu.gsu.csci5338.geoquizpro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private static int scoreCorrect = 0;
    private static int scoreIncorrect = 0;
    private static int scoreCheated = 0;
    private static int answered = 0;
    private TextView mCorrectScore;
    private TextView mIncorrectScore;
    private TextView mCheatedScore;
    private TextView mUnansweredScore;
    private Button returnToMain;
    private Button checkScore;

    private boolean mAnswerIsTrue;

    private static final String EXTRA_ANSWER_IS_TRUE = "geoquizpro.answer_is_true";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreCorrect =0;
        scoreIncorrect = 0;
        scoreCheated = 0;
        answered = 0;

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        scoreCorrect = getIntent().getIntExtra("1", 0);
        scoreIncorrect = getIntent().getIntExtra("2", 0);
        scoreCheated = getIntent().getIntExtra("3", 0);
        answered = getIntent().getIntExtra("4", 0);


        mCorrectScore = (TextView)findViewById(R.id.correct_num);
        mIncorrectScore = (TextView)findViewById(R.id.incorrect_num);
        mCheatedScore = (TextView)findViewById(R.id.cheated_num);
        mUnansweredScore = (TextView)findViewById(R.id.unanswered_num);
        returnToMain = (Button)findViewById(R.id.main_page_button);

        if(mAnswerIsTrue){
            scoreCorrect++;
            answered++;
        }else{
            scoreIncorrect++;
            answered++;
        }

        String modify;

        modify = mCorrectScore.getText().toString();
        modify = modify + String.valueOf(scoreCorrect);
        mCorrectScore.setText(modify);

        modify = mIncorrectScore.getText().toString();
        modify = modify + String.valueOf(scoreIncorrect);
        mIncorrectScore.setText(modify);

        modify = mCheatedScore.getText().toString();
        modify = modify + String.valueOf(scoreCheated);
        mCheatedScore.setText(modify);

        modify = mUnansweredScore.getText().toString();
        modify = modify + String.valueOf(10 - answered);
        mUnansweredScore.setText(modify);

        returnToMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }
}