package com.example.colheaqui;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Doar extends Fragment {
    View view;
    Button btnDoar, btnMostrar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstaceState){
        view = inflater.inflate(R.layout.fragment_doar, container, false);

        btnDoar =  view.findViewById(R.id.btndoar);

        btnDoar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent( getActivity(), CadastrarDoacao.class);
                startActivity(it);
            }
        });


        btnMostrar =  view.findViewById(R.id.btnMostrar);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent( getActivity(), ListViewActivity.class);
                startActivity(it);
            }
        });


        return view;
    }

}
