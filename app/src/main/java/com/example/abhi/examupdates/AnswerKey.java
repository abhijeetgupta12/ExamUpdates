package com.example.abhi.examupdates;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.FadingCircle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AnswerKey extends AppCompatActivity {

    DatabaseReference examUpdate;
    UserAnswerKey user = new UserAnswerKey();
    List<String> headline,url;
    RecyclerView programmingList;
    ProgressBar progressBar;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_key);

        imageView=findViewById(R.id.img);

        programmingList = (RecyclerView)findViewById(R.id.recycler);
        programmingList.setLayoutManager(new LinearLayoutManager(this));

        progressBar = findViewById(R.id.progress);
        FadingCircle wave = new FadingCircle();
        progressBar.setIndeterminateDrawable(wave);

        examUpdate = FirebaseDatabase.getInstance().getReference("ExamUpdates").child("AnswerKey");

        retrieveData obj =new retrieveData();
        Thread t1 = new Thread(obj);
        if(haveNetwork()) {

            t1.start();
            progressBar.setVisibility(View.VISIBLE);

        }
        else
        {
            Toast.makeText(AnswerKey.this, "Plz check your internet connection", Toast.LENGTH_SHORT).show();
        }



    }

    private boolean haveNetwork()
    {
        boolean have_WIFI=false;
        boolean have_MobileData=false;

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();

        for(NetworkInfo info:networkInfos)
        {
            if(info.getTypeName().equals("WIFI"))
            {
                if(info.isConnected())
                {
                    have_WIFI=true;
                }
            }

            if (info.getTypeName().equals("MOBILE"))
            {
                if(info.isConnected())
                {
                    have_MobileData=true;
                }
            }
        }

        return have_MobileData||have_WIFI;

    }


    public class retrieveData implements Runnable{

        @Override
        public void run() {

            examUpdate.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    headline = new ArrayList<>();
                    url=new ArrayList<>();

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        user = ds.getValue(UserAnswerKey.class);

                        if(user!=null)
                        {
                            headline.add(user.getHeadline());
                            url.add(user.getUrl());
                        }
                    }
                    programmingList.setAdapter(new AdapterAnswerKey(AnswerKey.this,headline,url));
                    progressBar.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(AnswerKey.this,databaseError.toString(),Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);

                }
            });


        }
    }

    @Override
    public void onBackPressed() {

        finish();
        headline=null;
    }

}
