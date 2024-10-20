package com.example.ex7_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    EditText edtAA, edtBB;
    Button btnTong, btnHieu;
    Intent myintent;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        edtAA = findViewById(R.id.edtA);
        edtBB = findViewById(R.id.edtB);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        myintent = getIntent();
        int a = myintent.getIntExtra("soa",0);
        int b = myintent.getIntExtra("sob",0);
        edtAA.setText(a+"");
        edtBB.setText(b+"");
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = a + b;
                myintent.putExtra("kq",sum);
                setResult(33,myintent);
                finish();
            }
        });
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sub = a - b;
                myintent.putExtra("kq",sub);
                setResult(34, myintent);
                finish();
            }
        });
    }
}
