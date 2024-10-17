package com.example.ex5_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnChuyenDoi;
    EditText edtNamDuong, edtNamAm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnChuyenDoi = findViewById(R.id.btnChuyenDoi);
        edtNamAm = findViewById(R.id.edtNamAm);
        edtNamDuong = findViewById(R.id.edtNamDuong);
        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int namDuong = Integer.parseInt(edtNamDuong.getText() +"");
                String can = "";
                String chi = "";
                switch (namDuong%10){
                    case 0:
                        can = "Canh ";
                        break;
                    case 1:
                        can = "Tan ";
                        break;
                    case 2:
                        can = "Nham ";
                        break;
                    case 3:
                        can = "Quy ";
                        break;
                    case 4:
                        can = "Giap ";
                        break;
                    case 5:
                        can = "At ";
                        break;
                    case 6:
                        can = "Binh ";
                        break;
                    case 7:
                        can = "Dinh ";
                        break;
                    case 8:
                        can = "Mau ";
                        break;
                    case 9:
                        can = "Ky ";
                        break;
                }

                switch (namDuong%12){
                    case 0:
                        chi = "Than ";
                        break;
                    case 1:
                        chi = "Dau ";
                        break;
                    case 2:
                        chi = "Tuat ";
                        break;
                    case 3:
                        chi = "Hoi ";
                        break;
                    case 4:
                        chi = "Ty ";
                        break;
                    case 5:
                        chi = "Suu ";
                        break;
                    case 6:
                        chi = "Dan ";
                        break;
                    case 7:
                        chi = "Mao ";
                        break;
                    case 8:
                        chi = "Thin ";
                        break;
                    case 9:
                        chi = "Ty ";
                        break;
                    case 10:
                        chi = "Ngo ";
                        break;
                    case 11:
                        chi = "Mui ";
                        break;
                }
                String Kq = can + chi;
                edtNamAm.setText(Kq);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}