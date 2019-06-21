package com.example.abhi.examupdates;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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

public class AdapterResult extends RecyclerView.Adapter<AdapterResult.AdapterViewHolder> {

    List<String> data,img;
    Context context;
    UserResult user = new UserResult();
    int k=0;

    String resultURL,description,headline,official_website,others,url;

    DatabaseReference examUpdate;

    public AdapterResult(Context context , List<String> data, List<String> img)
    {
        this.data=data;
        this.img=img;
        this.context=context;
    }


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater =  LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.resource,viewGroup,false);
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


                examUpdate = FirebaseDatabase.getInstance().getReference("ExamUpdates").child("Results");
                examUpdate.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            user = ds.getValue(UserResult.class);
                            if(i==k)
                            {
                                if(user!=null) {


                                    description = user.getDescription();
                                    headline = user.getHeadline();
                                    resultURL = user.getResultUrl();

                                    official_website = user.getOfficial_website();
                                    others = user.getOthers();
                                    url = user.getUrl();

                                    Intent intent = new Intent(context, Display_Results.class);
                                    intent.putExtra("HEADLINE", headline);
                                    intent.putExtra("DESCRIPTION", description);
                                    intent.putExtra("RESULT", resultURL);
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

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;


        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);
            linearLayout=itemView.findViewById(R.id.linear);

        }
    }
}
