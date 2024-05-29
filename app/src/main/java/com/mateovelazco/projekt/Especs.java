

package com.mateovelazco.projekt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Especs extends AppCompatActivity {

    public TextInputLayout ti1;
    public EditText et1;
    public AutoCompleteTextView auto1, autoc2, autoc3, autoc4, autc5, autoc6, autoc7, autoc8;
    public MaterialButton btdat;
    public TextView tv1;
    public Button savebtn;

    ArrayAdapter<Integer> adapterItem8;
    ArrayAdapter<Float> adapterItem7;
    ArrayAdapter<String> adapterItem6;
    ArrayAdapter<String> adapterItem5;
    ArrayAdapter<Float> adapterItem4;
    ArrayAdapter<Integer> adapterItem3;
    ArrayAdapter<Float> adapterItem2;
    ArrayAdapter<Float> adapteritem1;
    ArrayAdapter<String> adapteritem0;
    private FirebaseFirestore mfires;
    private DatabaseReference mdatabase;

    String[] ojoo = {"Ojo derecho", "Ojo izquierdo"};


    Float[] cilindroOjo = {0.00f, -0.25f, -0.50f, -0.75f, -1.00f, -1.25f, -1.50f, -1.75f, -2.00f};

    Float[] esferaOjo = {-6.00f, -5.50f, -5.00f, -4.50f, -4.00f, -3.50f, -3.00f, -2.50f, -2.00f, -1.50f, -1.00f, -0.50f,
            0.00f, 0.50f, 1.00f, 1.50f, 2.00f, 2.50f, 3.00f, 3.50f, 4.00f, 4.50f, 5.00f, 5.50f, 6.00f};

    Integer[] ejeojo = {0, 15, 30, 45, 60, 75, 90, 105, 120, 135, 150, 165, 180};

    String[] agudezaVisual = {"20/20 (1.0)", "20/40 (0.5)", "20/100 (0.2)", "20/200 (0.1)", "20/400 (0.05)"};
    String[] tipolent = {"Monofocales", "Bifocales", "Progresivos", "Asféricos", "Trifocales"};

    Integer[] filtroLenteOjo = {20, 30, 40, 50, 60, 70, 80};

    Float[] adicionLenteOjo = {0.75f, 1.00f, 1.25f, 1.50f, 1.75f, 2.00f, 2.25f, 2.50f, 2.75f, 3.00f};

    Float courseid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especs);

        //mfires = FirebaseFirestore.getInstance();

        mdatabase = FirebaseDatabase.getInstance().getReference();

        auto1 = findViewById(R.id.atc1);
        autoc2 = findViewById(R.id.atc2);
        autoc3 = findViewById(R.id.atc3);
        autoc4 = findViewById(R.id.atc4);
        autc5 = findViewById(R.id.atc5);
        autoc6 = findViewById(R.id.atc6);
        autoc7 = findViewById(R.id.atc0);
        autoc8 = findViewById(R.id.atc8);
        savebtn = findViewById(R.id.savebtn);


        btdat = findViewById(R.id.bottondate);
        tv1 = findViewById(R.id.tvdate);

        adapteritem0 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,ojoo);
        adapteritem1 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, esferaOjo);
        adapterItem2 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, cilindroOjo);
        adapterItem3 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, ejeojo);
        adapterItem4 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, adicionLenteOjo);
        adapterItem5 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, agudezaVisual);
        adapterItem6 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, tipolent);
        adapterItem8 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, filtroLenteOjo);

        auto1.setAdapter(adapteritem1);
        autoc2.setAdapter(adapterItem2);
        autoc3.setAdapter(adapterItem3);
        autoc4.setAdapter(adapterItem4);
        autc5.setAdapter(adapterItem5);
        autoc6.setAdapter(adapterItem6);
        autoc8.setAdapter(adapterItem8);
        autoc7.setAdapter(adapteritem0);

        autoc7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = adapteritem0.getItem(position);
            }
        });

        auto1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Float selectedItem = adapteritem1.getItem(position);
            }
        });

        autoc2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Float selected = adapterItem2.getItem(position);
            }
        });

        autoc3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Integer selected2 = adapterItem3.getItem(position);
            }
        });

        autoc4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Float selected = adapterItem4.getItem(position);
            }
        });

        autc5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = adapterItem5.getItem(position);
            }
        });

        autoc6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = adapterItem6.getItem(position);
            }
        });

        autoc8.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Integer selected = adapterItem8.getItem(position);
            }
        });

        btdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Seleccione la fecha")
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .build();

                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                    @Override
                    public void onPositiveButtonClick(Long selection) {
                        String date = new SimpleDateFormat("MM-dd-yyy", Locale.getDefault()).format(new Date(selection));
                        tv1.setText(MessageFormat.format("{0}", date));

                    }
                });

                materialDatePicker.show(getSupportFragmentManager(), "tag");


            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float cilindroo = Float.valueOf(auto1.getText().toString());
                Float esfera = Float.valueOf(autoc2.getText().toString());
                Float adicion = Float.valueOf(autoc4.getText().toString());
                Integer ejee = Integer.valueOf(autoc3.getText().toString());
                String agudezaa = autc5.getText().toString();
                String tipolentes = autoc6.getText().toString();
                String name = tv1.getText().toString();
                String ojo = autoc7.getText().toString();
                Integer filtro = Integer.valueOf(autoc8.getText().toString());

                Pacientes pacientes = new Pacientes(cilindroo, esfera, adicion, ejee, filtro, agudezaa, tipolentes, name, ojo);

                //ESTA ES LA LÍNEA QUE INSERTA EN LA BASE DE DATOS EN LA TABLA USERS
                mdatabase.child("users").child(name).setValue(pacientes);
                Intent myintent = new Intent(Especs.this, Formulas.class);
                startActivity(myintent);

            }
        });

    }

}
        /*private void insertOftalData(String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("namee", name);
        mfires.collection("formula").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "yeii  bro", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error mi bro", Toast.LENGTH_SHORT).show();
            }
        });*/







