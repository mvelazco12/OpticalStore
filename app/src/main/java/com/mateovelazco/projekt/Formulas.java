package com.mateovelazco.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Formulas extends AppCompatActivity {
    private List<ListaObjetos> listaObjetosList = new ArrayList<>();
    private ArrayAdapter<ListaObjetos> listaObjetosArrayAdapter;
    private FirebaseDatabase fdab;
    private DatabaseReference dref;
    private ListView lvformulas;

    private Toolbar topAppbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulas);

        lvformulas = findViewById(R.id.lsv);

        // Initialize the ArrayAdapter here
        listaObjetosArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaObjetosList);
        lvformulas.setAdapter(listaObjetosArrayAdapter);
        topAppbar = findViewById(R.id.topAppBar_home);

        topAppbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.add_item_product) {
                    startActivity(new Intent(Formulas.this, Especs.class));
                    return true;
                } else if (item.getItemId() == R.id.item_add_category) {
                    startActivity(new Intent(Formulas.this, menu_principal.class));

                    return true;
                }else if(item.getItemId()==R.id.item_cita){
                    startActivity(new Intent(Formulas.this, citas.class));
                }
                return false;
            }
        });

        fdab = FirebaseDatabase.getInstance();
        dref = fdab.getReference("users");
        fetchdataa();
    }

    private void fetchdataa() {
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaObjetosList.clear(); // Clear the list to avoid duplicates
                for (DataSnapshot objDatashot : snapshot.getChildren()) {
                    ListaObjetos lo = objDatashot.getValue(ListaObjetos.class);
                    if (lo != null) {
                        listaObjetosList.add(lo);
                    }
                }
                // Notify the adapter that the data has changed
                listaObjetosArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle possible errors
            }
        });
    }
}
