package com.example.fuelcap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        final EditText mail1 = findViewById(R.id.email1);
        final EditText mail2 = findViewById(R.id.email2);
        final EditText name =  findViewById(R.id.conName);
        final EditText cMsg =  findViewById(R.id.cUsMsg);
        final Button   cBtn =  findViewById(R.id.sndBtn);
    }
}
