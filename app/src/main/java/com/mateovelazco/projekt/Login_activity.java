package com.mateovelazco.projekt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_activity extends AppCompatActivity {

    public EditText etcorreo, etcontrasena;
    public Button btnlgn, btnRegister;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etcorreo = findViewById(R.id.correologin);
        etcontrasena = findViewById(R.id.contrasenalogin);
        btnlgn = findViewById(R.id.loginbttn);
        btnRegister = findViewById(R.id.trasnbtn);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_activity.this, Register_activity.class);
                startActivity(intent);
            }
        });


        btnlgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correologin, contrasenalogin;
                correologin  =String.valueOf(etcorreo.getText());
                contrasenalogin  =String.valueOf(etcontrasena.getText());


                if(TextUtils.isEmpty(correologin)){
                    Toast.makeText(Login_activity.this, "Ingrese su correo", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(contrasenalogin)){
                    Toast.makeText(Login_activity.this, "Ingrese su contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(correologin, contrasenalogin)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Login_activity.this, "Usted ha iniciado sesión correctamente", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login_activity.this, menu_principal.class);
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(Login_activity.this, "Falló el registro", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
    
}