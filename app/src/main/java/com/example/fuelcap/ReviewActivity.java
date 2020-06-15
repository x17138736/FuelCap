package com.example.fuelcap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ReviewActivity extends AppCompatActivity {
    String Feedback = getString(R.string.fBack);
    Button submitBtn;
    RatingBar androidRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        final RatingBar androidRatingBar = (RatingBar)findViewById(R.id.andRatingBar);
        Button submitBtn = (Button)findViewById(R.id.subBtn1);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),Feedback, Toast.LENGTH_LONG).show();
                startActivity(new Intent(ReviewActivity.this, MainActivity.class));
            }
        });
    }

}
