package com.example.ex7_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnYeuCauKetQua;
    EditText edtA, edtB, edtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnYeuCauKetQua = findViewById(R.id.btnYeuCauKetQua);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnYeuCauKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Result.class);
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                intent1.putExtra("a", a);
                intent1.putExtra("b", b);
                startActivityForResult(intent1, 99);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == 33)
        {
            int sum = data.getIntExtra("kq",0);
            edtKetQua.setText("Tổng 2 số là: "+sum);
        }
        if (requestCode == 99 && resultCode == 34)
        {
            int sub = data.getIntExtra("kq",0);
            edtKetQua.setText("Hiệu 2 số là: "+sub);
        }
    }
}