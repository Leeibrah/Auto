package com.mobi;

import com.auto.AutoMain;
import com.auto.R;
import com.dash.DashBoardActivity;
import com.utils.GetDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class About extends DashBoardActivity implements OnClickListener{
	ImageView searchBtn, homeBtn;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.about);
	      
	      new GetDialog(this).execute();
	      
	      searchBtn = (ImageView) findViewById(R.id.search_btn);
	      searchBtn.setOnClickListener(this);
	
	      
	      homeBtn = (ImageView) findViewById(R.id.home_btn);
	      homeBtn.setOnClickListener(this);
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
