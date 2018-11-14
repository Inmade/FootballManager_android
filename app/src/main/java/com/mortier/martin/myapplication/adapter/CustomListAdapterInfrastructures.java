package com.mortier.martin.myapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mortier.martin.myapplication.R;

public class CustomListAdapterInfrastructures extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] ville;
    private final String[] rue;
    private final Integer[] numero;
    private final String[] principale; //A modifier en int si conflit
    private final Integer[] nbTerrain;
    private final Integer[] nbVestiaire;
    private final Integer[] nbBallon;
    //private final Integer[] imgid;

    public CustomListAdapterInfrastructures(Activity context,String[] ville, String[] rue, Integer[] numero, String[] principale, Integer[] nbTerrain,Integer[] nbVestiaire, Integer[] nbBallon) {
        super(context, R.layout.infrastructureslist, ville);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.ville=ville;
        this.rue = rue;
        this.numero = numero;
        this.principale = principale;
        this.nbTerrain = nbTerrain;
        this.nbVestiaire = nbVestiaire;
        this.nbBallon = nbBallon;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.infrastructureslist, null,true);

        TextView tvNumMaillot = (TextView) rowView.findViewById(R.id.ville);
        TextView tvNomJoueur = (TextView) rowView.findViewById(R.id.rue);
        TextView tvFirstnamePlayer = (TextView) rowView.findViewById(R.id.numero);
        TextView tvAttackPlayer = (TextView) rowView.findViewById(R.id.principale);
        TextView tvDefensePlayer = (TextView) rowView.findViewById(R.id.nbTerrain);
        TextView tvSalaryPlayer = (TextView) rowView.findViewById(R.id.nbVestiaire);
        TextView tvNbBallon = (TextView) rowView.findViewById(R.id.nbBallon);

        tvNumMaillot.setText(ville[position]);
        tvNomJoueur.setText("Rue:"+rue[position]);
        tvFirstnamePlayer.setText("Numéro: "+numero[position]);
        tvAttackPlayer.setText("Stade principale: "+principale[position]);
        tvDefensePlayer.setText("Nombre de terrains: "+nbTerrain[position]);
        tvSalaryPlayer.setText("Nombre de vestiaires: "+nbVestiaire[position]);
        tvNbBallon.setText("Nombre de ballon: "+nbBallon[position]);
        //imageView.setImageResource(imgid[position]);

        return rowView;
    };
}