package com.example.fuelcap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FuelPricesAverageActivity extends AppCompatActivity {
    private Button ptlAv;
    private Button dslAv;
    private TextView priceAv;

    private String Euro ="\u20ac";


    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_average_fuel_price);

        ptlAv = (Button)findViewById(R.id.ptlAv);
        dslAv = (Button)findViewById(R.id.dslAv);
        priceAv = (TextView)findViewById(R.id.priceAv);

        ptlAv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPetrolAverage();
            }
        });
        dslAv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDieselAverage();
            }
        });

    }
    public void openPetrolAverage(){
        priceAv.setText("1.23 Euro per liter");
    }
    public void openDieselAverage(){
        priceAv.setText("1.15 Euro per liter");
    }

}


