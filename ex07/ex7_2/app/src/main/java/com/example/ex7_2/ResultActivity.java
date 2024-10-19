package com.example.ex7_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView txtKetQua;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnBack = findViewById(R.id.btnBack);
        Intent intent2 = getIntent();
        Bundle yourbundle = intent2.getBundleExtra("mybackage");
        int a = yourbundle.getInt("a");
        int b = yourbundle.getInt("b");
        String kq = "";
        if(a==0) {
            if (b == 0) {
                kq = "Phuong trinh vo so nghiem";
            } else {
                kq = "Phuong trinh vo nghiem";
            }
        }
        else{
            kq = "x = " + (-b/a);
        }
        txtKetQua.setText(kq);
        btnBack.setOnClickListener(view -> {
            finish();
        });
    }
}
