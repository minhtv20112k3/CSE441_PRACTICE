package com.example.ex06;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtTen, edtCMND, edtBoSung;
    CheckBox chkDocBao, chkDocSach, chkDocCoding;
    RadioGroup rGroup;
    Button btnGui;
    RadioButton rBtnTrungCap, rBtnCaoDang, rBtnDaiHoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtTen = findViewById(R.id.edtTen);
        edtCMND = findViewById(R.id.edtCMND);
        edtBoSung = findViewById(R.id.edtBoSung);
        chkDocBao = findViewById(R.id.chkDocBao);
        chkDocSach = findViewById(R.id.chkDocSach);
        chkDocCoding = findViewById(R.id.chkDocCoding);
        rGroup = findViewById(R.id.rGroup);
        rBtnDaiHoc = findViewById(R.id.rBtnDaiHoc);
        rBtnDaiHoc.setChecked(true);
        rBtnTrungCap = findViewById(R.id.rBtnTrungCap);
        rBtnCaoDang = findViewById(R.id.rBtnCaoDang);
        btnGui = findViewById(R.id.btnGui);
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hienThiThongTin();
            }
        });
        }
        public void hienThiThongTin() {
            String ten = edtTen.getText().toString();
            ten = ten.trim();
            if(ten.length() < 3){
                edtTen.requestFocus();
                edtTen.selectAll();
                Toast.makeText(this, "Ten phai >= 3 ky tu", Toast.LENGTH_SHORT).show();
                return;
            }
            String cmnd = edtCMND.getText().toString();
            cmnd = cmnd.trim();
            if(cmnd.length() != 9) {
                edtCMND.requestFocus();
                edtCMND.selectAll();
                Toast.makeText(this, "CMND phai co 9 ky tu", Toast.LENGTH_SHORT).show();
                return;
            }
            String bang ="Dai hoc";
            if(rBtnTrungCap.isChecked() == true) {
                bang = "Trung cap";
            }
            else if(rBtnCaoDang.isChecked() == true) {
                bang = "Cao dang";
            }
            String SoThich = "";
            if(chkDocBao.isChecked() == false && chkDocSach.isChecked() == false && chkDocCoding.isChecked() == false) {
                Toast.makeText(this, "Vui long chon so thich", Toast.LENGTH_SHORT).show();
                return;
            }
            if(chkDocBao.isChecked()) {
                SoThich += "Doc bao ";
            }
            if(chkDocSach.isChecked()) {
                SoThich += "Doc sach";
            }
            if(chkDocCoding.isChecked()) {
                SoThich += "Doc Coding";
            }
            String bosung = edtBoSung.getText().toString();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Thong tin ca nhan");
            builder.setPositiveButton("Dong", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.cancel();
                }
            });
            String msg = ten + "\n";
            msg += cmnd + "\n";
            msg += bang + "\n";
            msg += SoThich + "\n ";
            msg += "------------------------------------\n";
            msg += "Thong tin bo sung: \n";
            msg += bosung + "\n";
            msg += "------------------------------------";
            builder.setMessage(msg);
            builder.create().show();
        }
        public void Thoat(){
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Thong bao");
        b.setMessage("Ban co chac chan muon khong?");
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        b.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        b.create().show();
        }
}
