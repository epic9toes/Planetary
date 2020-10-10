package com.looptrace.planetary.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.looptrace.planetary.R;
import com.looptrace.planetary.onboarding.screens.OnBoarding1Fragment;
import com.looptrace.planetary.onboarding.screens.OnBoarding2Fragment;
import com.looptrace.planetary.onboarding.screens.OnBoarding3Fragment;
import com.looptrace.planetary.onboarding.screens.OnBoarding4Fragment;

import java.util.ArrayList;

public class ViewPagerFragment extends Fragment {

    private ViewPager2 mViewPager;

    public ViewPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new OnBoarding2Fragment());
        fragments.add(new OnBoarding3Fragment());
        fragments.add(new OnBoarding4Fragment());

        ViewPagerAdapter adapter = new ViewPagerAdapter(requireActivity().getSupportFragmentManager(),
                getActivity().getLifecycle(), fragments);

        mViewPager = view.findViewById(R.id.view_pager);
        mViewPager.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }
}