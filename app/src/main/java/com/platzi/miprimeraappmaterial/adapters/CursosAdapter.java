package com.platzi.miprimeraappmaterial.adapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.platzi.miprimeraappmaterial.R;
import com.platzi.miprimeraappmaterial.models.Cursos;

import java.util.ArrayList;

/**
 * Created by Thespianartist on 06/03/16.
 */
public class CursosAdapter extends RecyclerView.Adapter<CursosAdapter.ViewHolder> {


    private ArrayList<Cursos> pusheenArrayList;
    private int itemLayout;


    public CursosAdapter(ArrayList<Cursos> data,  int itemLayout){

        this.pusheenArrayList = data;
        this.itemLayout = itemLayout;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public  ImageView badgeImage;
        public  TextView title;
        private TextView description;
        private TextView career;


        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, title.getText() , Snackbar.LENGTH_LONG)
                            .show();
                }
            });

            badgeImage  =   (ImageView) itemView.findViewById(R.id.imageRow);
            title   =    (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);

        }
    }


    @Override
    public CursosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(CursosAdapter.ViewHolder viewHolder, int position) {

        Cursos curso = pusheenArrayList.get(position);

        viewHolder.title.setText(curso.getTitle());
        viewHolder.description.setText(curso.getDescription());

        if (curso.getBadge()!=null) {

            switch (curso.getBadge()) {

                case "react":
                    viewHolder.badgeImage.setImageResource(R.mipmap.reactj);
                    break;

                case "android":
                    viewHolder.badgeImage.setImageResource(R.mipmap.android);
                    break;

                case "mysql":
                    viewHolder.badgeImage.setImageResource(R.mipmap.mysql);
                    break;

                case "marketing":
                    viewHolder.badgeImage.setImageResource(R.mipmap.marketing);
                    break;

                case "photoshop":
                    viewHolder.badgeImage.setImageResource(R.mipmap.photoshop);
                    break;



            }

        }else{

            viewHolder.badgeImage.setImageResource(R.mipmap.reactj);
        }

        viewHolder.itemView.setTag(curso);

    }

    @Override
    public int getItemCount() {
            return this.pusheenArrayList.size();
    }
}
