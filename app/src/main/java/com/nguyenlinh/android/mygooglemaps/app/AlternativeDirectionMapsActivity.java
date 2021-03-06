package com.nguyenlinh.android.mygooglemaps.app;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.GoogleDirection;
import com.akexorcist.googledirection.constant.Language;
import com.akexorcist.googledirection.constant.TransportMode;
import com.akexorcist.googledirection.constant.Unit;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.model.Route;
import com.akexorcist.googledirection.util.DirectionConverter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nguyenlinh.android.mygooglemaps.database.SQLDatasource;
import com.nguyenlinh.android.mygooglemaps.model.Clothes;
import com.nguyenlinh.android.mygooglemaps.model.Coffee;
import com.nguyenlinh.android.mygooglemaps.model.GasStation;
import com.nguyenlinh.android.mygooglemaps.model.Hotel;
import com.nguyenlinh.android.mygooglemaps.model.Market;
import com.nguyenlinh.android.mygooglemaps.model.Restaurant;
import com.nguyenlinh.android.mygooglemaps.model.SmartPhone;

import java.util.ArrayList;

public class AlternativeDirectionMapsActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener,
        DirectionCallback {

    private Button btnRequestDirection;
    private GoogleMap mMap;
    private String serverKey = "AIzaSyBDZ-Cd6K9Uh1OHJbSC30IpyQ35opDCTA4";
    private LatLng uerLocation;
    private LatLng uerDestination;
    private SQLDatasource db = new SQLDatasource();

    private LatLng camera = new LatLng(11.528907, 106.894499);
    private LatLng origin = new LatLng(11.528907, 106.894499);
    private LatLng destination = new LatLng(10.980834, 106.674640);
    private String[] colors = {"#7fff7272", "#7f31c7c5", "#7fff8a00"};


    private void layViTriHienTai() {
        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria ciCriteria = new Criteria();
        String provider = manager.getBestProvider(ciCriteria, false);
        if (ActivityCompat.checkSelfPermission(AlternativeDirectionMapsActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(AlternativeDirectionMapsActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = manager.getLastKnownLocation(provider);
        uerLocation = new LatLng(location.getLatitude(), location.getLongitude());
    }

    private void layDiemCuoi(){
        Intent intent = getIntent();
        int ma = intent.getIntExtra("MA",0);
        int code = intent.getIntExtra("CODE",0);
        if(code == 1){
            Restaurant restaurant = db.showAllRetaurant_Ma(ma).get(0);
            uerDestination = new LatLng(restaurant.getVido(),restaurant.getKinhdo());
        } else if(code == 2){
            Hotel hotel = db.showAllHotel_Ma(ma).get(0);
            uerDestination = new LatLng(hotel.getVido(),hotel.getKinhdo());
        }else if (code == 3){
            Market market = db.showAllMarket_Ma(ma).get(0);
            uerDestination = new LatLng(market.getVido(),market.getKinhdo());
        } else if (code == 4){
            SmartPhone smartPhone = db.showAllPhone_Ma(ma).get(0);
            uerDestination = new LatLng(smartPhone.getVido(),smartPhone.getKinhdo());
        } else if (code == 5){
            Clothes clothes = db.showAllClothes_Ma(ma).get(0);
            uerDestination = new LatLng(clothes.getVido(),clothes.getKinhdo());
        }else if (code == 6){
            Coffee coffee = db.showAllCoffee_Ma(ma).get(0);
            uerDestination = new LatLng(coffee.getVido(),coffee.getKinhdo());
        }else if (code == 7){
            GasStation gasStation = db.showAllGas_Ma(ma).get(0);
            uerDestination = new LatLng(gasStation.getVido(),gasStation.getKinhdo());
        } else {
            uerDestination = new LatLng(10.980834, 106.674640);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternative_direction_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);


        mapFragment.getMapAsync(this);

        btnRequestDirection = (Button) findViewById(R.id.btn_request_direction);
        btnRequestDirection.setOnClickListener(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        layViTriHienTai();
        layDiemCuoi();
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
                    @Override
                    public boolean onMyLocationButtonClick() {
                        layViTriHienTai();
                        mMap.clear();
                        Toast.makeText(
                                AlternativeDirectionMapsActivity.this,
                                "You are here!",
                                Toast.LENGTH_SHORT).show();
                        Marker marker = mMap.addMarker(new MarkerOptions()
                                .position(uerLocation)
                                .title("My Home")
                                .snippet("Population: 776733"));
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(uerLocation, 15));
                        return true;
                    }
                });

            }
        });
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(uerLocation, 15));

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_request_direction) {
            requestDirection();
        }
    }

    private void requestDirection() {
        layViTriHienTai();
        //layDiemCuoi();
        Snackbar.make(btnRequestDirection, "Direction Requesting...", Snackbar.LENGTH_LONG).show();
        GoogleDirection.withServerKey(serverKey)
                .from(uerLocation)
                .to(uerDestination)
                .transportMode(TransportMode.DRIVING)
                .language(Language.VIETNAMESE)
                .alternativeRoute(true)
                .unit(Unit.METRIC)
                .execute(AlternativeDirectionMapsActivity.this);
    }

    @Override
    public void onDirectionSuccess(Direction direction, String rawBody) {
        Snackbar.make(btnRequestDirection, "Success with status : " + direction.getStatus(), Snackbar.LENGTH_SHORT).show();
        if (direction.isOK()) {
            mMap.addMarker(new MarkerOptions().position(uerLocation));
            mMap.addMarker(new MarkerOptions().position(uerDestination));

            for (int i = 0; i < direction.getRouteList().size(); i++) {
                Route route = direction.getRouteList().get(i);
                String color = colors[i % colors.length];
                ArrayList<LatLng> directionPositionList = route.getLegList().get(0).getDirectionPoint();
                mMap.addPolyline(DirectionConverter.createPolyline(this, directionPositionList, 5, Color.parseColor(color)));
            }

            btnRequestDirection.setVisibility(View.GONE);
        }

        if (mMap != null) {
            btnRequestDirection.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDirectionFailure(Throwable t) {
        Snackbar.make(btnRequestDirection, t.getMessage(), Snackbar.LENGTH_SHORT).show();
    }
}
