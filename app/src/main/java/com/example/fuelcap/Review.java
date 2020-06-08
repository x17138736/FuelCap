package com.example.fuelcap;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Button;
import android.widget.Toast;

public class Review extends AppCompatActivity {
        String feedback=getString(R.string.fBack);
        Button subBtn1;
        RatingBar andRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        final RatingBar andRatingBar = (RatingBar) findViewById(R.id.andRatingBar);
        Button subBtn1 = (Button) findViewById(R.id.subBtn1);

        subBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),feedback, Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(Review.this, MainActivity.class));
            }
        });
    }
}
