package com.example.android.genesisquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    int quizPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view){

        CheckBox correctRivers = (CheckBox) findViewById(R.id.correctRivers);
        if (correctRivers.isChecked()){
            quizPoints +=1;
        }

        CheckBox wrongRivers = (CheckBox) findViewById(R.id.wrongRivers);
        if (wrongRivers.isChecked()){
            quizPoints -=1;
        }

        CheckBox wrongRivers2 = (CheckBox) findViewById(R.id.wrongRivers2);
        if (wrongRivers2.isChecked()){
            quizPoints -=1;
        }

        CheckBox trueTrees = (CheckBox) findViewById(R.id.trueTrees);
        if (trueTrees.isChecked()){
            quizPoints+=1;
        }

        CheckBox falseTrees = (CheckBox) findViewById(R.id.falseTrees);
        if(falseTrees.isChecked()){
            quizPoints-= 1;
        }

        CheckBox trueRest = (CheckBox) findViewById(R.id.trueRest);
        if(trueRest.isChecked()){
            quizPoints -= 1;
        }

        CheckBox falseRest = (CheckBox) findViewById(R.id.falseRest);
        if(falseRest.isChecked()){
            quizPoints+=1;
        }


        Intent intent = new Intent(this, FinalScoreActivity.class);
        startActivity(intent);

    }
}
