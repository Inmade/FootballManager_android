package com.mortier.martin.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Ajout_players extends Fragment {

    private EditText editNom;
    private Button btnAjouter;
    private Players p;
    public Ajout_players(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_ajout_joueurs, container, false);
        p = new Players();

        editNom = (EditText) view.findViewById(R.id.edit_nomjoueurs);
        btnAjouter = (Button) view.findViewById(R.id.btn_ajouter);
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });




        // Inflate the layout for this fragment
        return view;
    }

}