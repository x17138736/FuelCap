package com.example.fuelcap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class AfterCon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_con);

        Button exitBtn = (Button)findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        ActivityCompat.finishAffinity(AfterCon.this);
                    }
                }
        );

        Button secBtn = findViewById(R.id.secBtn);
        secBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
            }
        });
    }
}