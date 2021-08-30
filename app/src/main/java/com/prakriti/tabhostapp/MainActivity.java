package com.prakriti.tabhostapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityGroup;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends TabActivity {
// extends from Activity Group -> deprecated
// FIG OUT: how to put action bar above tab layout on activity screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = findViewById(android.R.id.tabhost);

//        tabHost.setup(getLocalActivityManager()); // -> ERROR: tabhost must have tabwidget with id tabs -> fixed in XML android: id list

        // creating new tab
        TabHost.TabSpec spec = tabHost.newTabSpec("ONE");
        spec.setIndicator("Tab One"); // also takes a drawable icon -> getResources.getDrawable(R.drawable._); + empty string for label
        Intent intent1 = new Intent(this, FirstTab.class);
        spec.setContent(intent1);
        // also, can create layouts for each tab inside frame layout and pass the Res id of that layout to setContent method

        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("TWO");
        spec.setIndicator("Tab Two");
        Intent intent2 = new Intent(this, SecondTab.class);
        spec.setContent(intent2);

        tabHost.addTab(spec);
    }
}