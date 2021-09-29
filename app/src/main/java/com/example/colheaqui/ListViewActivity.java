package com.example.colheaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends Activity {

    SQLiteHelper SQLITEHELPER;
    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    SQLiteListAdapter ListAdapter ;

    ArrayList<String> ID_ArrayList = new ArrayList<String>();
    ArrayList<String> NOME_ArrayList = new ArrayList<String>();
    ArrayList<String> DESCRICAO_ArrayList = new ArrayList<String>();
    ArrayList<String> ENTREGA_ArrayList = new ArrayList<String>();
    ArrayList<String> QUANTIDADE_ArrayList = new ArrayList<String>();
    ListView LISTVIEW;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        LISTVIEW = (ListView) findViewById(R.id.listView1);

        SQLITEHELPER = new SQLiteHelper(this);

    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();

        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM Produto", null);

        ID_ArrayList.clear();
        NOME_ArrayList.clear();
        DESCRICAO_ArrayList.clear();
        ENTREGA_ArrayList.clear();
        QUANTIDADE_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do {
                ID_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.PROD_ID)));

                NOME_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.PROD_Name)));

                DESCRICAO_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.PROD_Descricao)));

                ENTREGA_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.PROD_Entrega)));

                QUANTIDADE_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.PROD_Quantidade)));

            } while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteListAdapter(ListViewActivity.this,

                ID_ArrayList,
                NOME_ArrayList,
                DESCRICAO_ArrayList,
                ENTREGA_ArrayList,
                QUANTIDADE_ArrayList
        );

        LISTVIEW.setAdapter(ListAdapter);

        cursor.close();
    }
}
