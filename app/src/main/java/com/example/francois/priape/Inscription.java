package com.example.francois.priape;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Inscription extends AppCompatActivity {
RadioGroup group;
    EditText tva;
    EditText societe;
    EditText password;
    EditText password2;
    EditText email;
    String user_email, user_societe, user_tva,user_pass,user_pass2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        group = (RadioGroup)findViewById(R.id.inscription_group);
        tva = (EditText)findViewById(R.id.inscription_tva);
        societe = (EditText)findViewById(R.id.inscription_societe);
        password = (EditText)findViewById(R.id.inscription_mdp);
        password2 = (EditText)findViewById(R.id.inscription_remdp);
        email = (EditText)findViewById(R.id.inscription_email);
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
            case R.id.inscription_inscrire:
              user_pass = password.getText().toString();
              user_pass2 = password2.getText().toString();
                if (user_pass.equals(user_pass2))
                {
                   user_email = email.getText().toString();
                   user_societe = societe.getText().toString();
                   user_tva = tva.getText().toString();
                    String method = "register";
                    Background background = new Background(this);
                    background.execute(method,user_email,user_societe,user_tva,user_pass);
                    finish();
                }
                else
                {
                    Toast.makeText(this, "Les mots de passent doivent correspondre", Toast.LENGTH_SHORT).show();


                }


                break;

        }
    }


    }

