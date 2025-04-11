package com.example.practic_p191_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Practice_192_8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice1928);

        EditText inputEdit = findViewById(R.id.InputText);
        Button btnBack = findViewById(R.id.BtnBack);

        inputEdit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                // 키가 눌릴 때만 처리 (ACTION_DOWN)
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    String currentText = inputEdit.getText().toString();
                    Toast.makeText(getApplicationContext(), currentText, Toast.LENGTH_SHORT).show();
                }
                return false; // false로 해야 EditText가 정상 동작함
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backIntent);
            }
        });
    }

}