package com.example.android.adrenaland;

import com.example.android.adrenaland.R;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FragmentNavigation extends Fragment {
	public static final String ARG_CLOUD = "cloud";
	public static final String ARG_BIG_DROP = "bigDrop";
	final CharSequence[] items = {"Attractions", "Washrooms", "Guest Services", "Food Vendors", "Rest Areas"};
	private boolean [] selected = {false, false, false, false, false};
	private ImageButton addPinButton;
	private ImageButton attractPinButton1;
	private ImageButton attractPinButton2;
	private ImageButton attractBubbleButton2;
	private ImageView washroom1;
	private ImageView washroom2;
	private ImageView guest1;
	private ImageView food1;
	private ImageView food2;
	private ImageView rest1;
	private ImageView rest2;
    public FragmentNavigation() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_navigation, container, false);
        boolean cloud = getArguments().getBoolean(ARG_CLOUD);
        boolean bigDrop = getArguments().getBoolean(ARG_BIG_DROP);
        if(!cloud) cloud = false;
        if(!bigDrop) bigDrop = false;
        
        getActivity().setTitle("Navigation");
        
        washroom1 = (ImageView) rootView.findViewById(R.id.washroom1);
        washroom2 = (ImageView) rootView.findViewById(R.id.washroom2);
        guest1 = (ImageView) rootView.findViewById(R.id.guest1);
        food1 = (ImageView) rootView.findViewById(R.id.food1);
        food2 = (ImageView) rootView.findViewById(R.id.food2);
        rest1 = (ImageView) rootView.findViewById(R.id.rest1);
        rest2 = (ImageView) rootView.findViewById(R.id.rest2);
        
        attractPinButton1 = (ImageButton) rootView.findViewById(R.id.imageButton1);
        attractPinButton2 = (ImageButton) rootView.findViewById(R.id.imageButton2);
        attractBubbleButton2 = (ImageButton) rootView.findViewById(R.id.imageButton4);
        if(bigDrop) attractPinButton1.setVisibility(View.VISIBLE);
        attractPinButton2.setEnabled(cloud);
        if(cloud) attractPinButton2.setVisibility(View.VISIBLE);
        
        // Make Cloud Grazer bubble appear
        attractPinButton2.setOnClickListener(new OnClickListener() {
        	 @Override
			  public void onClick(View arg0) {
        		 attractPinButton2.setVisibility(View.INVISIBLE);
        		 attractBubbleButton2.setVisibility(View.VISIBLE);
 	   		  }
		});
        //Make info dialog appear
        attractBubbleButton2.setOnClickListener(new OnClickListener() {
        	@Override
			  public void onClick(View arg0) {
        		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	builder.setTitle("Cloud Grazer")
            	    		.setCancelable(false)
    		        	    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
    			        	    @Override
    			        	    public void onClick(DialogInterface dialog, int id) {
    			        	    	attractPinButton2.setVisibility(View.VISIBLE);
    			   	        		attractBubbleButton2.setVisibility(View.INVISIBLE);
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
        addPinButton = (ImageButton) rootView.findViewById(R.id.imageButton3);
        addPinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	AlertDialog.Builder dlgAlert= new AlertDialog.Builder(getActivity())
			    .setTitle("What are you looking for?")
			    .setCancelable(true)
			    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			       	public void onClick(DialogInterface dialog, int whichButton) { }
			    });
			    dlgAlert.setMultiChoiceItems(items, selected, new DialogInterface.OnMultiChoiceClickListener() {

		            @Override
		            public void onClick(DialogInterface dialog, int which, boolean isChecked) {   
		            	if(isChecked)
		            	{
		            		selected[which] = isChecked;
		            	}
		            	switch(which) {
		            	case 0: // Attractions
		            		if(isChecked) {
		            	        attractPinButton1.setVisibility(View.VISIBLE);
		            	        attractPinButton2.setVisibility(View.VISIBLE);
		            	        attractPinButton2.setEnabled(true);
		            		} else {
		            	        attractPinButton1.setVisibility(View.INVISIBLE);
		            	        attractPinButton2.setVisibility(View.INVISIBLE);
		            	        attractPinButton2.setEnabled(false);
		            		}
		            		break;
		            	case 1: // Washroom selected
		            		if(isChecked) {
		            			washroom1.setVisibility(View.VISIBLE);
		            			washroom2.setVisibility(View.VISIBLE);
		            		} else {
		            			washroom1.setVisibility(View.INVISIBLE);
		            			washroom2.setVisibility(View.INVISIBLE);
		            		}
		            		break;
		            	case 2: // Guest services selected
		            		if(isChecked) {
		            			guest1.setVisibility(View.VISIBLE);
		            		} else {
		            			guest1.setVisibility(View.INVISIBLE);
		            		}
		            		break;
		            	case 3: // Food selected
		            		if(isChecked) {
		            			food1.setVisibility(View.VISIBLE);
		            			food2.setVisibility(View.VISIBLE);
		            		} else {
		            			food1.setVisibility(View.INVISIBLE);
		            			food2.setVisibility(View.INVISIBLE);
		            		}
		            		break;
		            case 4: // rest selected
	            		if(isChecked) {
	            			rest1.setVisibility(View.VISIBLE);
	            			rest2.setVisibility(View.VISIBLE);
	            		} else {
	            			rest1.setVisibility(View.INVISIBLE);
	            			rest2.setVisibility(View.INVISIBLE);
	            		}
	            		break;
		            }
		            }
		        });
			dlgAlert.create().show();
            }
        });
        
        return rootView;
    }
}