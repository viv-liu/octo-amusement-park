package com.example.android.adrenaland;

import com.example.android.adrenaland.R;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

public class FragmentShowTimes extends Fragment {
	private TableRow abraInfo;
	private TableRow dinoInfo;
    public FragmentShowTimes() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_show_times, container, false);
        getActivity().setTitle("Show Times");
        
        abraInfo = (TableRow) rootView.findViewById(R.id.tableRow1);
        dinoInfo = (TableRow) rootView.findViewById(R.id.tableRow2);
        
        dinoInfo.setOnClickListener(new OnClickListener() {
        	 
  		  @Override
  		  public void onClick(View arg0) {
   
  			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        	builder.setTitle("Dinosaurs are back!")
        	    		.setCancelable(false)
		        	    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
			        	    @Override
			        	    public void onClick(DialogInterface dialog, int id) {
			        	    	dialog.dismiss();
			        	    }
		        	    });
			
        	 LayoutInflater inflater = getActivity().getLayoutInflater();
        	 View dialogLayout = inflater.inflate(R.layout.dialog_show_time, null);
    		 builder.setView(dialogLayout);
        	AlertDialog alert = builder.create();		        	
        	alert.show();
  		  }
  		});
		abraInfo.setOnClickListener(new OnClickListener() {
 
		  @Override
		  public void onClick(View arg0) {
 
			  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	        	builder.setTitle("Cloud Grazer")
	        	    		.setCancelable(false)
			        	    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
				        	    @Override
				        	    public void onClick(DialogInterface dialog, int id) {
				        	    	
				        	    }
			        	    });
				
	        	 LayoutInflater inflater = getActivity().getLayoutInflater();
	        	 View dialogLayout = inflater.inflate(R.layout.dialog_show_time, null);
	        	 TextView textDuration = (TextView) dialogLayout.findViewById(R.id.textViewDuration);
				 TextView textDescription = (TextView) dialogLayout.findViewById(R.id.textViewDescription);
				 textDuration.setText("3h");
				 textDescription.setText("Rabbits really do come from thin air! Come to this magic show x petting zoo to see the world in a whole new light.");
	 			ImageView image = (ImageView) dialogLayout.findViewById(R.id.imageView1);
	 			image.setImageResource(R.drawable.magichat600);
	    		 builder.setView(dialogLayout);
	        	AlertDialog alert = builder.create();		        	
	        	alert.show();
			
		  }
		});
        return rootView;
    }
}