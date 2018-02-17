package com.programacionmoviles.juanpabloarangoa.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editor;

    Button bOne,bTwo,bThree,bFour,bFive,bSix,bSeven,bEight,bNine,bZero;
    Button bPlus,bMinus,bMulti,bDiv;
    Button bDot,bEqual;
    boolean flagDot = false,flagClean=false;
    int operacion = 0;
    double operando1,operando2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editor = findViewById(R.id.editor);

        bOne   = findViewById(R.id.bOne);
        bTwo   = findViewById(R.id.bTwo);
        bThree = findViewById(R.id.bThree);
        bFour  = findViewById(R.id.bFour);
        bFive  = findViewById(R.id.bFive);
        bSix   = findViewById(R.id.bSix);
        bSeven = findViewById(R.id.bSeven);
        bEight = findViewById(R.id.bEight);
        bNine  = findViewById(R.id.bNine);
        bZero  = findViewById(R.id.bZero);
        bPlus  = findViewById(R.id.bPlus);
        bMinus = findViewById(R.id.bMinus);
        bMulti = findViewById(R.id.bMulti);
        bDiv   = findViewById(R.id.bDiv);
        bDot   = findViewById(R.id.bDot);
        bEqual = findViewById(R.id.bEqual);
    }

    public void buttonNumber(View view){
        if(flagClean){
            flagClean = false;
            editor.setText("");
        }

        switch(view.getId()){
            case R.id.bZero:
                editor.setText(editor.getText().toString()+"0"); break;
            case R.id.bOne:
                editor.setText(editor.getText().toString()+"1"); break;
            case R.id.bTwo:
                editor.setText(editor.getText().toString()+"2"); break;
            case R.id.bThree:
                editor.setText(editor.getText().toString()+"3"); break;
            case R.id.bFour:
                editor.setText(editor.getText().toString()+"4"); break;
            case R.id.bFive:
                editor.setText(editor.getText().toString()+"5"); break;
            case R.id.bSix:
                editor.setText(editor.getText().toString()+"6"); break;
            case R.id.bSeven:
                editor.setText(editor.getText().toString()+"7"); break;
            case R.id.bEight:
                editor.setText(editor.getText().toString()+"8"); break;
            case R.id.bNine:
                editor.setText(editor.getText().toString()+"9"); break;
        }
    }
    public void buttonDot(View view)   {
        if(flagClean){
            flagClean=false;
            editor.setText("");
        }
        if(!flagDot) {
            editor.setText(editor.getText().toString() + ".");
            flagDot = true;
        }
    }

    public void buttonOperation(View view) {
        if(operacion == 0) {
            operacion = view.getId();
            flagDot = false;
            operando1 = Double.parseDouble(editor.getText().toString());
            editor.setText("");
            switch (operacion) {
                case R.id.bPlus:
                    bPlus.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case R.id.bMinus:
                    bMinus.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case R.id.bMulti:
                    bMulti.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case R.id.bDiv:
                    bDiv.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
            }
        }
    }
    public void buttonEqual(View view) {
        try{
            operando2 = Double.parseDouble(editor.getText().toString());
            switch(operacion) {
                case R.id.bPlus:
                    editor.setText(String.valueOf(operando1+operando2));
                    break;
                case R.id.bMinus:
                    editor.setText(String.valueOf(operando1-operando2));
                    break;
                case R.id.bMulti:
                    editor.setText(String.valueOf(operando1*operando2));
                    break;
                case R.id.bDiv:
                    if(operando2==0.0){
                        editor.setText("");
                        Toast.makeText(MainActivity.this, "ERROR: divisor nulo", Toast.LENGTH_SHORT).show();
                    }else{
                        editor.setText(String.valueOf(operando1/operando2));
                    }
                    break;
                default:
                    Toast.makeText(MainActivity.this, "ERROR: falta ingresar operación", Toast.LENGTH_SHORT).show();
            }
            operacion = 0;
            operando1 = 0.0;
            operando2 = 0.0;
            flagDot   = false;
            flagClean = true;
            bPlus.setBackgroundColor(getResources().getColor(R.color.limegreen));
            bMinus.setBackgroundColor(getResources().getColor(R.color.limegreen));
            bMulti.setBackgroundColor(getResources().getColor(R.color.limegreen));
            bDiv.setBackgroundColor(getResources().getColor(R.color.limegreen));
        }catch (NumberFormatException f){
            Toast.makeText(MainActivity.this, "ERROR: falta ingresar operación y/o operandos", Toast.LENGTH_SHORT).show();
        }
    }
}
