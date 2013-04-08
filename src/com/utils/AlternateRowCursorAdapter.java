package com.utils;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class AlternateRowCursorAdapter extends SimpleAdapter{

	private int[] colors = new int[] { Color.parseColor("#E6E6E6"), Color.parseColor("#D8D8D8") };

	public AlternateRowCursorAdapter(Context context, ArrayList<HashMap<String,String>> mylist, int layout, String[] from, int[] target) {
	
		super(context, mylist, layout, from, target);
		
	}
	
	
	/**
	 * Display rows in alternating colors
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = super.getView(position, convertView, parent);
		int colorPos = position % colors.length;
		view.setBackgroundColor(colors[colorPos]);
		return view;
	}
}

