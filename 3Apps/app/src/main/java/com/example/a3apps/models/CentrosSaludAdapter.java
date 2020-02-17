package com.example.a3apps.models;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a3apps.R;

import java.util.ArrayList;

public class CentrosSaludAdapter extends  RecyclerView.Adapter<CentrosSaludAdapter.CentrosSaludViewHolder>
{
    public ArrayList<CentrosSalud>  listado;
    public CentrosSaludAdapter(ArrayList<CentrosSalud> listaOperadores) {
        this.listado = listaOperadores;
    }
    @NonNull
    @Override
    public CentrosSaludViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.slideshow_row,parent,false);
        return new CentrosSaludViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull CentrosSaludViewHolder holder, int position) {
        holder.bindCentrosSalud(listado.get(position));
    }

    @Override
    public int getItemCount() {
        return listado.size();
    }
    public void adicionarOperador(ArrayList<CentrosSalud> listaOperadores) {
        TextView tvNombre;
        this.listado.addAll(listaOperadores);
        notifyDataSetChanged();
    }
    public class CentrosSaludViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre;

        public CentrosSaludViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = (TextView) itemView.findViewById(R.id.tvoperador);

        }

        public void bindCentrosSalud(CentrosSalud operadores) {
            String nombre = operadores.getIps() + "\n"
                    + operadores.getLocalizacion() + "\n"
                    + operadores.getDireccion() + "\n"
                    + operadores.getTelefono();
            tvNombre.setText(nombre);

        }
    }

}
