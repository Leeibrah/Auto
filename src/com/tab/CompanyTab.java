package com.tab;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.auto.R;
import com.dash.DashBoardListActivity;
import com.utils.AlternateRowCursorAdapter;
import com.utils.JSONfunctions;

public class CompanyTab extends DashBoardListActivity {

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
		setContentView(R.layout.company_lists);
		
		getListView().setDivider(null);
		getListView().setDividerHeight(0);

		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

		JSONObject json = JSONfunctions
				.getJSONfromURL("http://mob.wafanyikazi.org/auto/hire_company.php");

		try {

			JSONArray people = json.getJSONArray("hirecompany");

			for (int i = 0; i < people.length(); i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				e = people.getJSONObject(i);

				map.put("id", String.valueOf(i));
				map.put("name", e.getString("co_name"));
				map.put("location","Location: " + e.getString("co_location"));
				map.put("phone", "Cell: " + e.getString("co_number"));
				map.put("mail","Email: " + e.getString("co_email"));
//				map.put("logitude", e.getString("logitude"));
//				map.put("latitude", dist);

				mylist.add(map);
//				globalLat = e.getString("latitude");
//				globalLog = e.getString("logitude");
			}
		} catch (JSONException e) {
			Log.e("log_tag", "Error kupitisha data " + e.toString());
		}

		tview5 = (TextView) findViewById(R.id.item_subtitle3);
		if(ch == null){
			Log.d("Set", "can");
		}else
			Log.d("Noma", "canot");	
		
//		the_distance = dist;
		
		String[] from = new String[] { "name", "location", "phone", "mail"};
		int[] target = new int[] { R.id.item_title, R.id.item_subtitle1, R.id.item_subtitle2, R.id.item_subtitle3};

		Adapter = new AlternateRowCursorAdapter(this, mylist,
				R.layout.company, from, target);

		// changed
		setListAdapter(Adapter);

		final ListView lv = getListView();
		lv.setTextFilterEnabled(true);
//		lv.setOnItemClickListener(new OnItemClickListener() {
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//
//				startActivity(new Intent(getApplicationContext(),
//						LocationOverlay.class));
//			}
//		});
	}
}
