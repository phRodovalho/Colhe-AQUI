package com.example.colheaqui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Receber extends Fragment{
    Button abobora;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstaceState){
        View view = inflater.inflate(R.layout.fragment_receber, container, false);


        abobora = view.findViewById(R.id.abobora);

        abobora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent( getActivity(), Combinar_Entrega.class);
                startActivity(it);
            }
        });

        return view;
    }


}
