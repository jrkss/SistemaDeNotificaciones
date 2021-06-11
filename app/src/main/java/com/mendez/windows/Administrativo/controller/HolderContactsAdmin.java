package com.mendez.windows.Administrativo.controller;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mendez.windows.R;

public class HolderContactsAdmin extends RecyclerView.ViewHolder {
    TextView txvcargo, txvcorreo, txvnombre, txvcampus;
    private CardView cardViewId;
    public HolderContactsAdmin(View itemView) {
        super(itemView);
        txvcargo = (TextView) itemView.findViewById(R.id.idpuestoadmin);
        txvcorreo = (TextView) itemView.findViewById(R.id.idcorreoadmin);
        txvnombre = (TextView) itemView.findViewById(R.id.idnombreadmin);
        txvcampus = (TextView) itemView.findViewById(R.id.idcampusadmin);
        cardViewId = (CardView) itemView.findViewById(R.id.cardviewId);
    }

    public TextView getTxvcargo() {
        return txvcargo;
    }

    public void setTxvcargo(TextView txvcargo) {
        this.txvcargo = txvcargo;
    }

    public TextView getTxvcorreo() {
        return txvcorreo;
    }

    public void setTxvcorreo(TextView txvcorreo) {
        this.txvcorreo = txvcorreo;
    }

    public TextView getTxvnombre() {
        return txvnombre;
    }

    public void setTxvnombre(TextView txvnombre) {
        this.txvnombre = txvnombre;
    }

    public TextView getTxvcampus() {
        return txvcampus;
    }

    public void setTxvcampus(TextView txvcampus) {
        this.txvcampus = txvcampus;
    }

    public CardView getCardViewId() {
        return cardViewId;
    }

    public void setCardViewId(CardView cardViewId) {
        this.cardViewId = cardViewId;
    }
}
