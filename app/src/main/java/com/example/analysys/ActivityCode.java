package com.example.analysys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityCode extends AppCompatActivity {

    private TextView textTimer;
    private EditText code1;
    private EditText code2;
    private EditText code3;
    private EditText code4;
    private ImageButton back;
    private String codik;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        textTimer=findViewById(R.id.txttimer);
        code1=findViewById(R.id.num1);
        code2=findViewById(R.id.num2);
        code3=findViewById(R.id.num3);
        code4=findViewById(R.id.num4);
        back=findViewById(R.id.imageButton);

        setTimer();
        code1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (code1.getText().toString().equals("")){
                }else{
                    code2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        code2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (code2.getText().toString().equals("")){
                    code1.requestFocus();
                }else{
                    code3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(code2.getText().toString().equals("")){
                    code1.requestFocus();
                }
            }
        });

        code3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (code3.getText().toString().equals("")){
                    code2.requestFocus();
                }else{
                    code4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(code3.getText().toString().equals("")){
                    code2.requestFocus();
                }
            }
        });

        code4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (code4.getText().toString().equals("")){
                    code3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(code4.getText().toString().equals("")){
                    code3.requestFocus();
                }else{codeRetrie();

                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityCode.this, Login.class);
                startActivity(intent);
            }
        });

    }

    private void setTimer() {
        CountDownTimer count = new CountDownTimer(59000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textTimer.setText("Отправить код повторно можно\n будет через "+millisUntilFinished/1000+" секунд");
            }

            @Override
            public void onFinish() {
                textTimer.setText("Отправить код повторно");
                textTimer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setTimer();
                    }
                });
            }
        };
        count.start();
    }

    public void codeRetrie()
    {
        SessionManager sessionManager = new SessionManager(this);
        String email = sessionManager.getEmail();
        String code = code1.getText().toString() + code2.getText().toString() + code3.getText().toString()+code4.getText().toString();
        sessionManager.saveCode(code);
        ApiClient apiClient  = new ApiClient();
        apiClient.getApiService(this).signin(email, code)
                .enqueue(new Callback<SendCodeResponse>() {
                    @Override
                    public void onResponse(Call<SendCodeResponse> call, Response<SendCodeResponse> response) {
                        if(!response.isSuccessful())
                        {

                            return;
                        }
                        String str = response.message();
                        sessionManager.saveToken(SendCodeResponse.getMessage());
                        Intent intent = new Intent(ActivityCode.this, PinActivity.class);
                        startActivity(intent);
                        return;
                    }

                    @Override
                    public void onFailure(Call<SendCodeResponse> call, Throwable t) {

                    }
                });
    }

};
