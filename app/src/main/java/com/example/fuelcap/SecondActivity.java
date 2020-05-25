package com.example.fuelcap;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import static com.example.fuelcap.R.id.btnContactUs;
import static com.example.fuelcap.R.id.btnEVChargePoints;
import static com.example.fuelcap.R.id.btnMaps;
import static com.example.fuelcap.R.id.btnReview;

public class SecondActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button maps=findViewById(btnMaps);
        Button EVChargePoints=findViewById(btnEVChargePoints);
        Button review=findViewById(btnReview);
        Button contactUs=findViewById(btnContactUs);
        Button logout=findViewById(R.id.btnLogout);


        maps.setOnClickListener(new View.OnClickListener() {
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
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReview();
            }
        });
        contactUs.setOnClickListener(new View.OnClickListener() {
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
    // I have changed the .class where it's to be opened to SecondActivity.class to overcome an error.
    // can be changed to the maps class when we sort it out.
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
        if (item.getItemId() != R.id.logoutMenu) {
            return super.onOptionsItemSelected(item);
        } else {
            Logout();
            return super.onOptionsItemSelected(item);
        }
    }
}
