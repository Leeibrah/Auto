package com.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class GetDialog extends AsyncTask<Object, Void, String>{
	Context context;
	ProgressDialog dialog;
	
	public GetDialog(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}
	
	protected void onPreExecute(){
		super.onPreExecute();
		dialog = new ProgressDialog(context);
		dialog.setMessage("Please Wait. Loading...");
		dialog.show();
	}
	
	protected void onPostExecute(String result){
		super.onPostExecute(result);
		dialog.dismiss();
	}
	@Override
	protected String doInBackground(Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

}
