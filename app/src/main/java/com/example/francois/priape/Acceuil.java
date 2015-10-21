package com.example.francois.priape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Acceuil extends AppCompatActivity {
    EditText ET_EMAIL, ET_PASS;
    String login_email, login_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        ET_EMAIL  = (EditText)findViewById(R.id.login_email);
        ET_PASS = (EditText)findViewById(R.id.login_pass);
        }
    public void onClickHome(View v){
        switch (v.getId()){
            case R.id.inscription:
                //Toast.makeText(this, "coucou", Toast.LENGTH_LONG).show();
                Intent Inscription = new Intent(this,Inscription.class);
                startActivity(Inscription);
                break;
            case R.id.login_connecte:
                login_email = ET_EMAIL.getText().toString();
                login_pass = ET_PASS.getText().toString();
                String method = "Login";
                Background background = new Background(this);
                background.execute(method, login_email,login_pass);




        }


    }


}
