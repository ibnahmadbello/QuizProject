package com.practice.ayrash.quizproject;

import android.content.Intent;
import android.icu.util.TimeUnit;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.checked;

public class DisplayQuizActivity extends AppCompatActivity {

    private static final String TIME_REMAINING = "time";
    int totalScore = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_quiz);

        textView = (TextView) findViewById(R.id.timer);
//        Intent intent = getIntent();
        startTicking();

        if (savedInstanceState != null){
            String timeRemaining = savedInstanceState.getString(TIME_REMAINING);
            textView.setText(timeRemaining);
        }
    }

    public void submitQuiz(View view){
        RadioButton questionOneOption = (RadioButton) findViewById(R.id.Q1_CorrectOption);
        if (questionOneOption.isChecked()){totalScore += 2;}
        CheckBox questionTwoOptionOne = (CheckBox) findViewById(R.id.Q2_CorrectOption1);
        CheckBox questionTwoOptionTwo = (CheckBox) findViewById(R.id.Q2_CorrectOption2);
        CheckBox questionTwoOptionThree = (CheckBox) findViewById(R.id.Q2_CorrectOption3);
        CheckBox questionTwoOptionFour = (CheckBox) findViewById(R.id.Q2_CorrectOption4);
        CheckBox questionTwoOptionFive = (CheckBox) findViewById(R.id.Q2_CorrectOption5);
        if (questionTwoOptionOne.isChecked()){totalScore += 2;}
        if (questionTwoOptionTwo.isChecked()){totalScore += 2;}
        if (questionTwoOptionThree.isChecked()){totalScore += 2;}
        if (questionTwoOptionFour.isChecked()){totalScore += 2;}
        if (questionTwoOptionFive.isChecked()){totalScore += 2;}
        RadioButton questionThreeOption = (RadioButton) findViewById(R.id.Q3_CorrectOption);
        if (questionThreeOption.isChecked()){totalScore += 2;}
        RadioButton questionSevenOption = (RadioButton) findViewById(R.id.Q7_CorrectOption);
        if (questionSevenOption.isChecked()){totalScore += 2;}
        RadioButton questionFiveOption = (RadioButton) findViewById(R.id.Q5_CorrectOption);
        if (questionFiveOption.isChecked()){totalScore += 2;}
        RadioButton questionSixOption = (RadioButton) findViewById(R.id.Q6_CorrectOption);
        if (questionSixOption.isChecked()){totalScore += 2;}
        EditText editText = (EditText) findViewById(R.id.type_your_answer);
        String answer = editText.getText().toString();
        if (answer.matches("NIGERIA AND KENYA") ){totalScore += 6;}
        RadioButton questionEightOption = (RadioButton) findViewById(R.id.Q8_CorrectOption);
        if (questionEightOption.isChecked()){totalScore += 2;}
        CheckBox questionNineOptionOne = (CheckBox) findViewById(R.id.Q9_CorrectOption1);
        CheckBox questionNineOptionTwo = (CheckBox) findViewById(R.id.Q9_CorrectOption2);
        CheckBox questionNineOptionThree = (CheckBox) findViewById(R.id.Q9_CorrectOption3);
        if (questionNineOptionOne.isChecked()){totalScore += 2;}
        if (questionNineOptionTwo.isChecked()){totalScore += 2;}
        if (questionNineOptionThree.isChecked()){totalScore += 2;}
        RadioButton questionTenOption = (RadioButton) findViewById(R.id.Q10_CorrectOption);
        if (questionTenOption.isChecked()){totalScore += 2;}
        Toast.makeText(this, "Your score is: " + ((totalScore * 100) / 40) + "%", Toast.LENGTH_LONG).show();
    }

    public void startTicking(){
        new CountDownTimer(30000, 1000){
            public void onTick(long millisUntilFinished){
                textView.setText("Seconds Remaining: " + millisUntilFinished / 1000);
            }
            public void onFinish(){
                textView.setText("Time Up!");
            }
        }.start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        String timeRemaining = textView.getText().toString();
        outState.putString(TIME_REMAINING, timeRemaining);

    }

}
