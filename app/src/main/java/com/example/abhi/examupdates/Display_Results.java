package com.example.abhi.examupdates;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Display_Results extends AppCompatActivity {

    String resultUrl,description,headline,official_website,others,url;

    TextView tresultUrl,tdescription,theadline,tofficial_website,tothers;

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__results);

        theadline=findViewById(R.id.headline);
        tdescription=findViewById(R.id.description);
        tresultUrl=findViewById(R.id.result);
        tofficial_website=findViewById(R.id.offiWebsite);
        tothers=findViewById(R.id.others);

        imageView=findViewById(R.id.image);

        Intent intent = getIntent();
        headline=intent.getStringExtra("HEADLINE");
        description=intent.getStringExtra("DESCRIPTION");
        resultUrl=intent.getStringExtra("RESULT");
        official_website=intent.getStringExtra("OFFICIAL_WEBSITE");
        others=intent.getStringExtra("OTHERS");
        url=intent.getStringExtra("URL");

        theadline.setText(headline);
        tdescription.setText(description);
        tresultUrl.setText(resultUrl);
        tofficial_website.setText(official_website);
        tothers.setText(others);

        tothers.setSelected(true);

        Picasso.get().load(url).into(imageView);


        //for underlining the textViews
        tresultUrl.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        tofficial_website.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        tresultUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(resultUrl));
                startActivity(i);

            }
        });



        tofficial_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(official_website));
                startActivity(i);

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Display_Results.this,Results.class);
        startActivity(i);
        Display_Results.this.finish();
    }

}

