package com.mobi;

import com.auto.AutoMain;
import com.auto.R;
import com.dash.DashBoardTabActivity;
import com.tab.CompanyTab;
import com.tab.RentTab;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;

public class Hire extends DashBoardTabActivity implements OnClickListener {
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hire);

		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		// Create an Intent to launch an Activity for the tab (to be reused)
		intent = new Intent().setClass(this, CompanyTab.class);

		// Initialize a TabSpec for each tab and add it to the TabHost
		spec = tabHost
				.newTabSpec("artists")
				.setIndicator("Hire Company",
						res.getDrawable(R.drawable.comp_icon))
				.setContent(intent);
		tabHost.addTab(spec);

		// Do the same for the other tabs
		intent = new Intent().setClass(this, RentTab.class);
		spec = tabHost
				.newTabSpec("albums")
				.setIndicator("Hire a Car", res.getDrawable(R.drawable.caricon))
				.setContent(intent);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(2);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		int pressed = v.getId();

		switch (pressed) {
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
