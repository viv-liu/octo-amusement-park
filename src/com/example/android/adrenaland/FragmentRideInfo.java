package com.example.android.adrenaland;

import com.example.android.adrenaland.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentRideInfo extends Fragment {
	private Button rollerCoasters;
    public FragmentRideInfo() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ride_info, container, false);
        getActivity().setTitle("Ride Information");
        
        rollerCoasters = (Button) rootView.findViewById(R.id.button1);
        rollerCoasters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	((MainActivity) getActivity()).selectItem(5);
            }
        });
        return rootView;
    }
}