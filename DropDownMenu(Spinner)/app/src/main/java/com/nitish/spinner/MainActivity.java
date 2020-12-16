package com.nitish.spinner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner=findViewById(R.id.spinner);
        final ImageView imageView=findViewById(R.id.ivOutput);

        String[] country=new String[]{"None","India","England","Australia","Zimbabwe"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,country);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                i=view.getId();
                if(i==0){
                    imageView.setBackground(null);
                }
                if(i==1){
                    imageView.setBackground(getResources().getDrawable(R.drawable.india));
                }
                if(i==2){
                    imageView.setBackground(getResources().getDrawable(R.drawable.australia));
                }
                if(i==3){
                    imageView.setBackground(getResources().getDrawable(R.drawable.england));
                }
                if(i==4){
                    imageView.setBackground(getResources().getDrawable(R.drawable.zimbabw));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}