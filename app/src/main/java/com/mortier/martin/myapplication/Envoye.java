package com.mortier.martin.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.mortier.martin.myapplication.adapter.CustomListAdapterReception;


/**
 * A simple {@link Fragment} subclass.
 */
public class Envoye extends Fragment {
    private Button btn_create,btn_sent, btn_reception;
    private ListView listeView;

    private String[] mail_destinateur = {
            "test@test.com","test@test.com"
    };
    private String[] titre = {
            "On veut NEYMAR", "On veut NEYMAR"
    };
    private String[] corps = {
            "Donne moi NEYMAR", "Donne moi NEYMAR"
    };

    public Envoye() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_envoye, container, false);
        CustomListAdapterReception adapter=new CustomListAdapterReception(getActivity(), mail_destinateur, titre, corps);
        listeView = (ListView) view.findViewById(R.id.listViewEnvoyes);
        listeView.setAdapter(adapter);
        btn_create = (Button) view.findViewById(R.id.btn_create);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Create_courriel create_courriel = new Create_courriel();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, create_courriel).commit();
            }
        });

        btn_sent = (Button) view.findViewById(R.id.btn_sent);
        btn_sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Envoye envoye = new Envoye();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, envoye).commit();
            }
        });

        btn_reception = (Button) view.findViewById(R.id.btn_reception);
        btn_reception.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Courriel courriel = new Courriel();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, courriel).commit();
            }
        });

        return view;
    }

}
