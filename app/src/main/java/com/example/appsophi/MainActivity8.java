package com.example.appsophi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity8 extends AppCompatActivity {
    ImageView imgPadrao;
    Integer cod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView btn_voltar;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main8);

        Bundle b = getIntent().getExtras();
        cod = b.getInt("cod");
        Integer produto = b.getInt("produto");
        imgPadrao = findViewById(R.id.imgPadrao);


      switch (produto) {
          case 1:
              switch (cod){
                  case 1: imgPadrao.setImageResource(R.drawable.eb); break;
                  case 2: imgPadrao.setImageResource(R.drawable.er); break;
                  case 3: imgPadrao.setImageResource(R.drawable.lo); break;
                  case 4: imgPadrao.setImageResource(R.drawable.em); break;
                  case 5: imgPadrao.setImageResource(R.drawable.pr); break;
              }
              break;


          case 2:
              switch (cod){
                  case 1: imgPadrao.setImageResource(R.drawable.celine); break;
                  case 2: imgPadrao.setImageResource(R.drawable.elizabeth); break;
                  case 3: imgPadrao.setImageResource(R.drawable.arabella); break;
                  case 4: imgPadrao.setImageResource(R.drawable.penelope); break;
                  case 5: imgPadrao.setImageResource(R.drawable.charlotte); break;
              }
              break;

          case 3:
              switch (cod){
                  case 1: imgPadrao.setImageResource(R.drawable.out1); break;
                  case 2: imgPadrao.setImageResource(R.drawable.out2); break;
                  case 3: imgPadrao.setImageResource(R.drawable.out3); break;
                  case 4: imgPadrao.setImageResource(R.drawable.out4); break;
                  case 5: imgPadrao.setImageResource(R.drawable.out5); break;
              }
              break;
      }


        btn_voltar = findViewById(R.id.btn_voltar);
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}