package com.example.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleAdapterViewHolder> {

    static DanceDetails[] details;
    PeopleAdapter(DanceDetails[] details)
    {
        this.details=details;

    }
    public static class PeopleAdapterViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,origin,gener;
        ImageView small_dp;
        Context mContext;

        public PeopleAdapterViewHolder(final View itemView)
        {
            super(itemView);
            mContext=itemView.getContext();
            name=itemView.findViewById(R.id.name);
            origin=itemView.findViewById(R.id.last);

            gener=itemView.findViewById(R.id.gener);

            small_dp=itemView.findViewById(R.id.bg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(itemView.getContext(),profiles.class);
                    i.putExtra("obj",details).putExtra("pos",getAdapterPosition());
                    itemView.getContext().startActivity(i);

                }
            });
        }
    }

    @NonNull
    @Override
    public PeopleAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_layout,parent,false);
        return new PeopleAdapterViewHolder(view);

    }

    public void onBindViewHolder(@NonNull PeopleAdapterViewHolder holder,int position)
    {
        holder.name.setText(details[position].nam);
        holder.origin.setText(details[position].ori);
        holder.gener.setText(details[position].gen);
        int resID=holder.mContext.getResources().getIdentifier(details[position].imageName,"mipmap",holder.mContext.getPackageName());
        holder.small_dp.setImageBitmap(BitmapFactory.decodeResource(holder.mContext.getResources(),resID));

    }



    public int getItemCount()
    {
        return details.length;
    }
}
