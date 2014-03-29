package com.example.android.adrenaland;

import com.example.android.adrenaland.R;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class FragmentRollerCoasters extends Fragment {
	private Button backButton;
	private ListView list;
    public FragmentRollerCoasters() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_roller_coasters, container, false);
        getActivity().setTitle("Roller Coasters");
        
        backButton = (Button) rootView.findViewById(R.id.button1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	((MainActivity) getActivity()).selectItem(4);
            }
        });
        
       list = (ListView)rootView.findViewById(R.id.listView1);

	 // listener for the first one 
	 list.setOnItemClickListener(new OnItemClickListener() {
	
	         @Override
	         public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
	                 long arg3) {
	        	// custom dialog
	   			final Dialog dialog = new Dialog(getActivity());
	   			dialog.setContentView(R.layout.dialog_ride_info);
	   			dialog.setTitle("Cloud Grazer");
	   			dialog.setCancelable(true);
	    
	   			Button dialogButton = (Button) dialog.findViewById(R.id.button1);
	   			// if button is clicked, close the custom dialog
	   			dialogButton.setOnClickListener(new OnClickListener() {
	   				@Override
	   				public void onClick(View v) {
	   					dialog.dismiss();
	   				}
	   			});
	   			dialog.show();
	   		  }
	     });
        
        return rootView;
    }
}
