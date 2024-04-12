package com.example.appsophi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity implements View.OnClickListener{
    Button btn1, btn2, btn3, btn4, btn5;
    Bundle b;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ImageView img1 = (ImageView)
                findViewById(R.id.img1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity5.this, MainActivity.class);
                startActivity(i);
            }
        });
        b = new Bundle();
        btn1 = findViewById(R.id.btn2);
        btn2 = findViewById(R.id.btn3);
        btn3 = findViewById(R.id.btn4);
        btn4 = findViewById(R.id.btn5);
        btn5 = findViewById(R.id.btn6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        i = new Intent(MainActivity5.this, MainActivity8.class);
        b.putInt("produto", 2);
        if(v.getId() == R.id.btn2){
            b.putInt("cod",1);
            i.putExtras(b);
            startActivity(i);
        }else if(v.getId() == R.id.btn3){
            b.putInt("cod",2);
            i.putExtras(b);
            startActivity(i);
        }else if(v.getId() == R.id.btn4){
            b.putInt("cod",3);
            i.putExtras(b);
            startActivity(i);
        }else if(v.getId() == R.id.btn5){
            b.putInt("cod",4);
            i.putExtras(b);
            startActivity(i);
        }else if(v.getId() == R.id.btn6){
            b.putInt("cod",5);
            i.putExtras(b);
            startActivity(i);
        }
    }
    }
