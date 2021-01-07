package com.nitish.listapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    /*  https://www.youtube.com/watch?v=VaMWsm6CFss*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView numberView=(TextView)findViewById(R.id.numbers);

        numberView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this,Numbers.class);
                startActivity(intent);
            }
        });
        TextView nameView=(TextView)findViewById(R.id.names);

        nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, Family.class);
                startActivity(intent);
            }
        });
        TextView vedioView=(TextView)findViewById(R.id.vedio);

        vedioView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, Phrases.class);
                startActivity(intent);
            }
        });
        TextView audioView=(TextView)findViewById(R.id.audio);

        audioView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, Colors.class);
                startActivity(intent);
            }
        });

    }
}