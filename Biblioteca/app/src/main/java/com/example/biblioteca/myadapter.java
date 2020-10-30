package com.example.biblioteca;

import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<ModelBiblioteca,myadapter.myviewholder> {
    public myadapter(@NonNull FirebaseRecyclerOptions<ModelBiblioteca> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull ModelBiblioteca model) {
        holder.Titulo.setText(model.getTitulo());
        holder.Autores.setText(model.getAutores());
        holder.Status.setText(model.getStatus());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
            TextView Titulo,Autores,Status;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            Titulo=(TextView)itemView.findViewById(R.id.Titulo);
            Autores=(TextView)itemView.findViewById(R.id.Autores);
            Status=(TextView)itemView.findViewById(R.id.Status);

        }
    }
}
