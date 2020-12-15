package com.nitish.textbetactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView Display=findViewById(R.id.textView);
        Bundle bout = getIntent().getExtras();
        String name=bout.getString("Abc");
        Display.setText(String.valueOf(name));

    }
}