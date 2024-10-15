package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnBMI;
    EditText edtName, edtHeight, edtWeight, edtBMI, edtDiagnosis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnBMI = findViewById(R.id.btnBMI);
        edtName = findViewById(R.id.edtName);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        edtDiagnosis = findViewById(R.id.edtDiagnosis);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double h = Double.parseDouble(edtHeight.getText().toString());
                double w = Double.parseDouble(edtWeight.getText().toString());
                double bmi = w/Math.pow(h,2);
                String diagnosis = "";
                if(bmi < 18){
                    diagnosis = "You are thin";
                }
                else if(bmi <= 24.9){
                    diagnosis = "You normal";
                }
                else if(bmi <= 29.9){
                    diagnosis = "You fat level 1";
                }
                else if(bmi <= 34.9){
                    diagnosis = "You fat level 2";
                }
                else{
                    diagnosis = "You fat level 3";
                }
                DecimalFormat dft = new DecimalFormat("#.0");
                edtBMI.setText(dft.format(bmi));
                edtDiagnosis.setText(diagnosis);
            }
        });
    }
}