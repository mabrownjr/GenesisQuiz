package com.example.android.genesisquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rd_Rivers, rd_Trees, rd_Rest;
    RadioButton correctRivers, wrongRivers, wrongRivers2, trueTree, falseRest;
    EditText forbiddenTree, creationPart;

    int quizPoints = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view){
        quizPoints += question1();
        quizPoints += question2();
        quizPoints += question3();
        quizPoints += question4();
        quizPoints += question5();

        Context context = getApplicationContext();
        CharSequence text = "You have " + quizPoints + " points correct.";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
    public void resetQuiz(View view){
        rd_Rivers = (RadioGroup) findViewById(R.id.radioRivers);
        rd_Trees = (RadioGroup) findViewById(R.id.radioTrees);
        rd_Rest= (RadioGroup) findViewById(R.id.radioRest);

        forbiddenTree.setText(null);
        creationPart.setText(null);

        rd_Rivers.clearCheck();
        rd_Trees.clearCheck();
        rd_Rest.clearCheck();



        quizPoints = 0;

        Context context = getApplicationContext();
        CharSequence text = "Quiz has been reset!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public int question1(){
        correctRivers = (RadioButton) findViewById(R.id.correctRivers);
        wrongRivers = (RadioButton) findViewById(R.id.wrongRivers);
        wrongRivers2 = (RadioButton) findViewById(R.id.wrongRivers2);


        if(correctRivers.isChecked()){
            return 1;
        }

        return 0;
    }
    public int question2(){
        trueTree = (RadioButton) findViewById(R.id.trueTrees);

        if (trueTree.isChecked()){
            return 1;
        }

        return 0;
    }
    public int question3(){

        String answer = "Tree of knowledge of good and evil";
        forbiddenTree = (EditText) findViewById(R.id.forbiddenTree);
        String input = forbiddenTree.getText().toString();

        if(input.trim().equalsIgnoreCase(answer.trim())){
            return 1;
        } else
            return 0;
    }
    public int question4(){

        String answer = "rib";
        creationPart = (EditText) findViewById(R.id.creationPart);
        String input = creationPart.getText().toString();

        if(input.trim().equalsIgnoreCase(answer.trim())){
            return 1;
        } else
            return 0;
    }
    public int question5(){
        falseRest = (RadioButton) findViewById(R.id.falseRest);

        if (falseRest.isChecked()){
            return 1;
        }

        return 0;
    }
}
