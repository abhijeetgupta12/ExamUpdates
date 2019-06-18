package com.example.abhi.examupdates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView marque;

    CardView jobs,admissions,results,answerkey,syllabus,scholarships;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        jobs=findViewById(R.id.jobs);
        admissions=findViewById(R.id.admissions);
        results=findViewById(R.id.results);
        answerkey=findViewById(R.id.answerkey);
        syllabus=findViewById(R.id.syllabus);
        scholarships=findViewById(R.id.scholarships);


        marque=findViewById(R.id.marque);
        marque.setText("Welcome to ExamUpdates........Get the latest notification of Jobs,Admisssions,Results,Answer Keys,Syllabus,Scholarship and much more" +
                "at one place..");
        marque.setSelected(true);


        jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePage.this,Jobs.class));

            }
        });

        admissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePage.this,Admissions.class));
            }
        });

        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePage.this,Results.class));
            }
        });

        answerkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePage.this,AnswerKey.class));
            }
        });

        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePage.this,Syllabus.class));
            }
        });

        scholarships.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePage.this,Scholarships.class));
            }
        });

    }
}
