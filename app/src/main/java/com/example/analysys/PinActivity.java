package com.example.analysys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PinActivity extends AppCompatActivity {

    Button num1;
    Button num2;
    Button num3;
    Button num4;
    Button num5;
    Button num6;
    Button num7;
    Button num8;
    Button num9;
    Button num0;

    ImageButton delete;

    ImageView krug1;
    ImageView krug2;
    ImageView krug3;
    ImageView krug4;

    int b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pin_activity);



        num1 = findViewById(R.id.but1); num2 = findViewById(R.id.but2); num3 = findViewById(R.id.but3); num4 = findViewById(R.id.but4);
        num5 = findViewById(R.id.but5); num6 = findViewById(R.id.but6); num7 = findViewById(R.id.but7); num8 = findViewById(R.id.but8);
        num9 = findViewById(R.id.but9); num0 = findViewById(R.id.but0); delete=findViewById(R.id.del);

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                if (b>4){ b=4;};
                backgrchange(b);
            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                if (b>4){ b=4;};
                backgrchange(b);
            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                if (b>4){ b=4;};
                backgrchange(b);
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                if (b>4){ b=4;};
                backgrchange(b);
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                if (b>4){ b=4;};
                backgrchange(b);
            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                if (b>4){ b=4;};
                backgrchange(b);
            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                if (b>4){ b=4;};
                backgrchange(b);
            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                if (b>4){ b=4;};
                backgrchange(b);
            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                if (b>4){ b=4;};
                backgrchange(b);
            }
        });

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                if (b>4){ b=4;};
                backgrchange(b);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b--;
                if (b<0){ b=0;};
                switch (b) {
                    case (0):
                        krug1.setBackgroundResource(R.drawable.unfilled);
                        break;
                    case (1):
                        krug2.setBackgroundResource(R.drawable.unfilled);
                        break;
                    case (2):
                        krug3.setBackgroundResource(R.drawable.unfilled);
                        break;
                    case (3):
                        krug4.setBackgroundResource(R.drawable.unfilled);
                        break;
                }
            }
        });
// 48486468486468489484
    }

    public void backgrchange(int b){
        krug1=findViewById(R.id.img1);
        krug2=findViewById(R.id.img2);
        krug3=findViewById(R.id.img3);
        krug4=findViewById(R.id.img4);


        switch (b) {
            case  (1):
                krug1.setBackgroundResource(R.drawable.filled);
                break;
            case (2):
                krug2.setBackgroundResource(R.drawable.filled);
                break;
            case (3):
                krug3.setBackgroundResource(R.drawable.filled);
                break;
            case (4):
                krug4.setBackgroundResource(R.drawable.filled);
                Intent intent = new Intent(PinActivity.this, CardActivity.class);
                startActivity(intent);
                break;
        }
    }
}