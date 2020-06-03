package com.example.fuelcap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

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

    private void openMaps () {
        Intent intent=new Intent(SecondActivity.this, MapsActivity.class);
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
        if (item.getItemId() == R.id.logoutMenu) {
            Logout();
            return super.onOptionsItemSelected(item);
        }
        else if (item.getItemId() == R.id.reviewpageMenu){
                Intent intent=new Intent(SecondActivity.this, Review.class);
                startActivity(intent);
        }
        else if (item.getItemId() == R.id.contactusMenu){
            Intent intent=new Intent(SecondActivity.this, ContactUs.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.changeLang){
                //Show the alert box to bring up the display of languages that can be selected.
                showChangeLanguageDialog();
            //This is the same code from the Main activity that has been modified for the button here.
            //The onClickListener doesn't apply here so I had to change that.
        }

        return super.onOptionsItemSelected(item);
    }

    //This is the same code from the Main activity that has been modified for the button here.
    private void showChangeLanguageDialog() {
        // Languages that are available to use
        final String[] listItems = {"Deutsche", "Español", "Română", "हिन्दी", "English"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SecondActivity.this);
        mBuilder.setTitle("Choose Your Language..");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i==0){
                    // Choose German
                    setLocale("de");
                    recreate();
                }
                else if (i==1){
                    // Choose Spanish
                    setLocale("es");
                    recreate();
                }
                else if (i==2){
                    // Choose Romanian
                    setLocale("ro");
                    recreate();
                }
                else if (i==3){
                    // Choose Hindi
                    setLocale("hi");
                    recreate();
                }
                else if (i==4){
                    // Choose English
                    setLocale("en");
                    recreate();
                }

                //get rid of the dialog box after the language has been selected.
                dialogInterface.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        // let the alert dialog box be shown.
        mDialog.show();
    }

    //This is the same code from the Main activity that has been modified for the button here.
    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());
        // Save Data to shared Preferences
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    //This is the same code from the Main activity that has been modified for the button here.
    // Load Language that's saved in shared preferences.
    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
    }


}
