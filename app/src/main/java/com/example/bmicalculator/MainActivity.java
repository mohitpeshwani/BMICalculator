package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText height,height2;
    EditText weight;
    Button check;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.height);
        height2 = findViewById(R.id.height2);
        weight = findViewById(R.id.weight);
        check = findViewById(R.id.checks);
        LinearLayout ll =findViewById(R.id.root);
        results = findViewById(R.id.results);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float tempHeight=Float.parseFloat(height.getText().toString());
                float tempWeight=Float.parseFloat(weight.getText().toString());
                float inches = Float.parseFloat(height2.getText().toString());
                float  totalInches = tempHeight*12+ inches;
                double totalCentimeter = totalInches * 2.53;
                double meter =totalCentimeter/100;
                double bmi = tempWeight/Math.pow(meter,2);
                if(bmi > 25)
                {
                    results.setText("You are overweight");
                    ll.setBackgroundColor(getResources().getColor(R.color.overweight));
                    Toast.makeText( getApplicationContext(),"Overweight", Toast.LENGTH_SHORT).show();

                } else if (bmi<18) {
                    results.setText("You are underweight");
                    ll.setBackgroundColor(getResources().getColor(R.color.underweight));
                    Toast.makeText( getApplicationContext(),"Underweight", Toast.LENGTH_SHORT).show();
                }
                else {
                    results.setAllCaps(true);
                    ll.setBackgroundColor(getResources().getColor(R.color.healthy));
                    results.setText("You are Healthy");
                    Toast.makeText( getApplicationContext(),"Healthy", Toast.LENGTH_SHORT).show();

                }


            }
        });




    }
}