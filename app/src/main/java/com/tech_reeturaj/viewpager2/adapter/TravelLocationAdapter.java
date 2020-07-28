package com.tech_reeturaj.viewpager2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;
import com.tech_reeturaj.viewpager2.R;
import com.tech_reeturaj.viewpager2.model.TravelLocation;

import java.util.List;


public class TravelLocationAdapter extends RecyclerView.Adapter<TravelLocationAdapter.TravelLocationViewHolder>{

    private List<TravelLocation> travelLocations;

    public TravelLocationAdapter(List<TravelLocation> travelLocations) {
        this.travelLocations = travelLocations;
    }

    @NonNull
    @Override
    public TravelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TravelLocationViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_container_location,
                        parent,
                        false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TravelLocationViewHolder holder, int position) {
        holder.setLocationdata(travelLocations.get(position));
    }

    @Override
    public int getItemCount() {
        return travelLocations.size();
    }

    static class TravelLocationViewHolder extends RecyclerView.ViewHolder {

        private KenBurnsView kbvLocation;
        private TextView textTitle, textLocation, textStarRating;

        TravelLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            kbvLocation=itemView.findViewById(R.id.kbvLocation);
            textTitle=itemView.findViewById(R.id.textTitle);
            textLocation=itemView.findViewById(R.id.textLocation);
            textStarRating=itemView.findViewById(R.id.textstarRating);
        }

        void setLocationdata(TravelLocation travelLocation){
            Picasso.get().load(travelLocation.getImageurl()).into(kbvLocation);
            textTitle.setText(travelLocation.getTitle());
            textLocation.setText(travelLocation.getLocation());
            textStarRating.setText(String.valueOf(travelLocation.getStarrating()));
        }
    }
}
