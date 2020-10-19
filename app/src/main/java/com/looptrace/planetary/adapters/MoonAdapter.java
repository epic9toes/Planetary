package com.looptrace.planetary.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.looptrace.planetary.R;
import com.looptrace.planetary.models.Moon;
import com.looptrace.planetary.models.PlanetMoon;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MoonAdapter extends RecyclerView.Adapter<MoonAdapter.ViewHolder> {

    private ArrayList<PlanetMoon> mMoons;
    private OnMoonListener mOnMoonListener;

    public MoonAdapter(ArrayList<PlanetMoon> moons, OnMoonListener onMoonListener) {
        mMoons = moons;
        mOnMoonListener = onMoonListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.available_moon_item, parent, false);
        return new ViewHolder(view, mOnMoonListener);
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

        PlanetMoon moon = mMoons.get(position);
        holder.mName.setText(moon.getMoon());
//        holder.mPlanetImage.setImageDrawable(planet.getDiscovered_by());
    }


    @Override
    public int getItemCount() {
        return mMoons.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mName;
        private CircleImageView mPlanetImage;
        OnMoonListener mOnMoonListener;

        public ViewHolder(@NonNull View itemView, OnMoonListener onPlanetListener) {
            super(itemView);

            mName = itemView.findViewById(R.id.moon_name);
            mPlanetImage = itemView.findViewById(R.id.moon_image);
            mOnMoonListener = onPlanetListener;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            mOnMoonListener.onMoonClick(v, getAdapterPosition());
        }
    }

    public interface OnMoonListener {
        void onMoonClick(View view, int position);
    }
}
