package com.facundoalvarado.cuchanoble_android.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facundoalvarado.cuchanoble_android.Adapter.MyAdapter;
import com.facundoalvarado.cuchanoble_android.Model.ListItem;
import com.facundoalvarado.cuchanoble_android.R;

import java.util.ArrayList;
import java.util.List;


public class listaPerros extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_lista_perros, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewID);
        RecyclerView.Adapter adapter;
        List<ListItem> listItems;

//        Propiedades de RV
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItems = new ArrayList<>();

        for (int i=0;i<15;i++){
            ListItem item = new ListItem(
                    "direccion" + (i+1),
                    "tamano" + (i+1),
                    "sexo" + (i+1),
                    "edad" + (i+1),
                    "estado" + (i+1),
                    "contacto" + (i*100)
            );
            listItems.add(item);
        }

        adapter = new MyAdapter(getActivity(), listItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        return rootView;
    }
}
