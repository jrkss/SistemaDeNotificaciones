package com.mendez.windows.Administrativo.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.mendez.windows.Administrativo.ModeloA.ContactsRecibir;
import com.mendez.windows.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterContacsAdmin extends RecyclerView.Adapter<HolderContactsAdmin> {
    private DatabaseReference rerefe;

    private List<ContactsRecibir> listContacts = new ArrayList<>();
    private Context c ;
    public AdapterContacsAdmin (Context c){this.c = c;}
    public void addContact(ContactsRecibir m){
        listContacts.add(m);
        notifyItemInserted(listContacts.size());
    }
    public HolderContactsAdmin onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_contacts_administrativos,parent,false);
        return new HolderContactsAdmin(v);
    }
    public void onBindViewHolder(final HolderContactsAdmin holder, final int position) {
        holder.getTxvcargo().setText(listContacts.get(position).getCargo());
        holder.getTxvcorreo().setText(listContacts.get(position).getCorreo());
        holder.getTxvnombre().setText(listContacts.get(position).getNombre());
        holder.getTxvcampus().setText(listContacts.get(position).getCampus());

    }
    public int getItemCount() {
        return listContacts.size();
    }

}
