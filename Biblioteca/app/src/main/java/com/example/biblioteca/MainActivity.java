package com.example.biblioteca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

        private EditText titulo, autores, qtd_p;
        private Button cad_livro,menu, btnLogin , btnout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

               titulo = findViewById(R.id.titulo);
               autores = findViewById(R.id.autores);
               qtd_p = findViewById(R.id.qtd_p);
               btnLogin = findViewById(R.id.btnLogin);
               btnout = findViewById(R.id.btnOut);

               cad_livro = findViewById(R.id.cad_livro);
               menu = findViewById(R.id.Menu);

               // ir para o menu
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, MenuPrincipal.class);
                startActivity(it);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent t = new Intent(MainActivity.this, Login2.class);
                startActivity(t);
            }
        });


    //cadastrar o livro
          cad_livro.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  HashMap<String, Object> map= new HashMap<>();
                  map.put("titulo",titulo.getText().toString());
                  map.put("autores",autores.getText().toString());
                  map.put("qtd_p",qtd_p.getText().toString());
                  map.put("p_lido","0");
                  map.put("status","0");



                  FirebaseDatabase.getInstance().getReference().child("Biblioteca").push()
                          .setValue(map)
                          .addOnCompleteListener(new OnCompleteListener<Void>() {
                              @Override
                              public void onComplete(@NonNull Task<Void> task) {
                                Log.i("jooj","onComplete");
                              }

                          }).addOnFailureListener(new OnFailureListener() {
                      @Override
                      public void onFailure(@NonNull Exception e) {
                          Log.i("yeyt","onFailure"+e.toString());
                      }
                  });

              }

          });



    }





}