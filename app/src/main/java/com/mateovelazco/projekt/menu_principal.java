package com.mateovelazco.projekt;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class menu_principal extends AppCompatActivity {


    private ImageButton imageButton2, im3for, im4;
    private ImageButton imageButtoninfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Encontrar el ImageView por su ID
        imageButton2 = findViewById(R.id.imageButton2);

        im3for=findViewById(R.id.imageButton3);
        im4 = findViewById(R.id.imageButton1);
        // Configurar el OnClickListener
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para iniciar la FormProductActivity
                Intent intent = new Intent(menu_principal.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Encontrar el ImageView por su ID
        imageButtoninfo = findViewById(R.id.imageButtoninfo);
        // Configurar el OnClickListener
        imageButtoninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para iniciar la FormProductActivity
                Intent intent = new Intent(menu_principal.this, informacion.class);
                startActivity(intent);
            }
        });

        im3for.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_principal.this, Formulas.class);
                startActivity(intent);
            }
        });

        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_principal.this, miscitas.class);
                startActivity(intent);
            }
        });


    }
}