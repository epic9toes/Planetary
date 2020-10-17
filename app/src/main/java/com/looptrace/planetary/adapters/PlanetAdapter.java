package com.looptrace.planetary.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.looptrace.planetary.R;
import com.looptrace.planetary.models.PlanetModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder> {

    private ArrayList<PlanetModel> mPlanets;
    private OnPlanetListener mOnPlanetListener;

    public PlanetAdapter(ArrayList<PlanetModel> planets, OnPlanetListener onPlanetListener) {
        mPlanets = planets;
        mOnPlanetListener = onPlanetListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_recycler_item, parent, false);
        return new ViewHolder(view, mOnPlanetListener);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PlanetModel planet = mPlanets.get(position);

        holder.mName.setText(planet.getEnglishName());
        if (planet.getGravity() < 0) {
            holder.mGravity.setText(R.string.unavaliable);
        } else {
            holder.mGravity.setText("" + planet.getGravity());
        }

        if (planet.getDiscoveryDate().equals("")) {
            holder.mDateDiscovered.setText(R.string.unavaliable);
        } else {
            holder.mDateDiscovered.setText(planet.getDiscoveryDate());
        }

        if (planet.getDiscoveredBy().equals("")) {
            holder.mDiscoveredBy.setText(R.string.unavaliable);
        } else {
            holder.mDiscoveredBy.setText(planet.getDiscoveredBy());
        }
//        holder.mPlanetImage.setImageDrawable(planet.getDiscovered_by());
    }


    @Override
    public int getItemCount() {
        return mPlanets.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mName, mGravity, mDateDiscovered, mDiscoveredBy;
        private CircleImageView mPlanetImage;
        OnPlanetListener mOnPlanetListener;
        private Button mExploreButton;

        public ViewHolder(@NonNull View itemView, OnPlanetListener onPlanetListener) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mGravity = itemView.findViewById(R.id.gravity);
            mDateDiscovered = itemView.findViewById(R.id.date_discovered);
            mDiscoveredBy = itemView.findViewById(R.id.discovered_by);
            mPlanetImage = itemView.findViewById(R.id.planet_image);
            mExploreButton = itemView.findViewById(R.id.explore_btn);
            mOnPlanetListener = onPlanetListener;
            mExploreButton.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            mOnPlanetListener.onPlanetClick(v, getAdapterPosition());
        }
    }

    public interface OnPlanetListener {
        void onPlanetClick(View view, int position);
    }
}
