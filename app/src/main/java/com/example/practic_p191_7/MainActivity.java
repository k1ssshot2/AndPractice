package com.example.practic_p191_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 4-7");

        CheckBox chkEnb, chkClk, chkRot;
        Button btn;

        chkEnb = (CheckBox) findViewById(R.id.ChkEnb);
        chkClk = (CheckBox) findViewById(R.id.ChkClk);
        chkRot = (CheckBox) findViewById(R.id.ChkRot);
        btn = (Button)findViewById(R.id.Btn);

        chkEnb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkEnb.isChecked() == true) {
                        btn.setEnabled(false);
                }else{
                    btn.setEnabled(true);
                }
            }
        });

        chkClk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkClk.isChecked() == true) {
                    btn.setClickable(false);
                }else{
                    btn.setClickable(true);
                }
            }
        });

        chkRot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkRot.isChecked() == true) {
                    btn.setRotation(90);
                }else{
                    btn.setRotation(0);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Practice_192_8.class);
                startActivity(myIntent);
                finish();
            }
        });
    }
}