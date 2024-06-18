package com.example.appsophi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity implements
        View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    Intent i;
    private CheckBox ckbCi, ckbFu, ckbIn, ckbLi, ckbTe;
    private Button btnEx, btnDes, btnInfo;
    private int cont;
    private ImageView imgPadrao;
    private Integer cod;
    private Spinner spinnerState;
    private EditText etCEP, etComplement;
    private RadioGroup rgOptions;
    private RadioButton rbPresent, rbForMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        ckbCi = findViewById(R.id.checkBox1);
        ckbFu = findViewById(R.id.checkBox2);
        ckbIn = findViewById(R.id.checkBox4);
        ckbLi = findViewById(R.id.checkBox5);
        ckbTe = findViewById(R.id.checkBox6);

        btnEx = findViewById(R.id.button);
        btnDes = findViewById(R.id.button2);
        btnInfo = findViewById(R.id.button3);


        ckbCi.setOnCheckedChangeListener(this);
        ckbFu.setOnCheckedChangeListener(this);
        ckbIn.setOnCheckedChangeListener(this);
        ckbLi.setOnCheckedChangeListener(this);
        ckbTe.setOnCheckedChangeListener(this);
        btnEx.setOnClickListener(this);
        btnDes.setOnClickListener(this);
        btnInfo.setOnClickListener(this);

        cont = 0;

        final ImageView imageView1 = findViewById(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity8.this, MainActivity.class);
                startActivity(i);
            }
        });


        spinnerState = findViewById(R.id.spinnerState);
        etCEP = findViewById(R.id.etCEP);
        etComplement = findViewById(R.id.etComplement);
        rgOptions = findViewById(R.id.rgOptions);
        rbPresent = findViewById(R.id.rbPresent);
        rbForMe = findViewById(R.id.rbForMe);


        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedState = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity8.this, "Selected: " + selectedState, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Get data from Intent
        Bundle b = getIntent().getExtras();
        if (b != null) {
            cod = b.getInt("cod");
            int produto = b.getInt("produto");
            setImageResourceBasedOnCodeAndProduct(cod, produto);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            String txt = "Forma de pagamento selecionada \n\n";
            txt += ckbCi.isChecked() ? "Crédito\n" : "";
            txt += ckbFu.isChecked() ? "Debito\n" : "";
            txt += ckbIn.isChecked() ? "Á vista\n" : "";
            txt += ckbLi.isChecked() ? "Parcelado\n" : "";
            txt += ckbTe.isChecked() ? "Boleto\n" : "";

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage(txt);
            dlg.setPositiveButton("Pagar", null);
            dlg.show();
        } else if (view.getId() == R.id.button2) {
            ckbCi.setChecked(false);
            ckbFu.setChecked(false);
            ckbIn.setChecked(false);
            ckbLi.setChecked(false);
            ckbTe.setChecked(false);
        } else if (view.getId() == R.id.button3) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Caro(a) Cliente,\n\nAgradecemos pela sua compra na Sophistique! Sua escolha nos enche de alegria e gratidão. Esperamos que seu novo item traga ainda mais elegância e sofisticação para sua vida.\n\nAtenciosamente,\n\n Equipe Sophistique");
            dlg.setPositiveButton("OK", null);
            dlg.show();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            cont++;
        } else {
            cont--;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void setImageResourceBasedOnCodeAndProduct(int cod, int produto) {
        imgPadrao = findViewById(R.id.imgPadrao);
        switch (produto) {
            case 1:
                switch (cod) {
                    case 1:
                        imgPadrao.setImageResource(R.drawable.eb);
                        break;
                    case 2:
                        imgPadrao.setImageResource(R.drawable.er);
                        break;
                    case 3:
                        imgPadrao.setImageResource(R.drawable.lo);
                        break;
                    case 4:
                        imgPadrao.setImageResource(R.drawable.em);
                        break;
                    case 5:
                        imgPadrao.setImageResource(R.drawable.pr);
                        break;
                }
                break;
            case 2:
                switch (cod) {
                    case 1:
                        imgPadrao.setImageResource(R.drawable.celine);
                        break;
                    case 2:
                        imgPadrao.setImageResource(R.drawable.elizabeth);
                        break;
                    case 3:
                        imgPadrao.setImageResource(R.drawable.arabella);
                        break;
                    case 4:
                        imgPadrao.setImageResource(R.drawable.penelope);
                        break;
                    case 5:
                        imgPadrao.setImageResource(R.drawable.charlotte);
                        break;
                }
                break;
            case 3:
                switch (cod) {
                    case 1:
                        imgPadrao.setImageResource(R.drawable.out1);
                        break;
                    case 2:
                        imgPadrao.setImageResource(R.drawable.out2);
                        break;
                    case 3:
                        imgPadrao.setImageResource(R.drawable.out3);
                        break;
                    case 4:
                        imgPadrao.setImageResource(R.drawable.out4);
                        break;
                    case 5:
                        imgPadrao.setImageResource(R.drawable.out5);
                        break;
                }
                break;
        }
    }
}
