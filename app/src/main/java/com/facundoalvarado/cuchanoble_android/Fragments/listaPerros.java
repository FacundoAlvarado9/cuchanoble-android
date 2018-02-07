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
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.facundoalvarado.cuchanoble_android.Adapter.MyAdapter;
import com.facundoalvarado.cuchanoble_android.Model.ListItem;
import com.facundoalvarado.cuchanoble_android.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class listaPerros extends Fragment {

    private RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_lista_perros, container, false);

//        Variables

//        Seteando cache
        Cache cache = new DiskBasedCache(getActivity().getCacheDir(),1024*1024*2);
        Network network = new BasicNetwork(new HurlStack());
        RequestQueue requestQueue = new RequestQueue(cache, network );

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewID);

        final List<ListItem> listItems;

        String URL = "http://cuchanoble.herokuapp.com/json.json";

//        Propiedades de RV
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        requestQueue.start();

        listItems = new ArrayList<>();

//        Volley Function - Descargando los datos del servidor

        JsonArrayRequest arrayRequest = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i<response.length(); i++) {
                            try {
                                JSONObject perro = response.getJSONObject(i);

                                ListItem item = new ListItem(
                                        perro.getString("direccion"),
                                        perro.getString("tamano"),
                                        perro.getString("sexo"),
                                        perro.getString("edad"),
                                        perro.getString("estado"),
                                        perro.getString("contacto")
                                );

                                listItems.add(item);

//                                Añadiendo los objetos al RecyclerView
                                adapter = new MyAdapter(getActivity(), listItems);
                                recyclerView.setAdapter(adapter);
                                recyclerView.setItemAnimator(new DefaultItemAnimator());


                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(getActivity(), "El error es en try/catch", Toast.LENGTH_LONG).show();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(arrayRequest);





        return rootView;
    }
}
