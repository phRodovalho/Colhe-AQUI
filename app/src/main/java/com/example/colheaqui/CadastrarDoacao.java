package com.example.colheaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CadastrarDoacao extends AppCompatActivity {

    TextView GetNome, GetDescricao, GetEntrega, GetQuantidade;
    Button Submit, EditData, DisplayData;
    SQLiteDatabase SQLITEDATABASE;
    String Nome, Descricao, Entrega, Quantidade;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_doacao);
        getSupportActionBar().hide();

        GetNome = (TextView)findViewById(R.id.txtNome_prod);

        GetDescricao = (TextView)findViewById(R.id.txtDescricao);

        GetEntrega = (TextView)findViewById(R.id.txtEntrega);

        GetQuantidade = (TextView)findViewById(R.id.txtQuantidade);

        Submit = (Button)findViewById(R.id.btnsalvar);

      //  EditData = (Button)findViewById(R.id.button2);

     //   DisplayData = (Button)findViewById(R.id.btnMostrar);

        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-gen merated method stub

                DBCreate();

                SubmitData2SQLiteDB();

            }
        });
/*
        EditData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(MainActivity.this, EditDataActivity.class);
                startActivity(intent);

            }
        });

        DisplayData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent( CadastrarDoacao.this, ListViewActivity.class);
                startActivity(intent);

            }
        });
*/


    }

    public void DBCreate(){

        SQLITEDATABASE = openOrCreateDatabase("Produto", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS Produto(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR, descricao VARCHAR, entrega VARCHAR, quantidade VARCHAR);");
    }

    public void SubmitData2SQLiteDB(){

        Nome = GetNome.getText().toString();

        Descricao = GetDescricao.getText().toString();

        Entrega = GetEntrega.getText().toString();

        Quantidade = GetQuantidade.getText().toString();

        CheckEditTextIsEmptyOrNot( Nome, Descricao, Entrega, Quantidade);

        if(CheckEditTextEmpty == true)
        {

            SQLiteQuery = "INSERT INTO Produto (name,descricao,entrega, quantidade) VALUES('"+Nome+"', '"+Descricao+"', '"+Entrega+"', '"+Quantidade+"');";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(this,"Data Submit Successfully", Toast.LENGTH_LONG).show();

            ClearEditTextAfterDoneTask();

        }
        else {

            Toast.makeText(this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String Nome,String Descricao, String Entrega, String Quantidade ){

        if(TextUtils.isEmpty(Nome) || TextUtils.isEmpty(Descricao) || TextUtils.isEmpty(Entrega) || TextUtils.isEmpty(Quantidade)){

            CheckEditTextEmpty = false ;

        }
        else {
            CheckEditTextEmpty = true ;
        }
    }

    public void ClearEditTextAfterDoneTask(){

        GetNome.setText("");
        GetDescricao.setText("");
        GetEntrega.setText("");
        GetQuantidade.setText("");
    }
}
