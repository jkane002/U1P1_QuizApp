package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity {

    private TextView questionText;
    private Button trueButton, falseButton, nextButton;

    private int currIndex = 0;

    private TrueFalse[] questions = new TrueFalse[] {

            new TrueFalse(R.string.question01, true),
            new TrueFalse(R.string.question02, false),
            new TrueFalse(R.string.question03, true),
            new TrueFalse(R.string.question04, true),
            new TrueFalse(R.string.question05, false),
            new TrueFalse(R.string.question06, true),
            new TrueFalse(R.string.question07, true),
            new TrueFalse(R.string.question08, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = (TextView)findViewById(R.id.question_text_view);
        final int Question = questions[currIndex].getQuestion();
        questionText.setText(Question);

        trueButton = (Button)findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        falseButton = (Button)findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        nextButton = (Button)findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currIndex = (currIndex + 1) % questions.length;
                int question = questions[currIndex].getQuestion();
                questionText.setText(question);
            }
        });
    }

    private void checkAnswer(boolean userPressed) {
        boolean answer = questions[currIndex].isTrueQuestion();

        if(userPressed == answer) {
            Toast.makeText(MainActivity.this, R.string.true_message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.false_message, Toast.LENGTH_SHORT).show();
        }
    }
}
