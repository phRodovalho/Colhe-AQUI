package com.example.colheaqui;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="Produto";

    public static final String PROD_ID="id";

    public static final String TABLE_NAME="Produto";

    public static final String PROD_Name="name";

    public static final String PROD_Descricao="descricao";

    public static final String PROD_Entrega="entrega";

    public static final String PROD_Quantidade="quantidade";


    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }



    @Override
    public void onCreate(SQLiteDatabase database) {
        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+PROD_ID+" INTEGER PRIMARY KEY, "+PROD_Name+" VARCHAR, "+PROD_Descricao+" VARCHAR, "+PROD_Entrega+" VARCHAR,"+PROD_Quantidade+" VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}
