package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.example.biblioteca.ModelBiblioteca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {
    private Button voltar;

RecyclerView recview;
myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        voltar = findViewById(R.id.voltar);

        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ModelBiblioteca> options =
                new FirebaseRecyclerOptions.Builder<ModelBiblioteca>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Biblioteca"),ModelBiblioteca.class)
                .build();


        adapter= new myadapter(options);
        recview.setAdapter(adapter);

        voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuPrincipal.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.startListening();
    }



}