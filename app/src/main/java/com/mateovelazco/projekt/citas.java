package com.mateovelazco.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class citas extends AppCompatActivity {

    private TextView tv11,tv22;
    private MaterialButton btntimedate, btunhour;

    private Button guardarbtn;

    private FirebaseFirestore mfiress;
    private DatabaseReference mdatabases;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        tv11=findViewById(R.id.tvdatecita);
        tv22=findViewById(R.id.tvdatehour);
        btntimedate=findViewById(R.id.bottondate);
        btunhour=findViewById(R.id.bottontime);
        guardarbtn=findViewById(R.id.btnconfirm);

        mdatabases = FirebaseDatabase.getInstance().getReference();


        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        btntimedate.setOnClickListener(new View.OnClickListener() {
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
                        tv11.setText(MessageFormat.format("{0}", date));

                    }
                });

                materialDatePicker.show(getSupportFragmentManager(), "tag");


            }
        });

        btunhour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(citas.this,
                        (view, selectedHour, selectedMinute) -> {
                            // Update the TextView with the selected time
                            String selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
                            tv22.setText(selectedTime);
                        }, hour, minute, true);
                timePickerDialog.show();

            }



        });

        guardarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fechaa=tv11.getText().toString();
                String horaa =tv22.getText().toString();

                Pojodate pojodate = new Pojodate(fechaa, horaa);

                mdatabases.child("citasusuers").child(fechaa).setValue(pojodate);
                Intent myintent = new Intent(citas.this, menu_principal.class);
                startActivity(myintent);




            }
        });
    }

}