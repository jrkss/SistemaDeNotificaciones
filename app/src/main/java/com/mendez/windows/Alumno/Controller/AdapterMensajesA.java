package com.mendez.windows.Alumno.Controller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mendez.windows.Administrativo.ModeloA.MensajeRecibir;
import com.mendez.windows.Administrativo.controller.HolderMensaje;
import com.mendez.windows.Alumno.ModeloA.MensajeRecibirA;
import com.mendez.windows.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterMensajesA extends RecyclerView.Adapter<HolderMensajeA> {

    private List<MensajeRecibirA> listMensaje = new ArrayList<>();
    private Context c;

    public AdapterMensajesA(Context c) {
        this.c = c;
    }

    public void addMensaje(MensajeRecibirA mm){
        listMensaje.add(mm);
        notifyItemInserted(listMensaje.size());
    }

    @Override
    public HolderMensajeA onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.itszmensaje,parent,false);
        return new HolderMensajeA(v);
    }

    @Override
    public void onBindViewHolder(final HolderMensajeA holder, final int position) {
        holder.getNombre().setText(listMensaje.get(position).getNombre());
        holder.getMensaje().setText(listMensaje.get(position).getMensaje());
        if (listMensaje.get(position).getType_mensaje().equals("3")){
            holder.getDocMensaje().setVisibility(View.VISIBLE);
            holder.getMensaje().setVisibility(View.GONE);
            holder.getFotoMensaje().setVisibility(View.GONE);
            holder.getDocMensaje().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(listMensaje.get(position).getUrlDoc()));
                    holder.getDocMensaje().getContext().startActivity(intent);

                }
            });

        }
        if(listMensaje.get(position).getType_mensaje().equals("2")){
            holder.getFotoMensaje().setVisibility(View.VISIBLE);
            holder.getMensaje().setVisibility(View.GONE);
            holder.getDocMensaje().setVisibility(View.GONE);
            Glide.with(c).load(listMensaje.get(position).getUrlFoto()).into(holder.getFotoMensaje());
        }else if(listMensaje.get(position).getType_mensaje().equals("1")){
            holder.getFotoMensaje().setVisibility(View.GONE);
            holder.getDocMensaje().setVisibility(View.GONE);
            holder.getDocMensaje().setClickable(true);
            holder.getMensaje().setVisibility(View.VISIBLE);
        }

        Long codigoHora = listMensaje.get(position).getHora();
        Date d = new Date(codigoHora);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm - dd/MM/yyyy");//a pm o am
        holder.getHora().setText(sdf.format(d));
    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }
}
