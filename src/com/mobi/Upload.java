package com.mobi;

import java.io.*;
import java.util.ArrayList;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.auto.AutoMain;
import com.auto.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Upload extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	Spinner location_spin;
	EditText priceTxt, disTxt, carnameTxt;
	Button submit, takePic;
	ProgressDialog dialog;
	ImageView imageHolder;
	Bitmap bitmap;
	
	static final String[] LOCATION = new String[] { "Any Location", "Nairobi",
			"Kisumu", "Nakuru", "Mombasa", "Naivasha", "Rest of Kenya" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload);

		carnameTxt = (EditText) findViewById(R.id.name_text);
		priceTxt = (EditText) findViewById(R.id.price_text);
		disTxt = (EditText) findViewById(R.id.distance_text);
		takePic = (Button) findViewById(R.id.takePhoto);
		location_spin = (Spinner) findViewById(R.id.location_spinner);
		ArrayAdapter<String> loc_adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, LOCATION);
		location_spin.setAdapter(loc_adapter);

		imageHolder = (ImageView) findViewById(R.id.returnedPic);
		submit = (Button) findViewById(R.id.submit_btn);
		submit.setOnClickListener(this);

	}
	public void insert(){  
        String input_url= "http://mob.wafanyikazi.org/auto/insert.php"; //URL website anda dengan file insert.php yang telah dibuat  
       
          HttpClient httpClient = new DefaultHttpClient();  
          HttpPost httpPost = new HttpPost(input_url);  
          ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();  
          param.add(new BasicNameValuePair("carname", carnameTxt.getText().toString()));  
          param.add(new BasicNameValuePair("price", priceTxt.getText().toString()));
          param.add(new BasicNameValuePair("kilometer", disTxt.getText().toString()));  
          param.add(new BasicNameValuePair("location", location_spin.getSelectedItem().toString()));
          try {  
               httpPost.setEntity(new UrlEncodedFormEntity(param));  
               HttpResponse httpRespose = httpClient.execute(httpPost);  
              HttpEntity httpEntity = httpRespose.getEntity();  
              InputStream in = httpEntity.getContent();  
              BufferedReader read = new BufferedReader(new InputStreamReader(in));  
             
              String isi= "";  
              String baris= "";  
             
              while((baris = read.readLine())!=null){  
                 isi+= baris;  
              }  
                
              //Jika isi tidak sama dengan "null " maka akan tampil Toast "Berhasil" sebaliknya akan tampil "Gagal"  
              if(carnameTxt.getText().toString().equals("")){                    
           	   Toast.makeText(getApplicationContext(), "Please fill in all details", Toast.LENGTH_LONG).show();  
              }else{  
//           	   dialog = ProgressDialog.show(getApplicationContext(), "Uploading",
//     						"Please wait...", true);
                 Toast.makeText(getApplicationContext(), "Data was inserted to Database", Toast.LENGTH_LONG).show();  
                 carnameTxt.setText("");
                 priceTxt.setText("");
                 disTxt.setText("");
                 
              }  
             
        } catch (ClientProtocolException e) {  
           // TODO Auto-generated catch block  
           e.printStackTrace();  
        } catch (IOException e) {  
           // TODO Auto-generated catch block  
           e.printStackTrace();  
        } 
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		int pressed = v.getId();
		
		switch(pressed){
		case R.id.submit_btn:
			insert();
			break;
		case R.id.takePhoto:
			startActivityForResult(new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE), 0);
			break;
		case R.id.home_btn:
			startActivity(new Intent(getApplicationContext(), AutoMain.class));
			break;
		case R.id.search_btn:
			startActivity(new Intent(getApplicationContext(), Search.class));
			break;

		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		// custom
		if(resultCode == RESULT_OK){
			Bundle extras = data.getExtras();
			bitmap = (Bitmap) extras.get("data");
			imageHolder.setImageBitmap(bitmap);
		}
	}
}