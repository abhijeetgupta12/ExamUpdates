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

public class Display_Admissions extends AppCompatActivity {

    String headline,desc,application_fee,age_limit,educational_qualification,start_date,last_date,admit_card_date,exam_date,
            apply_online,notification,official_website,others,url;


    TextView theadline,tdesc,tapplication_fee,tage_limit,teducational_qualification,
            tstart_date,tlast_date,tadmit_card_date,texam_date,tapply_online,tnotification,tofficial_website,tothers;

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__admissions);

        imageView=findViewById(R.id.image);

        theadline=findViewById(R.id.headline);
        tdesc=findViewById(R.id.description);
        tapplication_fee=findViewById(R.id.fee);
        tage_limit=findViewById(R.id.ageLimit);
        teducational_qualification=findViewById(R.id.eduQualification);
        tstart_date=findViewById(R.id.startDate);
        tlast_date=findViewById(R.id.lastDate);
        tadmit_card_date=findViewById(R.id.admitCard);
        texam_date=findViewById(R.id.examDate);
        tapply_online=findViewById(R.id.apply);
        tnotification=findViewById(R.id.notification);
        tofficial_website=findViewById(R.id.offiWebsite);
        tothers=findViewById(R.id.others);



        Intent intent = getIntent();
        headline=intent.getStringExtra("HEADLINE");
        desc=intent.getStringExtra("DESCRIPTION");
        application_fee=intent.getStringExtra("FEE");
        age_limit=intent.getStringExtra("AGE_LIMIT");
        educational_qualification=intent.getStringExtra("EDUCATIONAL_QUALIFICATION");
        start_date=intent.getStringExtra("START_DATE");
        last_date=intent.getStringExtra("LAST_DATE");
        admit_card_date=intent.getStringExtra("ADMIT_CARD");
        exam_date=intent.getStringExtra("EXAM_DATE");
        apply_online=intent.getStringExtra("APPLY_ONLINE");
        notification=intent.getStringExtra("NOTIFICATION");
        official_website=intent.getStringExtra("OFFICIAL_WEBSITE");
        others=intent.getStringExtra("OTHERS");
        url=intent.getStringExtra("URL");

        theadline.setText(headline);
        tdesc.setText(desc);
        tapplication_fee.setText(application_fee);
        tage_limit.setText(age_limit);
        teducational_qualification.setText(educational_qualification);
        tstart_date.setText(start_date);
        tlast_date.setText(last_date);
        tadmit_card_date.setText(admit_card_date);
        texam_date.setText(exam_date);
        tapply_online.setText(apply_online);
        tnotification.setText(notification);
        tofficial_website.setText(official_website);
        tothers.setText(others);

        tothers.setSelected(true);

        Picasso.get().load(url).into(imageView);


        //for underlining the textViews
        tapply_online.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        tnotification.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        tofficial_website.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        tapply_online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(apply_online));
                startActivity(i);

            }
        });

        tnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(notification));
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
        Intent i = new Intent(Display_Admissions.this,Admissions.class);
        startActivity(i);
        Display_Admissions.this.finish();
    }

}

