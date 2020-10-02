package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarLogoAdapter extends RecyclerView.Adapter<CarLogoAdapter.ViewHolder> {

    public List<CarLogo> mCarlogoList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View carlogoView;
        ImageView logoImage;
        TextView logoName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carlogoView = itemView;
            logoImage = (ImageView)itemView.findViewById(R.id.logo_image);
            logoName = (TextView) itemView.findViewById(R.id.logo_name);
        }
    }

    public CarLogoAdapter(List<CarLogo> carLogoList){
        mCarlogoList = carLogoList;
    }


    @NonNull
    @Override
    public CarLogoAdapter.ViewHolder
         onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.carlogo_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.carlogoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                CarLogo carLogo = mCarlogoList.get(position);
                Toast.makeText(view.getContext(),"您点击了视图 "+carLogo.getName(),
                               Toast.LENGTH_SHORT).show();
            }
        });
        holder.logoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                CarLogo carLogo = mCarlogoList.get(position);
                Toast.makeText(view.getContext(),"您点击了图片 "+carLogo.getName(),
                               Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,
                                 int position) {
        CarLogo carLogo = mCarlogoList.get(position);
        holder.logoImage.setImageResource(carLogo.getImageId());
        holder.logoName.setText(carLogo.getName());

    }

    @Override
    public int getItemCount() {
        return mCarlogoList.size();
    }
}
