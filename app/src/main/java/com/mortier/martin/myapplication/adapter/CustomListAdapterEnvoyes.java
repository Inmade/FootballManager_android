package com.mortier.martin.myapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mortier.martin.myapplication.R;

public class CustomListAdapterEnvoyes extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] mail_destinataire;
    private final String[] titre;
    private final String[] corps;

    public CustomListAdapterEnvoyes(Activity context, String[] mail_destinataire, String[] titre, String[] corps) {
        super(context, R.layout.envoyelist, mail_destinataire);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.mail_destinataire = mail_destinataire;
        this.titre = titre;
        this.corps = corps;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.envoyelist, null, true);

        TextView tvMailDestinataire = (TextView) rowView.findViewById(R.id.mail_destinataire);
        TextView tvTitreMail = (TextView) rowView.findViewById(R.id.titre_mail);
        TextView tvCorpsMail = (TextView) rowView.findViewById(R.id.corps_mail);

        tvMailDestinataire.setText(mail_destinataire[position]);
        tvTitreMail.setText(titre[position]);
        tvCorpsMail.setText(corps[position]);

        //imageView.setImageResource(imgid[position]);

        return rowView;
    }

    ;
}