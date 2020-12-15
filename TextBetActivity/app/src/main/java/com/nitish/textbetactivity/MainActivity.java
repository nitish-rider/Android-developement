package com.nitish.textbetactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText inputText= findViewById(R.id.editText);
        final TextView outputText=findViewById(R.id.textview);
        Button add=findViewById(R.id.bt_add);
        Button save=findViewById(R.id.bt_save);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value= inputText.getText().toString();
                outputText.setText(value);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=outputText.getText().toString();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("Abc",data);
                startActivity(intent);
                finish();
            }
        });
    }
}