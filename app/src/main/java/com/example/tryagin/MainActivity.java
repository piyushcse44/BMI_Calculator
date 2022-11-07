package com.example.tryagin;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    // variable
    ConstraintLayout cl_root;
     EditText  wg_kg,hgt_ft,hgt_inch;
     Button bt_submit;
     TextView res_bmi,res_statement;


    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // assign ids to variable
        wg_kg=findViewById(R.id.Wgt_kg);
        hgt_ft=findViewById((R.id.hgt_ft));
        hgt_inch=findViewById(R.id.hgt_inh);
        bt_submit=findViewById(R.id.bt_submit);
        res_bmi=findViewById(R.id.txt_result_bmi);
        res_statement=findViewById(R.id.txt_RESULT_statement);
        cl_root=findViewById(R.id.cl_root);
        res_bmi.setText("");
        res_statement.setText("");
        bt_submit.setOnClickListener(v -> {
            hgt_inch.setEnabled(false);
            hgt_inch.setEnabled(true);
            hgt_ft.setEnabled(false);
            hgt_ft.setEnabled(true);
            wg_kg.setEnabled(false);
            wg_kg.setEnabled(true);


            String temp_wg = wg_kg.getText().toString();
            String temp_ft = hgt_ft.getText().toString();
            String temp_inch = hgt_inch.getText().toString();

            if (temp_wg.length() == 0||temp_ft.length()==0||temp_inch.length()==0) {
                Toast.makeText(MainActivity.this, "Pls input Your height ", Toast.LENGTH_SHORT).show();


            } else {
                if(temp_wg.length() >4||temp_ft.length()>3||temp_inch.length()>2)
                    Toast.makeText(this, "Your input is invalid", Toast.LENGTH_SHORT).show();
                else {
                    int wg = Integer.parseInt(temp_wg);
                    int ft = Integer.parseInt(temp_ft);
                    int inch = Integer.parseInt(temp_inch);
                    double f_height = 30.48 * ft + 2.54 * inch;
                    f_height = f_height / 100;
                    double bmi = wg / (f_height * f_height);
                    res_bmi.setText("BMI : " + String.format("%.2f", bmi));
                    if (bmi < 18.5) {
                        res_statement.setText("YOU ARE UNDER WEIGHT");
                        cl_root.setBackgroundResource(R.color.underweight);
                    } else if (bmi <= 24.9) {
                        res_statement.setText("YOU ARE NORMAL");
                        cl_root.setBackgroundResource(R.color.normal);
                    } else if (bmi <= 25.9) {
                        res_statement.setText("YOU ARE OVERWEIGHT");
                        cl_root.setBackgroundResource(R.color.overweight);
                    } else {
                        res_statement.setText("You are Obese");
                        cl_root.setBackgroundResource(R.color.obese);
                    }

                }
            }

        });

    }
}