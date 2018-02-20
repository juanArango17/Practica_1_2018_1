package com.programacionmoviles.juanpabloarangoa.formulario;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

    private String usuario,pass1,pass2,email,sexo,hobbies,fecha;
    private EditText eUser, ePass1, ePass2, eMail;
    private RadioButton rSexM, rSexF;
    private CheckBox cCine,cVideo,cNadar,cFutbol;
    private Spinner sCities;
    private Button bAceptar,bDate;
    private TextView tInfo;

    public String ciudad;
    public EditText eDatePicker;
    private int day_,month_,year_;


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
        cFutbol     = findViewById(R.id.cFutbol);
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
        if(rSexM.isChecked()) {
            sexo = getString(R.string.sexM);
        }else {
            sexo = getString(R.string.sexF);
        }
    }

    public void onButtonAceptar(View view) {
        String msg = getString(R.string.information)+"\n";
        usuario = eUser.getText().toString();
        pass1   = ePass1.getText().toString();
        pass2   = ePass2.getText().toString();
        email   = eMail.getText().toString();
        fecha   = eDatePicker.getText().toString();

        if(finishOrNot1()){
            if(!pass1.equals(pass2)){
                Toast.makeText(MainActivity.this, "Contraseñas diferentes", Toast.LENGTH_SHORT).show();
            }else{
                rearangeHobbies();
                msg += getString(R.string.name_)+ " " + usuario;   msg += "\n";
                msg += getString(R.string.password1)+ " " + pass1; msg += "\n";
                msg += getString(R.string.email)+ " " + email;     msg += "\n";
                msg += getString(R.string.sex)+ " " + sexo;        msg += "\n";
                msg += getString(R.string.date)+ " " + fecha;      msg += "\n";
                msg += getString(R.string.cities)+ " " + ciudad;   msg += "\n";
                msg += getString(R.string.hobbies)+ " " + hobbies;
                tInfo.setText(msg);
            }
        }
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

    private boolean finishOrNot1(){
        boolean flagFinish1;
        if(TextUtils.isEmpty(usuario) || TextUtils.isEmpty(pass1) || TextUtils.isEmpty(pass2) || TextUtils.isEmpty(email) || TextUtils.isEmpty(fecha)){
            flagFinish1 = false;
            Toast.makeText(MainActivity.this, "Falta alguna casilla por llenar", Toast.LENGTH_SHORT).show();
        }else if (!cCine.isChecked() && !cVideo.isChecked() && !cNadar.isChecked() && !cFutbol.isChecked()){
            Toast.makeText(MainActivity.this, "Falta seleccionar algún hobby", Toast.LENGTH_SHORT).show();
            flagFinish1 = false;
        }
        else{
            flagFinish1 = true;
        }
        return flagFinish1;
    }

    private void rearangeHobbies(){
        hobbies = getString(R.string.likesTo)+" ";
        if(cCine.isChecked())   { hobbies += getString(R.string.fraseCine);   hobbies += ", ";}
        if(cVideo.isChecked())  { hobbies += getString(R.string.fraseVideo);  hobbies += ", ";}
        if(cNadar.isChecked())  { hobbies += getString(R.string.fraseNadar);  hobbies += ", ";}
        if(cFutbol.isChecked()) { hobbies += getString(R.string.fraseFutbol);}
    }
}
