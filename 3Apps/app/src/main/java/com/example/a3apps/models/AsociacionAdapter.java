package com.example.a3apps.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a3apps.R;

import java.util.ArrayList;

public class AsociacionAdapter extends RecyclerView.Adapter<AsociacionAdapter.AsociacionViewHolder> {

    public ArrayList<Asociacion> listado;
    public AsociacionAdapter(ArrayList<Asociacion> listaOperadores) {
        this.listado = listaOperadores;
    }

    public AsociacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.home_row,parent,false);
        return new AsociacionViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull AsociacionAdapter.AsociacionViewHolder holder, int position) {
        holder.bindAsociacion(listado.get(position));
    }

    @Override
    public int getItemCount() {
        return listado.size();
    }
    public void adicionarAsociacion(ArrayList<Asociacion> listaOperadores) {
        this.listado.addAll(listaOperadores);
        notifyDataSetChanged();
    }
    public class AsociacionViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre;

        public AsociacionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = (TextView) itemView.findViewById(R.id.tvoperador);

        }
        public void bindAsociacion(Asociacion operadores) {
            String nombre = operadores.getRazon_social() + "\n"
                    + operadores.getDir_comercial() + "\n"
                    + operadores.getCiiu_1() + "\n"
                    + operadores.getNom_rep_legal();
            tvNombre.setText(nombre);

        }
    }
}
