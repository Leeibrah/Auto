package com.mobi;

import java.io.InputStream;

import com.auto.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class TakePhoto extends Activity implements OnClickListener{
	Bitmap bmp;
	Button takePic;
	ImageView placeImg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// custom
		
		initialize();
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		bmp = BitmapFactory.decodeStream(is);
	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		takePic = (Button) findViewById(R.id.takePhoto);
		takePic.setOnClickListener(this);
		
		placeImg = (ImageView) findViewById(R.id.returnedPic);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivityForResult(new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE), 0);
	}
}
