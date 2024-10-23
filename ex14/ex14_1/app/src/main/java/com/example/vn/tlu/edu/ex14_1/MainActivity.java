package com.example.vn.tlu.edu.ex14_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends Activity {
    EditText edtA,edtB;
    Button btncong;
    ListView lv1;
    ArrayList<String> list;
    ArrayAdapter<String> myarray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }
    private void addEvent() {
// TODO Auto-generated method stub
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                Xulycong();
            }
            private void Xulycong() {
                // TODO Auto-generated method stub

                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                String c = a+" + "+b+" = "+(a+b);
                list.add(c);
                myarray.notifyDataSetChanged();
                edtA.setText("");
                edtB.setText("");
            }
        });
    }
    private void addControl() {
        // TODO Auto-generated method stub
        TabHost tab = (TabHost) findViewById(R.id.tabhost);
        tab.setup();
        TabHost.TabSpec tab1 = tab.newTabSpec("t1");
        tab1.setIndicator("Tab 1");
        tab1.setContent(R.id.tab1);
        tab.addTab(tab1);
        TabHost.TabSpec tab2 = tab.newTabSpec("t2");
        tab2.setIndicator("Tab 2");
        tab2.setContent(R.id.tab2);
        tab.addTab(tab2);
        edtA =(EditText) findViewById(R.id.edtA);
        edtB =(EditText) findViewById(R.id.edtB);
        btncong = (Button) findViewById(R.id.btnCong);
        lv1 = (ListView) findViewById(R.id.lv1);
        list =new ArrayList<String>();
        myarray = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                list);
        lv1.setAdapter(myarray);
    }
}