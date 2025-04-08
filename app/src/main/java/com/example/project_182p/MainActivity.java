package com.example.project_182p;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Switch chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRab;
    Button btnOk, btnFir;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = (TextView)  findViewById(R.id.Text1);
        chkAgree = (Switch) findViewById(R.id.ChkAgree);

        text2 = (TextView)  findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoDog = (RadioButton) findViewById(R.id.RdoDog);
        rdoCat = (RadioButton) findViewById(R.id.RdoCat);
        rdoRab = (RadioButton) findViewById(R.id.RdoRab);

        btnOk = (Button) findViewById(R.id.BtnOK);
        btnFir = (Button) findViewById(R.id.BtnFir);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree.isChecked() == true) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1 .setVisibility(android.view.View.VISIBLE);
                    btnOk.setVisibility(android.view.View.VISIBLE);
                    btnFir.setVisibility(android.view.View.VISIBLE);
                    imgPet.setVisibility(android.view.View.VISIBLE);
                } else{
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1 .setVisibility(android.view.View.INVISIBLE);
                    btnOk.setVisibility(android.view.View.INVISIBLE);
                    btnFir.setVisibility(android.view.View.INVISIBLE);
                    imgPet.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.RdoDog)
                    imgPet.setImageResource(R.drawable.puppy);
                else if(checkedId == R.id.RdoCat)
                    imgPet.setImageResource(R.drawable.cat);
                else if(checkedId == R.id.RdoRab)
                    imgPet.setImageResource(R.drawable.rabbit);
                else
                    Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요",
                            Toast.LENGTH_SHORT).show();

            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ((Activity) arg0.getContext()).finish();
            }
        });

        btnFir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(arg0.getContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                arg0.getContext().startActivity(intent);
            }
        });

    }
}