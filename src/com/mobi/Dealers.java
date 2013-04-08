package com.mobi;

import com.auto.AutoMain;
import com.auto.R;
import com.dash.DashBoardListActivity;
import com.dealers.KisumuDealers;
import com.dealers.MachakosDealers;
import com.dealers.MalindiDealers;
import com.dealers.MeruDealers;
import com.dealers.MombasaDealers;
import com.dealers.NairobiDealers;
import com.dealers.NaivashaDealers;
import com.dealers.NakuruDealers;
import com.utils.GetDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Dealers extends DashBoardListActivity implements OnClickListener{
	ImageView searchBtn, infoBtn;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.dealers);
	      new GetDialog(this).execute();
	      
	      searchBtn = (ImageView) findViewById(R.id.search_btn);
	      searchBtn.setOnClickListener(this);
	
	      
	      String[] values = new String[] { "Nairobi", "Mombasa", "Kisumu",
					"Nakuru", "Naivasha", "Machakos", "Meru", "Malindi",
					};
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, values);
			setListAdapter(adapter);
		}

		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			String item = (String) getListAdapter().getItem(position);
			Toast.makeText(this, item + " selected", Toast.LENGTH_SHORT).show();
			
			Intent myIntent = null;
			 
			if(item.equalsIgnoreCase("nairobi")){
				 myIntent = new Intent(v.getContext(), NairobiDealers.class);
				    startActivity(myIntent);
			}
			
			
			if(((TextView) v).getText().equals("Nairobi")){
			//    myIntent = new Intent(v.getContext(), NairobiDealers.class);
			  //  startActivity(myIntent);
			}if(((TextView) v).getText().equals("Mombasa")){
			    myIntent = new Intent(v.getContext(), MombasaDealers.class);
			    startActivity(myIntent);
			}if(((TextView) v).getText().equals("Kisumu")){
			    myIntent = new Intent(v.getContext(), KisumuDealers.class);
			    startActivity(myIntent);
			}if(((TextView) v).getText().equals("Meru")){
			    myIntent = new Intent(v.getContext(), MeruDealers.class);
			    startActivity(myIntent);
			}if(((TextView) v).getText().equals("Malindi")){
			    myIntent = new Intent(v.getContext(), MalindiDealers.class);
			    startActivity(myIntent);
			}if(((TextView) v).getText().equals("Naivasha")){
			    myIntent = new Intent(v.getContext(), NaivashaDealers.class);
			    startActivity(myIntent);
			}if(((TextView) v).getText().equals("Nakuru")){
			    myIntent = new Intent(v.getContext(), NakuruDealers.class);
			    startActivity(myIntent);
			}if(((TextView) v).getText().equals("Machakos")){
			    myIntent = new Intent(v.getContext(), MachakosDealers.class);
			    startActivity(myIntent);
			}
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
			default:
				break;
		}
	}
}
