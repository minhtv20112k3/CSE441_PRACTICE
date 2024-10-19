package com.example.ex5_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edt_a, edt_b, edt_c;
    Button btnTiepTuc, btnGiai, btnThoat;
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edt_a = findViewById(R.id.edit_a);
        edt_b = findViewById(R.id.edit_b);
        edt_c = findViewById(R.id.edit_c);
        btnTiepTuc = findViewById(R.id.btnTiepTuc);
        btnGiai = findViewById(R.id.btnGiai);
        btnThoat = findViewById(R.id.btnThoat);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sa = edt_a.getText() +"";
                String sb = edt_b.getText() +"";
                String sc = edt_c.getText() +"";
                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);
                double delta = b * b - 4 * a * c;
                String ketqua;
                if (delta > 0) {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    ketqua = "Phương trình có hai nghiệm phân biệt x1 = " + x1 + " và x2 = " + x2;
                }
                else if (delta == 0) {
                    double x = -b / (2 * a);
                    ketqua = "Phương trình có nghiệm kép x1 = x2 = " + x;
                }
                else {
                    ketqua = "Phương trình vô nghiệm";
                }
                txtKetQua.setText(ketqua);
            }
        });
        btnTiepTuc.setOnClickListener(v -> {
            edt_a.setText("");
            edt_b.setText("");
            edt_c.setText("");
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}