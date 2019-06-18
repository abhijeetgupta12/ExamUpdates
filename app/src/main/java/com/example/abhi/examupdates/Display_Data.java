package com.example.abhi.examupdates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Display_Data extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__data);

        Intent intent = getIntent();
        String desc=intent.getStringExtra("DESC");

        textView=findViewById(R.id.text);

        textView.setText(desc);


    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Display_Data.this,Jobs.class);
        startActivity(i);
        Display_Data.this.finish();
    }
}
