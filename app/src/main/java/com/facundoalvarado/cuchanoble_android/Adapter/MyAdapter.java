package com.facundoalvarado.cuchanoble_android.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facundoalvarado.cuchanoble_android.Model.ListItem;
import com.facundoalvarado.cuchanoble_android.R;

import java.net.ConnectException;
import java.util.List;

/**
 * Created by Facundo on 02/07/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private Context context;
    private List<ListItem> listItems;

    public MyAdapter(Context context, List listitem){
        this.context = context;
        this.listItems = listitem;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        ListItem item = listItems.get(position);
        holder.direccion.setText(item.getDireccion());
        holder.tamano.setText(item.getTamano());
        holder.sexo.setText(item.getSexo());
        holder.edad.setText(item.getEdad());
        holder.estado.setText(item.getEstado());
        holder.contacto.setText(item.getContacto());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView direccion, tamano, sexo, edad, estado, contacto;

        public ViewHolder(View itemView) {
            super(itemView);

            direccion = (TextView) itemView.findViewById(R.id.direccion);
            tamano = (TextView) itemView.findViewById(R.id.tamano);
            sexo = (TextView) itemView.findViewById(R.id.sexo);
            edad = (TextView) itemView.findViewById(R.id.edad);
            estado = (TextView) itemView.findViewById(R.id.estado);
            contacto = (TextView) itemView.findViewById(R.id.contacto);

        }
    }
}
