package com.programacionmoviles.juanpabloarangoa.formulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String usuario,pass1,pass2,email,sexo,hobbies;
    private EditText eUser, ePass1, ePass2, eMail;
    private RadioButton rSexM, rSexF;
    private CheckBox cCine,cVideo,cNadar,cFutbol;
    private Spinner sCities;
    private Button bAceptar;
    private TextView tInfo;

    public String ciudad;
    public EditText eDatePicker;
    public static int day,month,year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eUser       = findViewById(R.id.eUser);
        ePass1      = findViewById(R.id.ePass1);
        ePass2      = findViewById(R.id.ePass2);
        eMail       = findViewById(R.id.eMail);
        rSexM       = findViewById(R.id.rSexM);
        rSexF       = findViewById(R.id.rSexF);
        cCine       = findViewById(R.id.cCine);
        cVideo      = findViewById(R.id.cVideo);
        cNadar      = findViewById(R.id.cNadar);
        sCities     = findViewById(R.id.sCities);
        bAceptar    = findViewById(R.id.bAceptar);
        tInfo       = findViewById(R.id.tInfo);
        eDatePicker = findViewById(R.id.eDatePicker);



    }

    public void onRadioButtonClicked(View view) {

    }

    public void onButtonAceptar(View view) {

    }
}
