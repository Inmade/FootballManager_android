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
public class Courriel extends Fragment {
    private Button btn_sent;
    private ListView listeView;

    private String[] mail_destinateur = {
            "youtube@youtube.com","youtube@youtube.com"
    };
    private String[] titre = {
            "Nouvelle inscription", "Nouvelle inscription"
    };
    private String[] corps = {
            "Vous êtes maintenant inscrit sur youtube", "Vous êtes maintenant inscrit sur youtube"
    };

    public Courriel() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courriel, container, false);
        CustomListAdapterReception adapter=new CustomListAdapterReception(getActivity(), mail_destinateur, titre, corps);
        listeView = (ListView) view.findViewById(R.id.listViewReception);
        listeView.setAdapter(adapter);

       btn_sent = (Button) view.findViewById(R.id.btn_sent);
        btn_sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Envoye envoye = new Envoye();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, envoye).commit();
            }
        });
        return view;
    }


}
