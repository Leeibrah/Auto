package com.auto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.mobi.*;


public class AutoMain extends Activity implements OnClickListener{
	Button aboutBtn, sellBtn, buyBtn, hireBtn, mapBtn, tipsBtn, searchBtn, infoBtn;
	ImageView searchView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        searchBtn = (Button) findViewById(R.id.home_btn_feature1);
        sellBtn = (Button) findViewById(R.id.home_btn_feature2);
        hireBtn = (Button) findViewById(R.id.home_btn_feature3);
        mapBtn = (Button) findViewById(R.id.home_btn_feature4);
        tipsBtn = (Button) findViewById(R.id.home_btn_feature5);
        aboutBtn = (Button) findViewById(R.id.home_btn_feature6);
        infoBtn = (Button) findViewById(R.id.home_btn_feature6);
        
        
        sellBtn.setOnClickListener(this);
        hireBtn.setOnClickListener(this);
        mapBtn.setOnClickListener(this);
        tipsBtn.setOnClickListener(this);
        aboutBtn.setOnClickListener(this);
        infoBtn.setOnClickListener(this);
        searchBtn.setOnClickListener(this);

        searchView = (ImageView) findViewById(R.id.search_btn);
        searchView.setOnClickListener(this);

    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.home_btn_feature1){
			Intent t = new Intent(v.getContext(), Search.class);
			startActivity(t);
		}if(v.getId() == R.id.home_btn_feature2){
			Intent t = new Intent(v.getContext(), Upload.class);
			startActivity(t);
		}if(v.getId() == R.id.home_btn_feature3){
			Intent t = new Intent(v.getContext(), Hire.class);
			startActivity(t);
		}if(v.getId() == R.id.home_btn_feature4){
			Intent t = new Intent(v.getContext(), Dealers.class);
			startActivity(t);
		}if(v.getId() == R.id.home_btn_feature5){
			Intent t = new Intent(v.getContext(), Tips.class);
			startActivity(t);
		}if(v.getId() == R.id.home_btn_feature6){
			Intent t = new Intent(v.getContext(), About.class);
			startActivity(t);
		}if(v.getId() == R.id.search_btn){
			Intent t = new Intent(v.getContext(), Search.class);
			startActivity(t);
		}
	}
}