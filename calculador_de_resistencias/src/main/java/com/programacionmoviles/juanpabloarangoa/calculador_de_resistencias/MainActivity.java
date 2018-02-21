package com.programacionmoviles.juanpabloarangoa.calculador_de_resistencias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tFranja1, tFranja2, tFranja3, tFranja4;
    private Spinner  sFranja1, sFranja2, sFranja3, sFranja4;
    private String[] unidades = {"Ω","kΩ","MΩ","GΩ"};
    private String[] tolerancias = {"(±1%)","(±2%)","(±5%)","(±10%)"};
    private int[] comercial = {10,12,15,18,22,27,33,39,47,51,56,68,82};//[0-12]
    private TextView tResult;
    private int f1,f2,f3,ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tFranja1 = findViewById(R.id.tFranja1);
        tFranja2 = findViewById(R.id.tFranja2);
        tFranja3 = findViewById(R.id.tFranja3);
        tFranja4 = findViewById(R.id.tFranja4);

        sFranja1 = findViewById(R.id.sFranja1);
        sFranja2 = findViewById(R.id.sFranja2);
        sFranja3 = findViewById(R.id.sFranja3);
        sFranja4 = findViewById(R.id.sFranja4);

        tResult  = findViewById(R.id.tResult );

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.colores_valores, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.colores_tolerancias, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sFranja1.setAdapter(adapter1);
        sFranja1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                f1 = i;
                switch(i){
                    case 1:
                        tFranja1.setBackgroundColor(getResources().getColor(R.color.sienna)); break;
                    case 2:
                        tFranja1.setBackgroundColor(getResources().getColor(R.color.red)); break;
                    case 3:
                        tFranja1.setBackgroundColor(getResources().getColor(R.color.darkorange)); break;
                    case 4:
                        tFranja1.setBackgroundColor(getResources().getColor(R.color.yellow)); break;
                    case 5:
                        tFranja1.setBackgroundColor(getResources().getColor(R.color.green)); break;
                    case 6:
                        tFranja1.setBackgroundColor(getResources().getColor(R.color.blue)); break;
                    case 7:
                        tFranja1.setBackgroundColor(getResources().getColor(R.color.purple)); break;
                    case 8:
                        tFranja1.setBackgroundColor(getResources().getColor(R.color.gray)); break;
                    case 9:
                        tFranja1.setBackgroundColor(getResources().getColor(R.color.white)); break;
                    default:
                        tFranja1.setBackgroundColor(getResources().getColor(R.color.black)); break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sFranja2.setAdapter(adapter1);
        sFranja2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                f2 = i;
                switch(i){
                    case 1:
                        tFranja2.setBackgroundColor(getResources().getColor(R.color.sienna)); break;
                    case 2:
                        tFranja2.setBackgroundColor(getResources().getColor(R.color.red)); break;
                    case 3:
                        tFranja2.setBackgroundColor(getResources().getColor(R.color.darkorange)); break;
                    case 4:
                        tFranja2.setBackgroundColor(getResources().getColor(R.color.yellow)); break;
                    case 5:
                        tFranja2.setBackgroundColor(getResources().getColor(R.color.green)); break;
                    case 6:
                        tFranja2.setBackgroundColor(getResources().getColor(R.color.blue)); break;
                    case 7:
                        tFranja2.setBackgroundColor(getResources().getColor(R.color.purple)); break;
                    case 8:
                        tFranja2.setBackgroundColor(getResources().getColor(R.color.gray)); break;
                    case 9:
                        tFranja2.setBackgroundColor(getResources().getColor(R.color.white)); break;
                    default:
                        tFranja2.setBackgroundColor(getResources().getColor(R.color.black)); break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        sFranja3.setAdapter(adapter1);
        sFranja3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                f3 = i;
                switch(i){
                    case 1:
                        tFranja3.setBackgroundColor(getResources().getColor(R.color.sienna)); break;
                    case 2:
                        tFranja3.setBackgroundColor(getResources().getColor(R.color.red)); break;
                    case 3:
                        tFranja3.setBackgroundColor(getResources().getColor(R.color.darkorange)); break;
                    case 4:
                        tFranja3.setBackgroundColor(getResources().getColor(R.color.yellow)); break;
                    case 5:
                        tFranja3.setBackgroundColor(getResources().getColor(R.color.green)); break;
                    case 6:
                        tFranja3.setBackgroundColor(getResources().getColor(R.color.blue)); break;
                    case 7:
                        tFranja3.setBackgroundColor(getResources().getColor(R.color.purple)); break;
                    case 8:
                        tFranja3.setBackgroundColor(getResources().getColor(R.color.gray)); break;
                    case 9:
                        tFranja3.setBackgroundColor(getResources().getColor(R.color.white)); break;
                    default:
                        tFranja3.setBackgroundColor(getResources().getColor(R.color.black)); break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sFranja4.setAdapter(adapter2);
        sFranja4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ft = i;
                switch(i){
                    case 0:
                        tFranja4.setBackgroundColor(getResources().getColor(R.color.sienna)); break;
                    case 1:
                        tFranja4.setBackgroundColor(getResources().getColor(R.color.red)); break;
                    case 2:
                        tFranja4.setBackgroundColor(getResources().getColor(R.color.gold)); break;
                    case 3:
                        tFranja4.setBackgroundColor(getResources().getColor(R.color.lightslategray)); break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    public void onClickListener(View view) {
        String resultado = getString(R.string.result) + "\n";
        resultado += getString(R.string.msg1) + " ";
        switch(f3){
            case 0:
                resultado += String.valueOf(10*f1+f2) +" "+ unidades[0]; break;
            case 1:
                resultado += String.valueOf(10*(10*f1+f2)) +" "+ unidades[0]; break;
            case 2:
                resultado += String.valueOf(f1) +"."+ String.valueOf(f2) +" "+ unidades[1]; break;
            case 3:
                resultado += String.valueOf(10*f1+f2) +" "+ unidades[1]; break;
            case 4:
                resultado += String.valueOf(10*(10*f1+f2)) +" "+ unidades[1]; break;
            case 5:
                resultado += String.valueOf(f1) +"."+ String.valueOf(f2) +" "+ unidades[2]; break;
            case 6:
                resultado += String.valueOf(10*f1+f2) +" "+ unidades[2]; break;
            case 7:
                resultado += String.valueOf(10*(10*f1+f2)) +" "+ unidades[2]; break;
            case 8:
                resultado += String.valueOf(f1) +"."+ String.valueOf(f2) +" "+ unidades[3]; break;
            default:
                resultado += String.valueOf(10*f1+f2) +" "+ unidades[3];
        }
        resultado += "\n" + getString(R.string.msg2)+" ";
        resultado += tolerancias[ft]+".";

        resultado += lookComercialValue();

        tResult.setText(resultado);
    }
    private String lookComercialValue(){
        String msg = "\n\n"+getString(R.string.msg3)+" ";
        int value = 10*f1+f2, minComercial = 100, f1c,f2c;
        int i;
        for(i = 0; i <= 12; i += 1){
            if(absolute(comercial[i]-value) <= absolute(minComercial-value)){
                minComercial = comercial[i];
                /*
                Log.d("Valor Comercial ",String.valueOf(absolute(comercial[i]-value)));
                Log.d("minComercial",String.valueOf(minComercial));*/
            }
        }

        f1c = minComercial/10;
        f2c = minComercial%10;
        switch(f3){
            case 0:
                msg += String.valueOf(10*f1c+f2c) +" "+ unidades[0]; break;
            case 1:
                msg += String.valueOf(10*(10*f1c+f2c)) +" "+ unidades[0]; break;
            case 2:
                msg += String.valueOf(f1c) +"."+ String.valueOf(f2c) +" "+ unidades[1]; break;
            case 3:
                msg += String.valueOf(10*f1c+f2c) +" "+ unidades[1]; break;
            case 4:
                msg += String.valueOf(10*(10*f1c+f2c)) +" "+ unidades[1]; break;
            case 5:
                msg += String.valueOf(f1c) +"."+ String.valueOf(f2c) +" "+ unidades[2]; break;
            case 6:
                msg += String.valueOf(10*f1c+f2c) +" "+ unidades[2]; break;
            case 7:
                msg += String.valueOf(10*(10*f1c+f2c)) +" "+ unidades[2]; break;
            case 8:
                msg += String.valueOf(f1c) +"."+ String.valueOf(f2c) +" "+ unidades[3]; break;
            default:
                msg += String.valueOf(10*f1c+f2c) +" "+ unidades[3];
        }
        return msg;
    }
    private int absolute(int value){
        if(value<0){
            value *= -1;
        }
        return value;
    }
}
