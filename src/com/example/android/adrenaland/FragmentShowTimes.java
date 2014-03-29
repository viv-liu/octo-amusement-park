package com.example.android.adrenaland;

import com.example.android.adrenaland.R;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
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
   
  			// custom dialog
  			final Dialog dialog = new Dialog(getActivity());
  			dialog.setContentView(R.layout.dialog_show_time);
  			dialog.setTitle("Dinosaurs are Back!");
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
		abraInfo.setOnClickListener(new OnClickListener() {
 
		  @Override
		  public void onClick(View arg0) {
 
			// custom dialog
			final Dialog dialog = new Dialog(getActivity());
			dialog.setContentView(R.layout.dialog_show_time);
			dialog.setTitle("Abracadabra");
			dialog.setCancelable(true);
 
			// set the custom dialog components - text, image and button
			TextView textDuration = (TextView) dialog.findViewById(R.id.textViewDuration);
			TextView textDescription = (TextView) dialog.findViewById(R.id.textViewDescription);
			textDuration.setText("3h");
			textDescription.setText("Rabbits really do come from thin air! Come to this magic show x petting zoo to see the world in a whole new light.");
			
			ImageView image = (ImageView) dialog.findViewById(R.id.imageView1);
			image.setImageResource(R.drawable.magichat600);
 
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