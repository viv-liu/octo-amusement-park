package com.example.android.adrenaland;

import com.example.android.adrenaland.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;

public class FragmentHome extends Fragment {
	private ImageButton mapButton;
	private TableLayout nearRidesTable;
    public FragmentHome() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("Home");
        
        mapButton = (ImageButton) rootView.findViewById(R.id.imageButton1);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	((MainActivity) getActivity()).selectItem(1);
            }
        });
        nearRidesTable = (TableLayout) rootView.findViewById(R.id.tableLayout1);
        nearRidesTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	((MainActivity) getActivity()).selectItem(2);
            }
        });
        return rootView;
    }
    
    public void mapButtonClicked(View v) {
    	
    }
}
