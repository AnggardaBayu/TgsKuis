package com.example.tugaskuis;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Profile> profiles;
    public MyAdapter(Context c, ArrayList<Profile> p){
        context = c;
        profiles = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Nama.setText(profiles.get(position).getNama());
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView Nama;
        public MyViewHolder(View itemView) {
            super(itemView);
            Nama = (TextView) itemView.findViewById(R.id.Nama);
        }
    }
}
