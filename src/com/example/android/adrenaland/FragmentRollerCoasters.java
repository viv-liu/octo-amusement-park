package com.example.android.adrenaland;

import com.example.android.adrenaland.R;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentRollerCoasters extends Fragment {
	private static int indexClicked;
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
	         public void onItemClick(AdapterView<?> arg0, View arg1, int position,
	                 long arg3) {
	        	 if(position != 0 && position != 1) {
	        		 return;
	        	 }
		        	indexClicked = position;
		        	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		        	builder.setTitle("Cloud Grazer")
		        	    		.setCancelable(false)
				        	    .setPositiveButton("Take me there!", new DialogInterface.OnClickListener() {
					        	    @Override
					        	    public void onClick(DialogInterface dialog, int id) {
					        	    	if(indexClicked == 0) // Big Drop clicked
										{
											dialog.dismiss();
											((MainActivity)getActivity()).selectItemSeeRidePin(false, true);
										} else if(indexClicked == 1){  // Cloud clicked
											dialog.dismiss();
											((MainActivity)getActivity()).selectItemSeeRidePin(true, false);
										}
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
		        	 if(indexClicked == 0) { // Big Drop clicked
			   				builder.setTitle("Big Drop");
			   				ImageView pic = (ImageView) dialogLayout.findViewById(R.id.imageView1);
			   				TextView description = (TextView) dialogLayout.findViewById(R.id.textViewDescription);
			   				pic.setImageResource(R.drawable.bigdrop600);
			   				description.setText("Prepare to drop 800m to the ground accelerating faster than gravity. People have complained about feeling ''like a pancake'' after climbing out.");
			   			}
     	    		 builder.setView(dialogLayout);
		        	AlertDialog alert = builder.create();		        	
		        	alert.show();
	        	 // custom dialog
		   			/*final Dialog dialog = new Dialog(getActivity());
		   			dialog.setContentView(R.layout.dialog_ride_info);
		   			dialog.setTitle("Cloud Grazer");
		   			if(indexClicked == 0) { // Big Drop clicked
		   				dialog.setTitle("Big Drop");
		   				ImageView pic = (ImageView) dialog.findViewById(R.id.imageView1);
		   				TextView description = (TextView) dialog.findViewById(R.id.textViewDescription);
		   				pic.setBackgroundResource(R.drawable.bigdrop600);
		   				description.setText("Prepare to drop 800m to the ground accelerating faster than gravity. People have complained about feeling ''like a pancake'' after climbing out.");
		   			}
		   			
		   			dialog.setCancelable(true);
		    
		   			Button mapButton = (Button) dialog.findViewById(R.id.button1);
		   			mapButton.setOnClickListener(new OnClickListener() {
	
						@Override
						public void onClick(View v) {
							if(indexClicked == 0) // Big Drop clicked
							{
								dialog.dismiss();
								((MainActivity)getActivity()).selectItemSeeRidePin(false, true);
							} else if(indexClicked == 1){  // Cloud clicked
								dialog.dismiss();
								((MainActivity)getActivity()).selectItemSeeRidePin(true, false);
							}
						}
		   				
		   			});
		   			Button cancelButton = (Button) dialog.findViewById(R.id.button2);
		   			// if button is clicked, close the custom dialog
		   			cancelButton.setOnClickListener(new OnClickListener() {
		   				@Override
		   				public void onClick(View v) {
		   					dialog.dismiss();
		   				}
		   			});
		   			dialog.show();*/
		   		  }
		});
        
        return rootView;
    }
}
