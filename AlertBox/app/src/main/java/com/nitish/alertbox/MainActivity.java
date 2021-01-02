package com.nitish.alertbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.InputDevice;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText input=findViewById(R.id.et_input);
        Button show=findViewById(R.id.bt_show);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text= input.getText().toString();
                if(text.isEmpty()){
                    alert("Please Insert Data!!!");
                }else{
                    alert(text);
                }
            }
        });
    }
    private void alert(String message){
         AlertDialog dil=new AlertDialog.Builder(MainActivity.this).setTitle("Message").setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                       dialog.dismiss();
                    }
                }).create();
         dil.show();
    }
}