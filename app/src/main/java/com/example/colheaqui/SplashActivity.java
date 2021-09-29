package com.example.colheaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        apresentarTelaSplash();
    }

    private void apresentarTelaSplash(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);

                startActivity(telaPrincipal);

            }
        },SPLASH_TIME_OUT);
    }
}
