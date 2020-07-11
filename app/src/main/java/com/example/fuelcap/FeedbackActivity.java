package com.example.fuelcap;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;

public class FeedbackActivity extends AppCompatActivity {

    private EditText userEmail;
    private EditText topic;
    private EditText messageBody;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        userEmail = findViewById(R.id.userEmail);
        userEmail.setVisibility(View.INVISIBLE);
        topic = findViewById(R.id.topic);
        messageBody = findViewById(R.id.messageBody);

        sendButton = findViewById(R.id.sendBtn);



        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Topic = topic.getText().toString();
                String MessageBody = messageBody.getText().toString();
                String userMail = userEmail.getText().toString();


                String[] email_divide = userMail.split(",");


                Intent send= new Intent(Intent.ACTION_SEND);
                send.putExtra(Intent.EXTRA_EMAIL, email_divide);
                send.putExtra(Intent.EXTRA_SUBJECT, Topic);
                send.putExtra(Intent.EXTRA_TEXT, MessageBody);
                send.setType("message/rfc822");
                send.setPackage("com.google.android.gm");
                startActivity(send);

            }
        });

    }
}
