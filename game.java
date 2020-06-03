package com.example.smeet.braingame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
   Button goButton,op1,op2,op3,op4,playAgain;
   TextView problem,result,score,timer;
    int locationOfCorrectAnswer,sum=0,total=0;
    int a,b,i;
    Random rand=new Random();



    public void newQuestion(View view)
    {
        if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString()))
        {
            result.setText("Correct:)");
            sum++;
        }
        else
        {
            result.setText("Wrong:(");
        }
        total++;

        locationOfCorrectAnswer=rand.nextInt(4);
        ArrayList<Integer>answers=new ArrayList<Integer>();

        a=rand.nextInt(21);
        b=rand.nextInt(21);
        problem.setText(Integer.toString(a)+"+"+Integer.toString(b));
        for(i=0;i<4;i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a + b);
            }score.setText(Integer.toString(sum)+"/"+Integer.toString(total));
            int wrongAnswer = rand.nextInt(41);
            while (wrongAnswer == (a + b)) {
                wrongAnswer=rand.nextInt(41);
            }
            answers.add(wrongAnswer);

        }
        op1.setText(Integer.toString(answers.get(0)));
        op2.setText(Integer.toString(answers.get(1)));
        op3.setText(Integer.toString(answers.get(2)));
        op4.setText(Integer.toString(answers.get(3)));

    }
    public void go(View view)
    {
         goButton.setVisibility(View.INVISIBLE);
        op1.setVisibility(View.VISIBLE);
        op2.setVisibility(View.VISIBLE);
        op3.setVisibility(View.VISIBLE);
        op4.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        problem.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);

        new CountDownTimer(30000, 100) {
            @Override
            public void onTick(long l) {
                timer.setText(Long.toString(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                result.setText("Done!");
                playAgain.setVisibility(View.VISIBLE);
                op1.setVisibility(View.INVISIBLE);
                op2.setVisibility(View.INVISIBLE);
                op3.setVisibility(View.INVISIBLE);
                op4.setVisibility(View.INVISIBLE);
                //result.setVisibility(View.INVISIBLE);
                timer.setVisibility(View.INVISIBLE);
                problem.setVisibility(View.INVISIBLE);
                score.setVisibility(View.INVISIBLE);
            }
        }.start();

    }
    public void answer(View view)
    {
       newQuestion(view);

    }
    public void restart(View view)
    {
        sum=0;
        total=0;
        timer.setText("30s");
        score.setText(Integer.toString(sum)+"/"+Integer.toString(total));
        op1.setVisibility(View.VISIBLE);
        op2.setVisibility(View.VISIBLE);
        op3.setVisibility(View.VISIBLE);
        op4.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        problem.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        playAgain.setVisibility(View.INVISIBLE);
        new CountDownTimer(30000, 100) {
            @Override
            public void onTick(long l) {
                timer.setText(Long.toString(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                result.setText("Done!");
                playAgain.setVisibility(View.VISIBLE);
                op1.setVisibility(View.INVISIBLE);
                op2.setVisibility(View.INVISIBLE);
                op3.setVisibility(View.INVISIBLE);
                op4.setVisibility(View.INVISIBLE);
                //result.setVisibility(View.INVISIBLE);
                timer.setVisibility(View.INVISIBLE);
                problem.setVisibility(View.INVISIBLE);
                score.setVisibility(View.INVISIBLE);
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         goButton=findViewById(R.id.button);
         op1=findViewById(R.id.op1);
         op2=findViewById(R.id.op2);
         op3=findViewById(R.id.op3);
         op4=findViewById(R.id.op4);
         result=findViewById(R.id.result);
         score=findViewById(R.id.score);
         timer=findViewById(R.id.timer);
         playAgain=findViewById(R.id.playAgain);
        problem=findViewById(R.id.problem);



       /* new CountDownTimer(32000, 100) {
            @Override
            public void onTick(long l) {
                timer.setText(Long.toString(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                result.setText("Done!");
                playAgain.setVisibility(View.VISIBLE);
                op1.setVisibility(View.INVISIBLE);
                op2.setVisibility(View.INVISIBLE);
                op3.setVisibility(View.INVISIBLE);
                op4.setVisibility(View.INVISIBLE);
                result.setVisibility(View.INVISIBLE);
                timer.setVisibility(View.INVISIBLE);
                problem.setVisibility(View.INVISIBLE);
                score.setVisibility(View.INVISIBLE);
            }
        }.start();*/



    }
}
