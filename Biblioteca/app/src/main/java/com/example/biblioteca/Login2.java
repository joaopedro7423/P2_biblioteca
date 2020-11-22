package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.os.Bundle;

public class Login2 extends AppCompatActivity {
    private EditText editEmail, editSenha;
    private Button btnLogar;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        inicializarComponents();
        eventoClickes();
    }


    private void eventoClickes() {
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();
                login(email,senha);
            }
        });
    }

    private void login(String email, String senha) {
        auth.signInWithEmailAndPassword(email,senha)
                .addOnCompleteListener(Login2.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i = new Intent(Login2.this,MenuPrincipal.class);
                            startActivity(i);
                        }else{
                            alert("e-mail ou senha aerrados");
                        }
                    }
                });
    }

    private void alert(String s) {
        Toast.makeText(Login2.this,s,Toast.LENGTH_SHORT).show();
    }

    private void inicializarComponents() {
        editEmail = (EditText) findViewById(R.id.editEmail);
        editSenha = (EditText) findViewById(R.id.editSenha);
        btnLogar = (Button) findViewById(R.id.btnLogar);

    }

    @Override
    protected void onStart(){
        super.onStart();
        auth= Auth.getFirebaseAuth();
    }
}