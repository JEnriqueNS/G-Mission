package com.example.lenovo.g_mission;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * c'est classe est utilise pour ajputer les missions dans le RecyclerView
 * @author Jesus Enrique Nava Sanchez
 * @version 20/12/2018
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    //Attributs de la classe
    private OnItemClickListener listener;
   Context context;
   ArrayList<Classes> missions;

    /**
     * constructeur
     * @param context
     * @param missions
     */
    public MyAdapter(Context context, ArrayList<Classes> missions) {
        this.context = context;
        this.missions = missions;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_recycler,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textViewNom.setText("Nom: "+missions.get(i).getNom());
        myViewHolder.textViewDescription.setText("Description: "+missions.get(i).getDescription());
        myViewHolder.textViewJour.setText("Jour: "+missions.get(i).getJour());
        myViewHolder.textViewType.setText("Type: "+missions.get(i).getType());
    }

    @Override
    public int getItemCount() {
        return missions.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewNom;
        TextView textViewDescription;
        TextView textViewJour;
        TextView textViewType;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNom = (TextView) itemView.findViewById(R.id.txtViewNom);
            textViewDescription = (TextView) itemView.findViewById(R.id.txtViewDescrip);
            textViewJour = (TextView) itemView.findViewById(R.id.txtViewJour);
            textViewType = (TextView) itemView.findViewById(R.id.txtViewType);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION && listener != null){



                    }
                }
            });
        }

    }

    public interface OnItemClickListener{
        void OnItemClick(DataSnapshot documentSnapshot, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
