package com.example.dell.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class adaptr extends RecyclerView.Adapter<adaptr.ViewHolder> {
    private List<Nb_event> listUsers;

    public adaptr(List<Nb_event> listUsers) {
        this.listUsers = listUsers;
    }

    @Override
    public adaptr.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_article_rec, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(adaptr.ViewHolder holder, int position) {
        holder.tv1.setText(listUsers.get(position).getTitle());
        holder.tv2.setText(listUsers.get(position).getAbout());
    }

    @Override
    public int getItemCount() {
        Log.v(adaptr.class.getSimpleName(),""+listUsers.size());
        return listUsers.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=(TextView) itemView.findViewById(R.id.tv1);
            tv2=(TextView) itemView.findViewById(R.id.tv2);

        }

}

}
