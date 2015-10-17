package com.example.francois.priape;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Inscription extends AppCompatActivity {
RadioGroup group;
    EditText tva;
    EditText societe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        group = (RadioGroup)findViewById(R.id.inscription_group);
        tva = (EditText)findViewById(R.id.inscription_tva);
        societe = (EditText)findViewById(R.id.inscription_societe);
       /** if(group.getCheckedRadioButtonId() == R.id.insciption_radiojardinier)
        {
            tva.setVisibility(View.VISIBLE);
            societe.setVisibility(View.VISIBLE);
        }
        if(group.getCheckedRadioButtonId() == R.id.inscription_radioclient)
        {
            tva.setVisibility(View.INVISIBLE);
            societe.setVisibility(View.INVISIBLE);
        } **/


    }
    public void onClickRegister(View v)
    {
        switch (v.getId())
        {
            case R.id.insciption_radiojardinier:
                tva.setVisibility(View.VISIBLE);
                societe.setVisibility(View.VISIBLE);
                break;
            case R.id.inscription_radioclient:
                tva.setVisibility(View.INVISIBLE);
                societe.setVisibility(View.INVISIBLE);
                break;

        }
    }


    }

