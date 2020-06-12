package com.example.fuelcap;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.List;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        final EditText mail2 = findViewById(R.id.email2);
        final EditText name =  findViewById(R.id.conName);
        final EditText cMsg =  findViewById(R.id.cUsMsg);
        final Button   cBtn =  findViewById(R.id.sndBtn);
        final String password = "BADpj2020";
        final String sEmail = "fcsend2020@gmail.com";
        final String rEmail = "fcrec2020@gmail.com";
        final boolean contt;

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED){
            // Connection Affirmative ;)
            contt = true;
        }
        else{
            contt = false;
            Toast.makeText(getApplicationContext(), "You don't have an internet connection",
                    Toast.LENGTH_LONG).show();
        }
        cBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        //make sure all the fields are filled first.
                        if (name.getText().toString().equals("") ||  mail2.getText().toString().equals("") || cMsg.getText().toString().equals("")) {
                            Toast.makeText(ContactUs.this.getApplicationContext(), "Please go back and fill all fields",
                                    Toast.LENGTH_LONG).show();
                        } else if (contt != true) {
                            Toast.makeText(ContactUs.this.getApplicationContext(), "Your internet connection is shit please check it",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            if (!mail2.getText().toString().equals("") &&  mail2.getText().toString().contains("@")){
                                Log.i("SendMailActivity", "Send message button has been clicked");
                                //We'll declare the password, receiving and sending of the email
                                List<String> emailList = Arrays.asList(rEmail.split("\\s*,\\s*")); //This is the emails/people who would receive the email
                                Log.i("SendMailActivity", "Receive List: " + emailList);
                                String emailSub = ((EditText) findViewById(R.id.conName)).getText().toString();
                                String conEmail = ((EditText) findViewById(R.id.email2)).getText().toString();
                                String mailBody = "User's Name : " + ((EditText) findViewById(R.id.conName)).getText().toString() + "\n" + "User's Email : " +
                                        ((EditText) findViewById(R.id.email2)).getText().toString() + "\n" +
                                        "User's Message / Query : " + ((EditText) findViewById(R.id.cUsMsg)).getText().toString();
                                new SendMailTask(ContactUs.this).execute(sEmail, password, emailList, emailSub, mailBody, conEmail); // Now that we have all the necessary data we can proceed with send it.
                                startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Email needs to be filled out and contain an @ symbol. Thank You",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
        );

    }
}
