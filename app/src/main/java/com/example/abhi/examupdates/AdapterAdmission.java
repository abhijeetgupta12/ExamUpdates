package com.example.abhi.examupdates;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterAdmission extends RecyclerView.Adapter<AdapterAdmission.AdapterViewHolder> {

    List<String> data,img;
    Context context;
    UserAdmission user = new UserAdmission();
    int k=0;

    String admit_card_date,age_limit,application_fee,apply_online,description,educational_qualification,exam_date,headline,
            last_date,notification,official_website,others,start_date,url;

    DatabaseReference examUpdate;



    public AdapterAdmission(Context context , List<String> data, List<String> img)
    {
        this.data=data;
        this.img=img;
        this.context=context;
    }


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater =  LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.resource,viewGroup,false);       //view created
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder adapterViewHolder, final int i) {

        String title = data.get(i);                                              //view objects are bind with data
        adapterViewHolder.textView.setText(title);
        Picasso.get().load(img.get(i)).resize(300,150).into(adapterViewHolder.imageView);

        adapterViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //________________________________________________________________________________________________________________


                examUpdate = FirebaseDatabase.getInstance().getReference("ExamUpdates").child("Admissions");
                examUpdate.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            user = ds.getValue(UserAdmission.class);
                            if(i==k)
                            {
                                if(user!=null) {


                                    description = user.getDescription();
                                    headline = user.getHeadline();
                                    admit_card_date = user.getAdmit_card_date();
                                    application_fee = user.getApplication_fee();
                                    apply_online = user.getApply_online();
                                    age_limit = user.getAge_limit();
                                    educational_qualification = user.getEducational_qualification();
                                    exam_date = user.getExam_date();
                                    notification = user.getNotification();
                                    official_website = user.getOfficial_website();
                                    others = user.getOthers();
                                    url = user.getUrl();
                                    start_date = user.getStart_date();
                                    last_date = user.getLast_date();


                                    Intent intent = new Intent(context, Display_Admissions.class);
                                    intent.putExtra("HEADLINE", headline);
                                    intent.putExtra("DESCRIPTION", description);
                                    intent.putExtra("FEE", application_fee);
                                    intent.putExtra("AGE_LIMIT", age_limit);
                                    intent.putExtra("EDUCATIONAL_QUALIFICATION", educational_qualification);
                                    intent.putExtra("START_DATE", start_date);
                                    intent.putExtra("LAST_DATE", last_date);
                                    intent.putExtra("ADMIT_CARD", admit_card_date);
                                    intent.putExtra("EXAM_DATE", exam_date);
                                    intent.putExtra("APPLY_ONLINE", apply_online);
                                    intent.putExtra("NOTIFICATION", notification);
                                    intent.putExtra("OFFICIAL_WEBSITE", official_website);
                                    intent.putExtra("OTHERS", others);
                                    intent.putExtra("URL", url);


                                    context.startActivity(intent);
                                    ((Activity) context).finish();


                                }

                                break;


                            }

                            k++;
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                //___________________________________________________________________________________________________________________





            }
        });


    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;

        public AdapterViewHolder(View itemView) {               //view sent to be kept in a viewholder

            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);
            linearLayout=itemView.findViewById(R.id.linear);


        }
    }
}
