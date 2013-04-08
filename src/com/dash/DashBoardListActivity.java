package com.dash;

import com.auto.AutoMain;
import com.mobi.About;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DashBoardListActivity extends ListActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    //setContentView(R.layout.activity_default);
	}
	    
	 

	@Override
	protected void onDestroy ()
	{
	   super.onDestroy ();
	}

	

	@Override
	protected void onPause ()
	{
	   super.onPause ();
	}

	

	@Override
	protected void onRestart ()
	{
	   super.onRestart ();
	}

	

	@Override
	protected void onResume ()
	{
	   super.onResume ();
	}


	@Override
	protected void onStart ()
	{
	   super.onStart ();
	}


	@Override
	protected void onStop ()
	{
	   super.onStop ();
	}


	public void onClickHome (View v)
	{
	    goHome (this);
	}




	public void onClickAbout (View v)
	{
	    startActivity (new Intent(getApplicationContext(), About.class));
	}

	

	

	public void goHome(Context context) 
	{
	    final Intent intent = new Intent(context, AutoMain.class);
	    intent.setFlags (Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    context.startActivity (intent);
	}

	
	public void setTitleFromActivityLabel (int textViewId)
	{
	    TextView tv = (TextView) findViewById (textViewId);
	    if (tv != null) tv.setText (getTitle ());
	} // end setTitleText

	public void toast (String msg)
	{
	    Toast.makeText (getApplicationContext(), msg, Toast.LENGTH_SHORT).show ();
	} // end toast

	
	public void trace (String msg) 
	{
	    Log.d("Demo", msg);
	    toast (msg);
	}

}
