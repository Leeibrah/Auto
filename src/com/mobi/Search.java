package com.mobi;

import com.auto.AutoMain;
import com.auto.R;
import com.dash.DashBoardActivity;
import com.utils.GetDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class Search extends DashBoardActivity implements OnClickListener{
	Button mainSearchBtn;
	ImageView infoBtn;
	Spinner make_spin, model_spin, year_spin, distance_spin, location_spin;
	
	static final String[] MAKE = new String[] {
		   "Select Make", "Any Make","Toyota", "Nissan", "Mitzubishi", "Mazda",
		   "Subaru","Isuzu", "Volkswagen", "Mercedez-Benz", "Land Rover"};
	static final String[] MODEL = new String[] {
			"Select Model","Any Model","Forester", "Impreza", "Legacy", "Cube", "Sedan", "Pathfinder", "Passat"
			};
	
//	static final String[] YEAR = new String[] {
//		"Select manufacture year","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993",
//		"1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008",
//		"2009","2010","2011","2012"
//	};
//	
//	static final String[] DISTANCE = new String[] {
//		"Select distance covered(Kms)", "Less than 1000", "2000", "4,000", "6,000", "8,000", "10,000", "More than 10,000"
//	};
	
	static final String[] LOCATION = new String[] {
		"Select Location", "Nairobi", "Mombasa", "Kisumu", "Nakuru", "Naivasha"
	};
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.search);
	      
	      new GetDialog(this).execute();	//loading dialog
	      
	      mainSearchBtn = (Button) findViewById(R.id.main_search_btn);
	      mainSearchBtn.setOnClickListener(this);
	      
	      
	      make_spin = (Spinner) findViewById(R.id.make_spinner);
	      model_spin = (Spinner) findViewById(R.id.model_spinner);
	      location_spin = (Spinner) findViewById(R.id.location_spinner);
	      
	      ArrayAdapter<String> make_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, MAKE);
	      make_spin.setAdapter(make_adapter);
	      
	      ArrayAdapter<String> model_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, MODEL);
	      model_spin.setAdapter(model_adapter);
	      	      
	      ArrayAdapter<String> loc_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, LOCATION);
	      location_spin.setAdapter(loc_adapter);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		int pressed = v.getId();
		
		switch(pressed){
			case R.id.home_btn:
				startActivity(new Intent(getApplicationContext(), AutoMain.class));
				break;
			case R.id.main_search_btn:
				
				searchCriteria();
				startActivity(new Intent(getApplicationContext(), CarResults.class));
				break;
			
			default:
				break;
		}
	}

	private void searchCriteria() {
		// TODO Auto-generated method stub
		make_spin.getSelectedItem().toString();
		model_spin.getSelectedItem().toString();
		location_spin.getSelectedItem().toString();
	}
}
