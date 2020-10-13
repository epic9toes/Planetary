package com.looptrace.planetary.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.looptrace.planetary.R;
import com.looptrace.planetary.models.Planet;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder> {

    private ArrayList<Planet> mPlanets;

    public PlanetAdapter(ArrayList<Planet> planets) {
        mPlanets = planets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_recycler_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Planet planet = mPlanets.get(position);

        holder.mName.setText(planet.getName());
        holder.mSunDistance.setText(planet.getSun_distance());
        holder.mDateDiscovered.setText(planet.getDate_discovered());
        holder.mDiscoveredBy.setText(planet.getDiscovered_by());
//        holder.mPlanetImage.setImageDrawable(planet.getDiscovered_by());
    }


    @Override
    public int getItemCount() {
        return mPlanets.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mName, mSunDistance, mDateDiscovered, mDiscoveredBy;
        private CircleImageView mPlanetImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mSunDistance = itemView.findViewById(R.id.sun_distance);
            mDateDiscovered = itemView.findViewById(R.id.date_discovered);
            mDiscoveredBy = itemView.findViewById(R.id.discovered_by);
            mPlanetImage = itemView.findViewById(R.id.planet_image);
        }
    }
}
