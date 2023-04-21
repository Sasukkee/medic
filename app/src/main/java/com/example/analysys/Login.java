package com.example.analysys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button but1 = findViewById(R.id.button);
        EditText edit = findViewById(R.id.editTextTextEmailAddress);
        but1.setEnabled(false);

        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String b=edit.getText().toString();
                if (b.contains("@")&b.contains(".")) {
                    but1.setEnabled(true);
                    but1.setBackgroundColor(Color.parseColor("#1A6FEE"));
                } else {
                    but1.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }


        });

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, ActivityCode.class);
                startActivity(intent);
            }
        });
    }
}