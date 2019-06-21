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

public class Display_AnswerKey extends AppCompatActivity {

    String pdfUrl,description,headline,official_website,others,url;

    TextView tpdfUrl,tdescription,theadline,tofficial_website,tothers;

    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__answer_key);

        theadline=findViewById(R.id.headline);
        tdescription=findViewById(R.id.description);
        tpdfUrl=findViewById(R.id.pdf);
        tofficial_website=findViewById(R.id.offiWebsite);
        tothers=findViewById(R.id.others);

        imageView=findViewById(R.id.image);

        Intent intent = getIntent();
        headline=intent.getStringExtra("HEADLINE");
        description=intent.getStringExtra("DESCRIPTION");
        pdfUrl=intent.getStringExtra("PDF");
        official_website=intent.getStringExtra("OFFICIAL_WEBSITE");
        others=intent.getStringExtra("OTHERS");
        url=intent.getStringExtra("URL");

        theadline.setText(headline);
        tdescription.setText(description);
        tpdfUrl.setText(pdfUrl);
        tofficial_website.setText(official_website);
        tothers.setText(others);

        tothers.setSelected(true);

        Picasso.get().load(url).into(imageView);


        //for underlining the textViews
        tpdfUrl.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        tofficial_website.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        tpdfUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(pdfUrl));
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
        Intent i = new Intent(Display_AnswerKey.this,AnswerKey.class);
        startActivity(i);
        Display_AnswerKey.this.finish();
    }

}

