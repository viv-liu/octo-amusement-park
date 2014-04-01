package com.example.android.adrenaland;

import com.example.android.adrenaland.R;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

public class FragmentWaitTimes extends Fragment {
	private TableRow cloudRow;
	private TableRow bigRow;

    public FragmentWaitTimes() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wait_times, container, false);
        getActivity().setTitle("Wait Times");
        
        cloudRow = (TableRow) rootView.findViewById(R.id.tableRow1);
        bigRow = (TableRow) rootView.findViewById(R.id.tableRow2);
        
        cloudRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	builder.setTitle("Cloud Grazer")
            	    		.setCancelable(false)
        	        	    .setPositiveButton("Take me there!", new DialogInterface.OnClickListener() {
        		        	    @Override
        		        	    public void onClick(DialogInterface dialog, int id) {
        							dialog.dismiss();
        							((MainActivity)getActivity()).selectItemSeeRidePin(true, false);
        		        	    }
        	        	    })
        	        	    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        		        	    @Override
        		        	    public void onClick(DialogInterface dialog, int id) {
        		        	    	dialog.dismiss();
        		        	    }
        		        	});
            	 LayoutInflater inflater = getActivity().getLayoutInflater();
            	 View dialogLayout = inflater.inflate(R.layout.dialog_ride_info, null);
         		 builder.setView(dialogLayout);
            	AlertDialog alert = builder.create();		        	
            	alert.show();
            }
        });
        
        bigRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	builder.setTitle("Big Drop")
            	    		.setCancelable(false)
        	        	    .setPositiveButton("Take me there!", new DialogInterface.OnClickListener() {
        		        	    @Override
        		        	    public void onClick(DialogInterface dialog, int id) {
        							dialog.dismiss();
        							((MainActivity)getActivity()).selectItemSeeRidePin(false, true);
        		        	    }
        	        	    })
        	        	    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        		        	    @Override
        		        	    public void onClick(DialogInterface dialog, int id) {
        		        	    	dialog.dismiss();
        		        	    }
        		        	});
            	 LayoutInflater inflater = getActivity().getLayoutInflater();
            	 View dialogLayout = inflater.inflate(R.layout.dialog_ride_info, null);
            	 builder.setTitle("Big Drop");
	     			ImageView pic = (ImageView) dialogLayout.findViewById(R.id.imageView1);
	     			TextView description = (TextView) dialogLayout.findViewById(R.id.textViewDescription);
	     			pic.setImageResource(R.drawable.bigdrop600);
	     			description.setText("Prepare to drop 800m to the ground accelerating faster than gravity. People have complained about feeling ''like a pancake'' after climbing out.");
	         		 builder.setView(dialogLayout);
	            	AlertDialog alert = builder.create();		        	
	            	alert.show();
            }
        });
        
        
       
        return rootView;
    }
}