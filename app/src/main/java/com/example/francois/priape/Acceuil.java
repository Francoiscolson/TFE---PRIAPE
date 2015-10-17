package com.example.francois.priape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Acceuil extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        }
    public void onClickHome(View v){
        switch (v.getId()){
            case R.id.inscription:
                //Toast.makeText(this, "coucou", Toast.LENGTH_LONG).show();
                Intent Inscription = new Intent(this,Inscription.class);
                startActivity(Inscription);
                break;


        }


    }


}
