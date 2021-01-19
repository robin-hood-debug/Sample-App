package com.example.utkarsh.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button getVersion, back;
    TextView head;
    TextView version;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        head = (TextView) findViewById(R.id.head);
        version = (TextView) findViewById(R.id.version);
        back = (Button) findViewById(R.id.back);
    }

    public String getVersion(String uri){

        String version = "";
        PackageManager packageManager = getPackageManager();

        try {
            version = packageManager.getPackageInfo(uri, PackageManager.GET_ACTIVITIES).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            version = "Sorry! Chrome is not installed on your device.";
        }

        return version;
    }

    public void printVersion(View view) {

        getVersion = (Button)findViewById(R.id.getVer);
        getVersion.setVisibility(View.INVISIBLE);
        String chromeVersion = getVersion("com.android.chrome");
        version.setText(chromeVersion);
        head.setVisibility(View.VISIBLE);
        version.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);

    }

    public void setViewVisible(View view) {

        head.setVisibility(View.INVISIBLE);
        version.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        getVersion.setVisibility(View.VISIBLE);

    }
}