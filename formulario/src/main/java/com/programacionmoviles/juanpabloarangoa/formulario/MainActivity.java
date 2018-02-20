package com.programacionmoviles.juanpabloarangoa.formulario;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private String usuario,pass1,pass2,email,sexo,hobbies;
    private EditText eUser, ePass1, ePass2, eMail;
    private RadioButton rSexM, rSexF;
    private CheckBox cCine,cVideo,cNadar,cFutbol;
    private Spinner sCities;
    private Button bAceptar,bDate;
    private TextView tInfo;

    public String ciudad;
    public EditText eDatePicker;
    private int day_,month_,year_;
    private boolean flagFinish1 = false;


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

        bDate       = findViewById(R.id.bDate);
        sexo = getString(R.string.sexM);
        //bDate.setOnClickListener((View.OnClickListener) this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.all_cities, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sCities.setAdapter(adapter);
        sCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //adapterView recibe el adaptar, el view, la posicion
                ciudad = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        if(view.getId()==R.id.rSexM) {
            sexo = getString(R.string.sexM);
        }else {
            sexo = getString(R.string.sexF);
        }
    }

    public void onButtonAceptar(View view) {
        usuario = eUser.getText().toString();
        pass1   = ePass1.getText().toString();
        pass2   = ePass2.getText().toString();
        email   = eMail.getText().toString();
        finishOrNot();
    }

    public void onButtonDate(View view) {
        final Calendar calendario = Calendar.getInstance();
        day_   = calendario.get(Calendar.DAY_OF_MONTH);
        month_ = calendario.get(Calendar.MONTH);
        year_  = calendario.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                eDatePicker.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },day_,month_,year_);
        datePickerDialog.show();
    }

    private void finishOrNot(){
        if(TextUtils.isEmpty(usuario)){
            flagFinish1 = false;
        }else if(TextUtils.isEmpty(pass1)){
            flagFinish1 = false;
        }else if(TextUtils.isEmpty(pass2)){
            flagFinish1 = false;
        }else if(TextUtils.isEmpty(email)){
            flagFinish1 = false;
        }/*else if(!cCine.isChecked() && !cVideo.isChecked() && ){
            flagFinish1 = false;
        }else*/

        if(!flagFinish1){
            Toast.makeText(MainActivity.this, "Falta alguna casilla", Toast.LENGTH_SHORT).show();
        }
    }
}
