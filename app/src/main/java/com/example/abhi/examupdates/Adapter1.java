package com.example.abhi.examupdates;

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

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.AdapterViewHolder> {

    List<String> data,img;
    Context context;

    public Adapter1(Context context ,List<String> data, List<String> img)
    {
        this.data=data;
        this.img=img;
        this.context=context;
    }


    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater inflater =  LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.resource,viewGroup,false);       //view created
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder adapterViewHolder, int i) {

        String title = data.get(i);                                              //view objects are bind with data
        adapterViewHolder.textView.setText(title);
        Picasso.get().load(img.get(i)).resize(300,150).into(adapterViewHolder.imageView);

        adapterViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,Display_Data.class);
                context.startActivity(intent);


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
