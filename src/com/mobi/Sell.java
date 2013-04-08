package com.mobi;

import com.auto.AutoMain;
import com.auto.R;
import com.dash.DashBoardActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

public class Sell extends DashBoardActivity implements OnClickListener{
	ImageView searchBtn, infoBtn, homeBtn;
	Spinner make_spin, model_spin, tran_spin, color_spin, loc_spin;
	Button nextBtn;
	
	static final String[] MAKE = new String[] {
		   "Any Make","Toyota", "Nissan", "Mitzubishi", "Mazda",
		   "Subaru","Isuzu", "Volkswagen", "Mercedez-Benz", "Land Rover"};
	static final String[] MODEL = new String[] {
			"Any Model","Forester", "Impreza", "Legacy", "Cube", "Sedan", "Pathfinder", "Passat"};
	static final String[] TRANSMISSION = new String[] {"Select", "Manual", "Automatic"};
	static final String[] COLOR = new String[] {"Red", "Blue", "Black", "White", "Fuschia", "Vintage", "Brown"};
	static final String[] LOCATION = new String[] {"Nairobi", "Kisumu", "Nakuru", "Mombasa", "Naivasha"};
	@Override
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.sell);
	      
	      searchBtn = (ImageView) findViewById(R.id.search_btn);
	      searchBtn.setOnClickListener(this);      
	      
	      homeBtn = (ImageView) findViewById(R.id.home_btn);
	      homeBtn.setOnClickListener(this);
	      
	      make_spin = (Spinner) findViewById(R.id.spinner1);
	      model_spin = (Spinner) findViewById(R.id.spinner2);
	      tran_spin = (Spinner) findViewById(R.id.trans);
	      color_spin = (Spinner) findViewById(R.id.colour_spinner);
	      loc_spin = (Spinner) findViewById(R.id.location_spin);
	      
	      nextBtn = (Button) findViewById(R.id.next_btn);
	      
	      ArrayAdapter<String> make_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, MAKE);
	      make_spin.setAdapter(make_adapter);
	      
	      ArrayAdapter<String> model_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, MODEL);
	      model_spin.setAdapter(model_adapter);
	      
	      ArrayAdapter<String> tran_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, TRANSMISSION);
	      tran_spin.setAdapter(tran_adapter);
	      
	      ArrayAdapter<String> color_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, COLOR);
	      color_spin.setAdapter(color_adapter);
	      
	      ArrayAdapter<String> loc_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, LOCATION);
	      loc_spin.setAdapter(loc_adapter);
 
	}


	public void onClick(View v) {
		// TODO Auto-generated method stub
		int pressed = v.getId();
		
		switch(pressed){
			case R.id.search_btn:
				startActivity(new Intent(getApplicationContext(), Search.class));
				break;
		
			case R.id.home_btn:
				startActivity(new Intent(getApplicationContext(), AutoMain.class));
				break;
			case R.id.next_btn:
				startActivity(new Intent(getApplicationContext(), Upload.class));
				break;
			default:
				break;
		}
	}
}