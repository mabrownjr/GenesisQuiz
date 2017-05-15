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
    RadioButton correctRivers, wrongRivers, wrongRivers2, trueTree, falseTree;
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

        rd_Rivers.clearCheck();
        rd_Trees.clearCheck();
        rd_Rest.clearCheck();

        quizPoints = 0;
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

        String answer = "Tree of Knowledge of Good and Evil";
        forbiddenTree = (EditText) findViewById(R.id.forbiddenTree);
        String input = forbiddenTree.toString();

        input = input.replaceAll("\\s", "");

        if(input == answer.replaceAll("\\s", "")){
            return 1;
        }

        return 0;
    }
}
