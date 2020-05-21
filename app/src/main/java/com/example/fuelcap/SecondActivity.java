package com.example.fuelcap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

    private Button Maps;
    private Button EVChargePoints;
    private Button Review;
    private Button ContactUs;
    private FirebaseAuth firebaseAuth;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Maps=(Button) findViewById(R.id.btnMaps);
        EVChargePoints=(Button) findViewById(R.id.btnEVChargePoints);
        Review=(Button) findViewById(R.id.btnReview);
        ContactUs=(Button) findViewById(R.id.btnContactUs);
        logout=(Button) findViewById(R.id.btnLogout);


        Maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMaps();
            }
        });
        EVChargePoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEVChargePoints();
            }
        });
        Review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReview();
            }
        });
        ContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContactUs();
            }
        });

        firebaseAuth=FirebaseAuth.getInstance();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });

    }
    private void openMaps () {
        Intent intent=new Intent(SecondActivity.this, Maps.class);
        startActivity(intent);

    }

    private void openEVChargePoints () {
        Intent intent=new Intent(SecondActivity.this, EVChargePoints.class);
        startActivity(intent);

    }

    private void openReview () {
        Intent intent=new Intent(SecondActivity.this, Review.class);
        startActivity(intent);

    }

    private void openContactUs () {
        Intent intent=new Intent(SecondActivity.this, ContactUs.class);
        startActivity(intent);

    }
    private void Logout () {
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SecondActivity.this, MainActivity.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logoutMenu:{
                Logout();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
