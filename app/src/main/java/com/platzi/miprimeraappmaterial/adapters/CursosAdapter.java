package com.platzi.miprimeraappmaterial.adapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.platzi.miprimeraappmaterial.R;
import com.platzi.miprimeraappmaterial.models.Curso;

import java.util.ArrayList;

/**
 * Created by Thespianartist on 09/03/16.
 */
public class CursosAdapter extends RecyclerView.Adapter<CursosAdapter.ViewHolder>{

    private ArrayList<Curso> datos;
    private int vista;

    public CursosAdapter(ArrayList<Curso> cursos, int row){

        this.datos = cursos;
        this.vista = row;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView badge;
        public TextView  titulo;
        public TextView  descripcion;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, titulo.getText(), Snackbar.LENGTH_SHORT)
                            .show();
                }
            });

            badge = (ImageView) itemView.findViewById(R.id.badge);
            titulo = (TextView) itemView.findViewById(R.id.nombre);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion);


        }

    }

    @Override
    public CursosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CursosAdapter.ViewHolder holder, int position) {

        Curso curso = datos.get(position);
        holder.titulo.setText(curso.getTitulo());
        holder.descripcion.setText(curso.getDescripción());

        if(curso.getTipoDeBagde()!= null){

            switch (curso.getTipoDeBagde()){

                case "react":
                    holder.badge.setImageResource(R.mipmap.ic_launcher);
                    break;

                case "android":
                    holder.badge.setImageResource(R.mipmap.ic_launcher);
                    break;

                case "mysql":
                    holder.badge.setImageResource(R.mipmap.ic_launcher);
                    break;

                case "marketing":
                    holder.badge.setImageResource(R.mipmap.ic_launcher);
                    break;

                case "photoshop"
                    holder.badge.setImageResource(R.mipmap.ic_launcher);
                    break;
            }

        }else {
            holder.badge.setImageResource(R.mipmap.ic_launcher);
        }

        holder.itemView.setTag(curso);

    }

    @Override
    public int getItemCount() {
        return this.datos.size();
    }
}
