package com.example.colheaqui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_frag);

        //personalizar action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(null);
        
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#8CC047")));

        //Tab 1
        ActionBar.Tab tab1 = actionBar.newTab().setText("Doar");
        tab1.setTabListener(new MinhaTabListener(this, new Doar()));
        actionBar.addTab(tab1);

        //Tab 2 -
        ActionBar.Tab tab2 = actionBar.newTab().setText("Receber");
        tab2.setTabListener(new MinhaTabListener(this, new Receber()));
        actionBar.addTab(tab2);
    }
}
