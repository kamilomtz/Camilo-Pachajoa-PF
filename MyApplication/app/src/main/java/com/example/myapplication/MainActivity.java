package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText te1;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        te1 =(EditText)findViewById(R.id.te1);
        tv1 = (TextView)findViewById(R.id.tv1);
    }

    public void capturar(View view)
    {
        String texto = te1.getText().toString();
        tv1.setText(texto);
    }

}
