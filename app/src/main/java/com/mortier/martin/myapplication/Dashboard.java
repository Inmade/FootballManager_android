package com.mortier.martin.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment {
    private Button btnAjoutJoueurs;
    private TextView textViewMoyenneA;
    private TextView textViewMoyenneD;
    private TextView textViewNbballons;
private double moyenneA;
private double moyenneD;

private double moyenneB;
private Players p;
private Infrastructures inf;
    public Dashboard() {
        // Required empty public constructor

    }

    public void setMoyenneA()
    {
        moyenneA = 0;
        int i;
        for(i = 0; i < p.getAttackPlayers().length; i++)
        {
            moyenneA += p.getAttackPlayers()[i];
        }
        moyenneA/=i;
    }

    public void setMoyenneD()
    {
        moyenneD = 0;
        int i;
        for(i = 0; i < p.getDefensePlayers().length; i++)
        {
            moyenneD += p.getDefensePlayers()[i] ;
        }
        moyenneD/=i;
    }

    public void setMoyenneB(){
        moyenneB = 0;
        int i;
        for(i = 0; i < inf.getNbBallon().length; i++)
        {
            moyenneB += inf.getNbBallon()[i] ;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view =  inflater.inflate(R.layout.fragment_dashboard, container, false);
        p = new Players();
        inf = new Infrastructures();
        setMoyenneA();
        setMoyenneB();
        setMoyenneD();

        textViewMoyenneA = (TextView) view.findViewById(R.id.textview_moyenneA);
        textViewMoyenneA.setText(""+moyenneA+"%");

        textViewMoyenneD = (TextView) view.findViewById(R.id.textview_moyenneD);
        textViewMoyenneD.setText(""+moyenneD+"%");

        textViewNbballons = (TextView) view.findViewById(R.id.textview_nbballons);
        textViewNbballons.setText(""+moyenneB);

        btnAjoutJoueurs = (Button)view.findViewById(R.id.ajout_joeurs);
        btnAjoutJoueurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ajout_players frag = new Ajout_players();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, frag).commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }


}
