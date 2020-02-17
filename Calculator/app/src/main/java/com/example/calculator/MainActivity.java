package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText screen;
    private TextView n0,n1,n2,n3,n4,n5,n6,n7,n8,n9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        n0=findViewById(R.id.b0);
        n1=findViewById(R.id.b1);
        n2=findViewById(R.id.b2);
        n3=findViewById(R.id.b3);
        n4=findViewById(R.id.b4);
        n5=findViewById(R.id.b5);
        n6=findViewById(R.id.b6);
        n7=findViewById(R.id.b7);
        n8=findViewById(R.id.b8);
        n9=findViewById(R.id.b9);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void capturar(){
        
    }
}
