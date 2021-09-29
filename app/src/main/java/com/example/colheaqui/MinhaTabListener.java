package com.example.colheaqui;

import android.content.Context;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MinhaTabListener implements androidx.appcompat.app.ActionBar.TabListener{
    private Context context;
    private Fragment frag;

    public MinhaTabListener(Context context, Fragment frag){
        this.context = context;
        this.frag = frag;
    }

    @Override
    public void onTabSelected(androidx.appcompat.app.ActionBar.Tab tab, FragmentTransaction ft){
        //Troca o fragment dinamicamente ao clicar na tab
        ft.replace(R.id.layoutFrag, this.frag, null);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft){

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft){

    }

}
