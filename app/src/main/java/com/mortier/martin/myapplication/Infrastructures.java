package com.mortier.martin.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mortier.martin.myapplication.adapter.CustomListAdapterInfrastructures;


public class Infrastructures extends Fragment {

    private ListView listeView;

    private String[] ville = {
            "Turin","Milan"
    };
    private String[] rue = {
            "Corso Gaetano Scirea", "Conte Josino"
    };
    private Integer[] numero = {
            62, 83
    };
    private String[] principale = { //Attention, déclaration en String mais déclarer en number dans la BDD donc peut créer un conflit
            "false", "true"
    };
    private Integer[] nbTerrain = {
            3, 2
    };
    private Integer[] nbVestiaire = {
            10, 4
    };
    private Integer[] nbBallon = {
            130, 260
    };




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_infrastructures, container, false);
        CustomListAdapterInfrastructures adapter=new CustomListAdapterInfrastructures(getActivity(), ville, rue, numero, principale, nbTerrain, nbVestiaire, nbBallon);
        listeView = (ListView) view.findViewById(R.id.listViewInfrastructure);
        listeView.setAdapter(adapter);
        return view;
    };
}

