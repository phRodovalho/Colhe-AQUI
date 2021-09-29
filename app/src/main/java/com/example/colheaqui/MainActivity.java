package com.example.colheaqui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        /*Criando nova conta e chamando a tela nova_conta*/
        Button btnNovaConta = findViewById(R.id.btnNovaConta);
        btnNovaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, nova_conta.class);
                startActivity(it);
            }
        });

        /*Fazendo login e chamando a tela menu*/
        Button btnLogin = findViewById(R.id.btnEntrar);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itt = new Intent(MainActivity.this, Menu.class);
                startActivity(itt);
            }
        });
    }
}
