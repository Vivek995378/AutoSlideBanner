package com.example.bannerusingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    private Context context;
    private ArrayList<UserData> userLists;

    public CustomAdapter(Context context, ArrayList<UserData> userLists) {
        this.context = context;
        this.userLists = userLists;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView userImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.image_view);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserData data = userLists.get(position);

        holder.userImage.setImageDrawable(data.getProfileImg());
    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }

}
