package com.mortier.martin.myapplication;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Players extends Fragment {

    private ListView listeView;

    private Integer[] numMaillot = {
            1,2
    };
    private String[] namePlayers = {
            "Passarello", "Quenon"
    };
    private String[] firstnamePlayers = {
            "Luca", "Marc"
    };
    private Integer[] attackPlayers = {
            20,80
    };
    private Integer[] defensePlayers = {
            5, 100
    };
    private Integer[] salaryPlayers = {
            1, 100
    };




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_players, container, false);
        CustomListAdapter adapter=new CustomListAdapter(getActivity(), numMaillot, namePlayers, firstnamePlayers, attackPlayers, defensePlayers, salaryPlayers);
        listeView = (ListView) view.findViewById(R.id.listViewPlayers);
        listeView.setAdapter(adapter);
       return view;
    };
}
