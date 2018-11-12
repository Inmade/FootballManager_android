package com.mortier.martin.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Players extends Fragment {

    private ListView listeView;
    private String[] players = new String[]{
            "Luca", "Marc", "Petit pierre", "Han ouais", "Michael"
    };
    public Players() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_players, container, false);
        listeView = (ListView) view.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, players);
        listeView.setAdapter(adapter);
       return view;
    }

}
