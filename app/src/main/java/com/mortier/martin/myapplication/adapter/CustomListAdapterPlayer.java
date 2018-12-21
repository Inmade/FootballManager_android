package com.mortier.martin.myapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mortier.martin.myapplication.R;

import java.util.ArrayList;

public class CustomListAdapterPlayer extends ArrayAdapter<Integer> {

    private final Activity context;
    private final Integer[] numMaillot;
    private final String[] namePlayer;
    private final String[] firstnamePlayer;
    private final Integer[] attackPlayer;
    private final Integer[] defensePlayer;
    private final Integer[] salaryPlayer;
    //private final Integer[] imgid;

    public CustomListAdapterPlayer(Activity context, Integer[] numMaillot, String[] namePlayer, String[] firstnamePlayer, Integer[] attackPlayer, Integer[] defensePlayer, Integer[] salaryPlayer) {
        super(context, R.layout.playerslist, numMaillot);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.numMaillot=numMaillot;
        this.namePlayer = namePlayer;
        this.firstnamePlayer = firstnamePlayer;
        this.attackPlayer = attackPlayer;
        this.defensePlayer = defensePlayer;
        this.salaryPlayer = salaryPlayer;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.playerslist, null,true);

        TextView tvNumMaillot = (TextView) rowView.findViewById(R.id.numMaillot);
        TextView tvNomJoueur = (TextView) rowView.findViewById(R.id.namePlayer);
        TextView tvFirstnamePlayer = (TextView) rowView.findViewById(R.id.firstnamePlayer);
        TextView tvAttackPlayer = (TextView) rowView.findViewById(R.id.attackPlayer);
        TextView tvDefensePlayer = (TextView) rowView.findViewById(R.id.defensePlayer);
        TextView tvSalaryPlayer = (TextView) rowView.findViewById(R.id.salaryPlayer);

        tvNumMaillot.setText(""+numMaillot[position]);
        tvNomJoueur.setText(namePlayer[position]);
        tvFirstnamePlayer.setText(firstnamePlayer[position]);
        tvAttackPlayer.setText("Attaque: "+attackPlayer[position]);
        tvDefensePlayer.setText("Défense: "+defensePlayer[position]);
        tvSalaryPlayer.setText("Salaire: "+salaryPlayer[position]+"€");
        //imageView.setImageResource(imgid[position]);

        return rowView;
    };
}