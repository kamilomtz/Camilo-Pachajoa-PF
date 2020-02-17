package com.example.a3apps.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a3apps.R;

import java.util.ArrayList;

public class OperadorAdapter extends RecyclerView.Adapter<OperadorAdapter.OperadorViewHolder>{

    public ArrayList<Operadores>  listado;

    public OperadorAdapter(ArrayList<Operadores> listaOperadores) {
        this.listado = listaOperadores;
    }

    @Override
    public OperadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_row,parent,false);
        return new OperadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OperadorViewHolder holder, int position) {
        holder.bindOperador(listado.get(position));
    }

    @Override
    public int getItemCount() {
        return listado.size();
    }

    public void adicionarOperador(ArrayList<Operadores> listaOperadores) {
        this.listado.addAll(listaOperadores);
        notifyDataSetChanged();
    }

    public class OperadorViewHolder  extends RecyclerView.ViewHolder{
        TextView tvNombre;

        public OperadorViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre =(TextView) itemView.findViewById(R.id.tvoperador);

        }
        public void bindOperador(Operadores operadores){
            String nombre = operadores.getNombre_del_operador()+"\n"
                    +operadores.getPrestador_del_servicio_turistico()+"\n"
                    +operadores.getDirecci_n()+"\n"
                    +operadores.getServicio_que_presta()+"\n"+
                    operadores.getCorreo_electronico();
            tvNombre.setText(nombre);


        }
    }
}