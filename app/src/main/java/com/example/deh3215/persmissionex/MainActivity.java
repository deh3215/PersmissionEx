package com.example.deh3215.persmissionex;

import static android.Manifest.permission.*;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.deh3215.persmissionex.MarshMallowPermission;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_STORAGE = 200;
    private static final int REQUEST_NETWORK = 300;
    //private WebView htmlWebView;
//    private MarshMallowPermission marshMallowPermission;
//    int permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //marshMallowPermission = new MarshMallowPermission(MainActivity.this);

        //permission = ContextCompat.checkSelfPermission(MainActivity.this, WRITE_EXTERNAL_STORAGE);
//        if (!marshMallowPermission.checkExternalStoragePermission()) {
//            marshMallowPermission.requestExternalStoragePermission(MarshMallowPermission.EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE_BY_LOAD_PROFILE);
//        }
//        if (!marshMallowPermission.checkCameraPermission()) {
//            marshMallowPermission.requestCameraPermission();
//        }
//        if (!marshMallowPermission.checkLocationPermission()) {
//            marshMallowPermission.requestLocationPermission();
//        }
//        if (!marshMallowPermission.checkNetworkPermission()) {
//            marshMallowPermission.requestNetworkPermission();
//        }
//        if (!marshMallowPermission.checkWifiPermission()) {
//            marshMallowPermission.requestWifiPermission();
//        }


        int permission = ContextCompat.checkSelfPermission(MainActivity.this, WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{WRITE_EXTERNAL_STORAGE, ACCESS_NETWORK_STATE}, REQUEST_STORAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        switch(requestCode)
//        {
//            case MarshMallowPermission.NETWORK_PERMISSION_STATE:
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    //whatever you planned to do
//                }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
//                    marshMallowPermission.requestNetworkPermission();
//                }
//                break;
//
//            case MarshMallowPermission.WIFI_PERMISSION_STATE:
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    //whatever you planned to do
//                }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
//                    marshMallowPermission.requestWifiPermission();
//                }
//                break;
//            case MarshMallowPermission.EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE_BY_LOAD_PROFILE:
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    //whatever you planned to do
//                }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
//                    marshMallowPermission.requestExternalStoragePermission(marshMallowPermission.EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE_BY_LOAD_PROFILE);
//                }
//                break;
//        }
        if (requestCode == REQUEST_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //whatever you planned to do
            }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, WRITE_EXTERNAL_STORAGE)) {
                    //Show an explanation to the user *asynchronously*
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{WRITE_EXTERNAL_STORAGE, ACCESS_NETWORK_STATE}, REQUEST_INTERNET);
                }else{
                    //Never ask again and handle your app without permission.
                }
            }
        }
    }
//    private class CustomWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//            return true;
//        }
//    }
}
