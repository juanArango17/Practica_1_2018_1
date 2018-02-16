package com.programacionmoviles.juanpabloarangoa.figurasgeometricas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rCuadrado, rCirculo, rTriangulo, rCubo;
    EditText editor1, editor2;
    Button bCalcular;
    TextView tArea, tPerimetro, tVolumen, tVolumenLabel;
    int checkedID = R.id.rCuadrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rCuadrado     = findViewById(R.id.rCuadrado);
        rCirculo      = findViewById(R.id.rCirculo);
        rTriangulo    = findViewById(R.id.rTriangulo);
        rCubo         = findViewById(R.id.rCubo);
        editor1       = findViewById(R.id.editor1);
        editor2       = findViewById(R.id.editor2);
        bCalcular     = findViewById(R.id.bCalcular);
        tArea         = findViewById(R.id.tArea);
        tPerimetro    = findViewById(R.id.tPerimetro);
        tVolumen      = findViewById(R.id.tVolumen);
        tVolumenLabel = findViewById(R.id.tVolumenLabel);

    }

    public void selectionFigureClicked(View view) {
        checkedID = view.getId();
        switch (checkedID){
            case R.id.rCuadrado:
                editor1.setHint(getString(R.string.lado));
                editor2.setVisibility(View.INVISIBLE);
                tVolumen.setVisibility(View.INVISIBLE);
                tVolumenLabel.setVisibility(View.INVISIBLE);
                tArea.setText("0.0");
                tPerimetro.setText("0.0");
                tVolumen.setText("0.0");
                break;
            case R.id.rCirculo:
                editor1.setHint(getString(R.string.radio));
                editor2.setVisibility(View.INVISIBLE);
                tVolumen.setVisibility(View.INVISIBLE);
                tVolumenLabel.setVisibility(View.INVISIBLE);
                tArea.setText("0.0");
                tPerimetro.setText("0.0");
                tVolumen.setText("0.0");
                break;
            case R.id.rTriangulo:
                editor1.setHint(getString(R.string.base));
                editor2.setVisibility(View.VISIBLE);
                tVolumen.setVisibility(View.INVISIBLE);
                tVolumenLabel.setVisibility(View.INVISIBLE);
                tArea.setText("0.0");
                tPerimetro.setText("0.0");
                tVolumen.setText("0.0");
                break;
            case R.id.rCubo:
                editor1.setHint(getString(R.string.arista));
                editor2.setVisibility(View.INVISIBLE);
                tVolumen.setVisibility(View.VISIBLE);
                tVolumenLabel.setVisibility(View.VISIBLE);
                tArea.setText("0.0");
                tPerimetro.setText("0.0");
                tVolumen.setText("0.0");
                break;
        }
    }

    public void onButtonCalcular(View view) {
        switch (checkedID){
            case R.id.rCuadrado:
                try {
                    double ladoValue = Double.parseDouble(editor1.getText().toString());
                    tArea.setText(String.valueOf(ladoValue*ladoValue));
                    tPerimetro.setText(String.valueOf(4*ladoValue));
                }catch (NumberFormatException f) {
                    Toast.makeText(MainActivity.this, "Faltan Parametros", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rCirculo:
                try {
                    double radioValue = Double.parseDouble(editor1.getText().toString());
                    tArea.setText(String.valueOf(3.1416*radioValue*radioValue));
                    tPerimetro.setText(String.valueOf(2*3.1416*radioValue));
                }catch (NumberFormatException f) {
                    Toast.makeText(MainActivity.this, "Faltan Parametros", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rTriangulo:
                try {
                    double baseValue   = Double.parseDouble(editor1.getText().toString());
                    double alturaValue = Double.parseDouble(editor2.getText().toString());
                    tArea.setText(String.valueOf(baseValue*alturaValue/2.0));
                    tPerimetro.setText(String.valueOf(Math.sqrt(Math.pow(baseValue,2)+Math.pow(alturaValue,2))+baseValue+alturaValue));
                }catch (NumberFormatException f) {
                    Toast.makeText(MainActivity.this, "Faltan Parametros", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rCubo:
                try {
                    double aristaValue = Double.parseDouble(editor1.getText().toString());
                    tArea.setText(String.valueOf(6*aristaValue*aristaValue));
                    tPerimetro.setText(String.valueOf(12*aristaValue));
                    tVolumen.setText(String.valueOf(aristaValue*aristaValue*aristaValue));
                }catch (NumberFormatException f) {
                    Toast.makeText(MainActivity.this, "Faltan Parametros", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
