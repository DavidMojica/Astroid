package com.dmv.astroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlanetListAdapter extends RecyclerView.Adapter<PlanetListAdapter.PlanetViewHolder> {
    private List<PlanetOnList> planetList;
    private OnItemClickListener listener;

    public PlanetListAdapter(List<PlanetOnList> planetList, OnItemClickListener listener) {
        this.planetList = planetList;
        this.listener = listener;
    }
    public interface OnItemClickListener{
        void onItemClick(PlanetOnList planet);
    }
    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planet, parent, false);
        return new PlanetViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PlanetListAdapter.PlanetViewHolder holder, int position) {
        PlanetOnList planet = planetList.get(position);
        holder.planetName.setText(planet.getName());
        holder.planetImg.setImageResource(planet.getImgId());
        holder.bind(planet, listener);
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    static class PlanetViewHolder extends RecyclerView.ViewHolder{
        ImageView planetImg;
        TextView planetName;
        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            planetImg = itemView.findViewById(R.id.planetImage);
            planetName = itemView.findViewById(R.id.planetName);
        }

        public void bind(final PlanetOnList planet, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(planet);
                }
            });
        }

    }
}
