package com.dealers;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.auto.AutoMain;
import com.auto.R;
import com.dash.DashBoardListActivity;
import com.mobi.Search;
import com.utils.AlternateRowCursorAdapter;
import com.utils.JSONfunctions;

public class MombasaDealers extends DashBoardListActivity implements
		OnClickListener {
	BufferedInputStream is;
	JSONObject e;
	String globalLat, globalLog, the_distance, dist = null;
	TextView tview5;
	CharSequence ch = dist;

	private AlternateRowCursorAdapter Adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mombasa_dealers);

		getListView().setDivider(null);
		getListView().setDividerHeight(0);

		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

		JSONObject json = JSONfunctions
				.getJSONfromURL("http://mob.wafanyikazi.org/auto/dealers.php");

		try {

			JSONArray people = json.getJSONArray("dealers");

			for (int i = 0; i < people.length(); i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				e = people.getJSONObject(i);

				map.put("id", String.valueOf(i));
				map.put("name", e.getString("dealer_name"));
				map.put("location", e.getString("location"));
				map.put("email", e.getString("email"));
				map.put("phone", "Cell: " + e.getString("phone"));
				// map.put("latitude", e.getString("latitude"));
				// map.put("logitude", e.getString("logitude"));
				// map.put("latitude", dist);

				mylist.add(map);
				// globalLat = e.getString("latitude");
				// globalLog = e.getString("logitude");
			}
		} catch (JSONException e) {
			Log.e("log_tag", "Error kupitisha data " + e.toString());
		}
		String[] from = new String[] { "name", "location", "email", "phone" };
		int[] target = new int[] { R.id.item_title, R.id.item_subtitle1,
				R.id.item_subtitle2, R.id.item_subtitle3 };

		Adapter = new AlternateRowCursorAdapter(this, mylist,
				R.layout.mombasa_list, from, target);

		// changed
		setListAdapter(Adapter);

		final ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

			}
		});
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
