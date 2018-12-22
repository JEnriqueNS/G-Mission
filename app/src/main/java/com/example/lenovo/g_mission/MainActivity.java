package com.example.lenovo.g_mission;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Dans cette classe on peut voir les differents missions qui ont été ajoutes
 * @author Jesus Enrique Nava Sanchez
 * @version 20/12/2018
 */
public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Classes> list;
    MyAdapter adapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        //Funcionement de Bar-Navigation
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent Main = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(Main);
                    return true;
                case R.id.navigation_search:
                    Intent filtrer = new Intent(MainActivity.this,Filtrer.class);
                    startActivity(filtrer);
                    return true;
                case R.id.navigation_message:
                    mTextMessage.setText(R.string.title_message);
                    return true;
                case R.id.navigation_configuration:
                    mTextMessage.setText(R.string.title_configuration);
                    return true;
            }
            return false;
        }
    };
    //Intent miIntent = new Intent(LoginActivity.this,MainActivity.class);
    //                startActivity(miIntent);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reference = FirebaseDatabase.getInstance().getReference().child("Classes").child("missions");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Classes>();
                for (DataSnapshot dataSnapShot1: dataSnapshot.getChildren())
                {
                    Classes c = dataSnapShot1.getValue(Classes.class);
                    list.add(c);
                }
                adapter = new MyAdapter(MainActivity.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //Changer le nom de l'ecran
        setTitle("Fil d'actualité");

        mTextMessage = (TextView) findViewById(R.id.message);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Buttom floutant instanciacion
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //method Onclick de Buttol Floutant
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent ajou = new Intent(MainActivity.this,Ajouter_Mission.class);
                startActivity(ajou);
            }
        });

    }


}
