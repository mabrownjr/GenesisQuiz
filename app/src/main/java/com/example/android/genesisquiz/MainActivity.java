package com.example.android.genesisquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rd_Rivers, rd_Trees, rd_Rest;
    RadioButton correctRivers, wrongRivers, wrongRivers2, trueTree, falseRest;
    EditText forbiddenTree, creationPart;
    CheckBox stars, animals, moon, sun;

    int quizPoints;
    int totalQuizPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view){
        trueTree = (RadioButton) findViewById(R.id.trueTrees);
        correctRivers = (RadioButton) findViewById(R.id.correctRivers);
        wrongRivers = (RadioButton) findViewById(R.id.wrongRivers);
        wrongRivers2 = (RadioButton) findViewById(R.id.wrongRivers2);
        forbiddenTree = (EditText) findViewById(R.id.forbiddenTree);
        creationPart = (EditText) findViewById(R.id.creationPart);
        falseRest = (RadioButton) findViewById(R.id.falseRest);
        stars = (CheckBox) findViewById(R.id.star_correct);
        animals = (CheckBox) findViewById(R.id.animals_wrong);
        moon = (CheckBox) findViewById(R.id.moon_correct);
        sun = (CheckBox) findViewById(R.id.sun_correct);

        String treeAnswer = "Tree of knowledge of good and evil";
        String input = forbiddenTree.getText().toString();
        String ribAnswer = "rib";


        if (trueTree.isChecked()) {
            quizPoints += incrementPoints(quizPoints);
            totalQuizPoints = quizPoints;
        }
        if(correctRivers.isChecked()) {
            quizPoints = incrementPoints(quizPoints);
            totalQuizPoints = quizPoints;
        }
        if(input.trim().equalsIgnoreCase(treeAnswer.trim())){
            quizPoints = incrementPoints(quizPoints);
            totalQuizPoints = quizPoints;
        }
        input = creationPart.getText().toString();

        if(input.trim().equalsIgnoreCase(ribAnswer.trim())){
            quizPoints = incrementPoints(quizPoints);
            totalQuizPoints = quizPoints;
        }
        if (falseRest.isChecked()){
            quizPoints = incrementPoints(quizPoints);
            totalQuizPoints = quizPoints;
        }

        if (stars.isChecked() && moon.isChecked() && !animals.isChecked() && sun.isChecked()){
            quizPoints = incrementPoints(quizPoints);
            totalQuizPoints = quizPoints;
        }

        Context context = getApplicationContext();
        CharSequence text = "You have " + totalQuizPoints + " points correct.";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        resetQuiz();

    }
    public void resetQuiz(){
        rd_Rivers = (RadioGroup) findViewById(R.id.radioRivers);
        rd_Trees = (RadioGroup) findViewById(R.id.radioTrees);
        rd_Rest= (RadioGroup) findViewById(R.id.radioRest);

        forbiddenTree.setText(null);
        creationPart.setText(null);

        rd_Rivers.clearCheck();
        rd_Trees.clearCheck();
        rd_Rest.clearCheck();

        stars.setChecked(false);
        animals.setChecked(false);
        moon.setChecked(false);
        sun.setChecked(false);


        quizPoints = 0;

    }
    public int incrementPoints(int points){
        if (points == 8){
            return points;
        }else
            points++;
            return points;

    }
    public int decrementPoints(int points){
        if (points == 0){
            return points;
        }else
            points--;
            return points;
    }
}
