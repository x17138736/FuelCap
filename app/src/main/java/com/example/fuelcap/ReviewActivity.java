package com.example.fuelcap;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;


public class ReviewActivity extends AppCompatActivity {
    private RatingBar userRating;
    private float userRatingValue;
    private Button SubmitButton1;
    private EditText userTextReview;
    private TextView userRatingText;
    private TextView userRatingTextComment;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        userRating = (RatingBar)findViewById(R.id.userRating);
        SubmitButton1 = (Button)findViewById(R.id.submitButton1);
        userTextReview = (EditText)findViewById(R.id.userTextReview);
        userRatingText = (TextView)findViewById(R.id.userRatingText);
        userRatingTextComment = (TextView)findViewById(R.id.userRatingTextComment);

        userRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                userRatingValue = userRating.getRating();
                userRatingText.setText("User Rating: "+userRatingValue+" /5.0.");
                RatingComments();
            }

        });

        SubmitButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Thank you for your feedback", Toast.LENGTH_SHORT).show();
                userRatingText.getText().toString();
               startActivity(new Intent(ReviewActivity.this, SecondActivity.class));
            }
        });
    }
    private void RatingComments(){
        if(userRatingValue<1.1){
            userRatingTextComment.setText("Sorry were not up to scratch");
        }else if(userRatingValue<2.1){
            userRatingTextComment.setText("Were getting there");
        }else if(userRatingValue<3.1){
            userRatingTextComment.setText("Halfway There");
        }else if(userRatingValue<4.1){
            userRatingTextComment.setText("above Average");
        }else if(userRatingValue<5.1){
            userRatingTextComment.setText("Glad we could help");
        }
    }
}
