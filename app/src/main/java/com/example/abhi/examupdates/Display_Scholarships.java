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

public class Display_Scholarships extends AppCompatActivity {

    ImageView imageView;

    String offered_by,terms_and_condition,benefits,apply_online,description,eligibility,headline,last_date,contact_details,
            official_website,others,start_date,url;

    TextView theadline,tdesc,toffered_by,teligibility,
            tstart_date,tlast_date,tterms_and_condition,tbenefits,tapply_online,tcontact_details,tofficial_website,tothers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__scholarships);

        imageView=findViewById(R.id.image);


        theadline=findViewById(R.id.headline);
        tdesc=findViewById(R.id.description);
        tterms_and_condition=findViewById(R.id.terms);
        toffered_by=findViewById(R.id.offeredBy);
        teligibility=findViewById(R.id.eduQualification);
        tstart_date=findViewById(R.id.startDate);
        tlast_date=findViewById(R.id.lastDate);
        tcontact_details=findViewById(R.id.contacts);
        tbenefits=findViewById(R.id.benefits);
        tapply_online=findViewById(R.id.apply);
        tofficial_website=findViewById(R.id.offiWebsite);
        tothers=findViewById(R.id.others);


        Intent intent = getIntent();
        headline=intent.getStringExtra("HEADLINE");
        description=intent.getStringExtra("DESCRIPTION");
        terms_and_condition=intent.getStringExtra("TERMS_AND_CONDITION");
        offered_by=intent.getStringExtra("OFFERED_BY");
        eligibility=intent.getStringExtra("ELIGIBILITY");
        start_date=intent.getStringExtra("START_DATE");
        last_date=intent.getStringExtra("LAST_DATE");
        benefits=intent.getStringExtra("BENEFITS");
        apply_online=intent.getStringExtra("APPLY_ONLINE");
        contact_details=intent.getStringExtra("CONTACT_DETAILS");
        official_website=intent.getStringExtra("OFFICIAL_WEBSITE");
        others=intent.getStringExtra("OTHERS");
        url=intent.getStringExtra("URL");


        theadline.setText(headline);
        tdesc.setText(description);
        tterms_and_condition.setText(terms_and_condition);
        tbenefits.setText(benefits);
        teligibility.setText(eligibility);
        tstart_date.setText(start_date);
        tlast_date.setText(last_date);
        toffered_by.setText(offered_by);
        tapply_online.setText(apply_online);
        tcontact_details.setText(contact_details);
        tofficial_website.setText(official_website);
        tothers.setText(others);

        tothers.setSelected(true);

        Picasso.get().load(url).into(imageView);


        //for underlining the textViews
        tapply_online.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        tofficial_website.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        tapply_online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(apply_online));
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
        Intent i = new Intent(Display_Scholarships.this,Scholarships.class);
        startActivity(i);
        Display_Scholarships.this.finish();
    }
}
