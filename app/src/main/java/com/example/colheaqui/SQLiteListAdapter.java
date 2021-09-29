package com.example.colheaqui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class SQLiteListAdapter extends BaseAdapter {
   Context context;
   ArrayList<String> ProdID;
   ArrayList<String> ProdName;
   ArrayList<String> ProdEntrega;
   ArrayList<String> ProdQuantidade;
   ArrayList<String> ProdDescricao;

   public SQLiteListAdapter(
        Context context2,
        ArrayList<String> id,
        ArrayList<String> name,
        ArrayList<String> entrega,
        ArrayList<String> quantidade,
        ArrayList<String> descricao
        )
   {
       this.context = context2;
       this.ProdID = id;
       this.ProdName = name;
       this.ProdEntrega = entrega;
       this.ProdQuantidade = quantidade;
       this.ProdDescricao = descricao;
   }



    @Override
    public int getCount() {
        return ProdID.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {

       Holder holder;
       LayoutInflater layoutInflater;

       if(view == null) {
           layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           view = layoutInflater.inflate(R.layout.listviewdatalayout, null);

           holder = new Holder();

           holder.textid = (TextView) view.findViewById(R.id.textID);
           holder.textname = (TextView) view.findViewById(R.id.textName);
           holder.textdescricao = (TextView) view.findViewById(R.id.textDescricao);
           holder.textentrega = (TextView) view.findViewById(R.id.textEntrega);
           holder.textquantidade = (TextView) view.findViewById(R.id.textQuantidade);

           view.setTag(holder);

       }else{
           holder = (Holder) view.getTag();
       }
        holder.textid.setText(ProdID.get(i));
        holder.textname.setText(ProdName.get(i));
        holder.textdescricao.setText(ProdDescricao.get(i));
        holder.textentrega.setText(ProdEntrega.get(i));
        holder.textquantidade.setText(ProdQuantidade.get(i));

        return view;
    }

    public class Holder {
        TextView textid;
        TextView textname;
        TextView textdescricao;
        TextView textentrega;
        TextView textquantidade;
    }
}
