package com.tab;

import java.util.List;


import com.auto.R;
import com.dash.DashBoardMapActivity;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.TextView;

public class RentTab extends DashBoardMapActivity{

	MapView mapView; 
    MapController mc;
    GeoPoint p;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rent_overlay);
 
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.setStreetView(true);
        
        
        mapView.displayZoomControls(true);
 
        mapView.setBuiltInZoomControls(true);
        mc = mapView.getController();
        
        
        mc.setZoom(17); 
        String coordinates[] = {"1.019089", "35.002305"};
        double lat = Double.parseDouble(coordinates[0]);
        double lng = Double.parseDouble(coordinates[1]);
 
        p = new GeoPoint(
            (int) (lat * 1E6), 
            (int) (lng * 1E6));
 
        mc.animateTo(p);
       
      
        
        
      
 
        //---Add a location marker---
        MapOverlay mapOverlay = new MapOverlay();
        List<Overlay> listOfOverlays = mapView.getOverlays();
        listOfOverlays.clear();
        listOfOverlays.add(mapOverlay);        
 
        mapView.invalidate();
    }
    
    
    class MapOverlay extends com.google.android.maps.Overlay
    {
        @Override
        public boolean draw(Canvas canvas, MapView mapView, 
        boolean shadow, long when) 
        {
            super.draw(canvas, mapView, shadow);                   
 
            //---translate the GeoPoint to screen pixels---
            Point screenPts = new Point();
            mapView.getProjection().toPixels(p, screenPts);
 
            //---add the marker---
            Bitmap bmp = BitmapFactory.decodeResource(
                getResources(), R.drawable.p);            
            canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50, null);         
            return true;
        }
    }
 
    @Override
    protected boolean isRouteDisplayed() {
        // TODO Auto-generated method stub
        return false;
    }
}