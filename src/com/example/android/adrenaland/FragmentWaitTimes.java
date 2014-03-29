package com.example.android.adrenaland;

import com.example.android.adrenaland.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentWaitTimes extends Fragment {
    //public static final String ARG_PLANET_NUMBER = "planet_number";

    public FragmentWaitTimes() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wait_times, container, false);
        getActivity().setTitle("Wait Times");
        return rootView;
    }
}