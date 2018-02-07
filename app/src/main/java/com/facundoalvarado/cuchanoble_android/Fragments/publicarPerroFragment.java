package com.facundoalvarado.cuchanoble_android.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.facundoalvarado.cuchanoble_android.R;


public class publicarPerroFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_publicar_perro, container, false);

        final String urlPublicarPerro = "http://cuchanoble.herokuapp.com/subir/";


//        WebView webView = (WebView) rootView.findViewById(R.id.webPublicar);
//        webView.loadUrl(urlPublicarPerro);

        Button botonVisitar = (Button) rootView.findViewById(R.id.botonVisitar);

        botonVisitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPublicarPerro));
                startActivity(browserIntent);
            }
        });

        return rootView;
    }
}
