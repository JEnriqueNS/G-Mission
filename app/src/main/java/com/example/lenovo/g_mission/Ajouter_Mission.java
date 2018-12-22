package com.example.lenovo.g_mission;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;


/**
 *  C'est Classe ajout des nouvelles missions dans la basse de donnés
 * @author Jesus Enrique Nava Sanchez
 * @version 05/12/2018
 */

public class Ajouter_Mission extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    //Atributs de la classe
        EditText TextNom;
        Spinner type;
        TextView date;
        EditText Description;
        RelativeLayout btnAjouter;

    private DatabaseReference missions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter__mission);
        missions = FirebaseDatabase.getInstance().getReference("Classes");

        TextNom = (EditText) findViewById(R.id.txtNom);
        type = (Spinner) findViewById(R.id.spin_Type);
        Description = (EditText) findViewById(R.id.txtDescription);
        btnAjouter = (RelativeLayout) findViewById(R.id.ButtonAjouter);
        date = (TextView) findViewById(R.id.txt_jour);

        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AjouterMission();
            }
        });

        Button button_date = (Button)findViewById(R.id.bnt_date);
        button_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datepicker = new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }
    /*Method pour ajouter nouvelles missions*/
    public void AjouterMission(){
        String nom = TextNom.getText().toString();
        String typ = type.getSelectedItem().toString();
        String Descripti = Description.getText().toString();
        String jour = date.getText().toString();
        if(!TextUtils.isEmpty(Descripti)){
            String id = missions.push().getKey();
            Classes mission = new Classes(id,nom,typ,jour,Descripti);
            //missions.child(id).setValue(mission);
            missions.child("missions").child(id).setValue(mission);

            Toast.makeText(this,"Mission ajouté",Toast.LENGTH_LONG).show();
            Intent miIntent = new Intent(Ajouter_Mission.this,MainActivity.class);
            startActivity(miIntent);
        }else{
            Toast.makeText(this,"Mission ajouté",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.txt_jour);
        textView.setText(currentDateString);

    }
}
