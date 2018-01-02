package com.example.deh3215.persmissionex;

import static android.Manifest.permission.*;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by deh3215 on 2017/12/27.
 */

public class MarshMallowPermission {
    public static final int EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE_BY_GALLERY = 0;
    public static final int EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE_BY_CAMERA = 1;
    public static final int EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE_BY_LOAD_PROFILE = 2;
    public static final int CAMERA_PERMISSION_REQUEST_CODE = 3;
    public static final int LOCATION_PERMISSION_REQUEST_CODE = 4;
    public static final int NETWORK_PERMISSION_STATE = 5;
    public static final int WIFI_PERMISSION_STATE = 6;

    Activity activity;
    Context mContext;

    public MarshMallowPermission(Activity activity) {
        this.activity = activity;
        this.mContext = activity;
    }

    public boolean checkExternalStoragePermission(){
        int result = ContextCompat.checkSelfPermission(activity, WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCameraPermission(){
        int result = ContextCompat.checkSelfPermission(activity, CAMERA);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkLocationPermission(){
        int result = ActivityCompat.checkSelfPermission(activity, ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkNetworkPermission(){
        int result = ActivityCompat.checkSelfPermission(activity, ACCESS_NETWORK_STATE);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }
    public boolean checkWifiPermission(){
        int result = ActivityCompat.checkSelfPermission(activity, ACCESS_WIFI_STATE);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }

    public void requestExternalStoragePermission(int requestCode){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, WRITE_EXTERNAL_STORAGE)){
            Toast.makeText(mContext.getApplicationContext(), "External Storage permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity,new String[]{WRITE_EXTERNAL_STORAGE}, requestCode);
        }
    }

    public void requestCameraPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, CAMERA)){
            Toast.makeText(mContext.getApplicationContext(), "Camera permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity,new String[]{CAMERA},CAMERA_PERMISSION_REQUEST_CODE);
        }
    }

    public void requestLocationPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, ACCESS_FINE_LOCATION) && ActivityCompat.shouldShowRequestPermissionRationale(activity, ACCESS_COARSE_LOCATION)){
            Toast.makeText(mContext.getApplicationContext(), "Location permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    public void requestNetworkPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, ACCESS_NETWORK_STATE) ){
            Toast.makeText(mContext.getApplicationContext(), "Network permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity,new String[]{ACCESS_NETWORK_STATE}, NETWORK_PERMISSION_STATE);
        }
    }

    public void requestWifiPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, ACCESS_WIFI_STATE) ){
            Toast.makeText(mContext.getApplicationContext(), "Wifi permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity,new String[]{ACCESS_WIFI_STATE}, WIFI_PERMISSION_STATE);
        }
    }
}
