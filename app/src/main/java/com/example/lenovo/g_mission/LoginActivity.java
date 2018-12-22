package com.example.lenovo.g_mission;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author Jesus Enrique Nava Sanchez
 * @version 07/12/2018
 */
public class LoginActivity extends AppCompatActivity {
    private RelativeLayout buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        buttonLogin = (RelativeLayout) findViewById(R.id.ButtonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(miIntent);
            }
        });


    }
}
