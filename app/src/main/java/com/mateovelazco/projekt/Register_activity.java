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

public class Register_activity extends AppCompatActivity {
    public EditText etcorreo2, etcontrasena2;
    public Button btnregist,backbtn;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etcorreo2 = findViewById(R.id.correoregister);
        etcontrasena2 = findViewById(R.id.contrasenaregister);
        btnregist = findViewById(R.id.registrarbttn);
        backbtn = findViewById(R.id.backbutn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Register_activity.this, Login_activity.class);
                startActivity(myintent);
            }
        });

        btnregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_activity.this, Login_activity.class);
                startActivity(intent);
                finish();
            }
        });

        btnregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correoregistro, contrasenaregistro;
                correoregistro  =String.valueOf(etcorreo2.getText());
                contrasenaregistro  =String.valueOf(etcontrasena2.getText());


                if(TextUtils.isEmpty(correoregistro)){
                    Toast.makeText(Register_activity.this, "Ingrese su correo", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(contrasenaregistro)){
                    Toast.makeText(Register_activity.this, "Ingrese su contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(correoregistro,contrasenaregistro)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Register_activity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Register_activity.this, menu_principal.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(Register_activity.this, "Falló el registro", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }
}
