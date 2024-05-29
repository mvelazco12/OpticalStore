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

import com.google.android.material.appbar.MaterialToolbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class miscitas extends AppCompatActivity {

    private List<Pojodate> pojodatelist = new ArrayList<>();
    private ArrayAdapter<Pojodate> pojodatesArrayAdapter;
    private FirebaseDatabase fdabb;
    private DatabaseReference dreff;
    private ListView lvcitas;

    private MaterialToolbar topAppbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_miscitas);

        lvcitas = findViewById(R.id.lsv2);

        // Initialize the ArrayAdapter here
        pojodatesArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pojodatelist);
        lvcitas.setAdapter(pojodatesArrayAdapter);
        topAppbar = findViewById(R.id.topAppBar_home);

        topAppbar.setOnMenuItemClickListener(new MaterialToolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.add_item_product) {
                    startActivity(new Intent(miscitas.this, Especs.class));
                    return true;
                } else if (item.getItemId() == R.id.item_add_category) {
                    startActivity(new Intent(miscitas.this, menu_principal.class));
                    return true;
                } else if (item.getItemId() == R.id.item_cita) {
                    startActivity(new Intent(miscitas.this, citas.class));
                }
                return false;
            }
        });

        fdabb = FirebaseDatabase.getInstance();
        dreff = fdabb.getReference("citasusuers");
        fetchdataaa();
    }

    private void fetchdataaa() {
        dreff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pojodatelist.clear();
                for (DataSnapshot datesnapshot : snapshot.getChildren()) {
                    if (datesnapshot.hasChild("fecha") && datesnapshot.hasChild("hora")) {
                        Pojodate lol = datesnapshot.getValue(Pojodate.class);
                        if (lol != null) {
                            pojodatelist.add(lol);
                        }
                    }
                }
                pojodatesArrayAdapter.notifyDataSetChanged(); // Notify adapter of data change
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(miscitas.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
