package com.example.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarLogoAdapter extends RecyclerView.Adapter<CarLogoAdapter.ViewHolder> {

    public List<CarLogo> mCarlogoList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView logoImage;
        TextView logoName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            logoImage = (ImageView)itemView.findViewById(R.id.logo_image);
            logoName = (TextView) itemView.findViewById(R.id.logo_name);
        }
    }


    @NonNull
    @Override
    public CarLogoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CarLogoAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
