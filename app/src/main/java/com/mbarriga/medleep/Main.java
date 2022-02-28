package com.mbarriga.medleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    TextView tvHR,tvSueno,tvMensajeAlerta;
    LinearLayout linearLayout;
    SharedPreferences.Editor editor;
    SharedPreferences datosdiarios;
    String hr,sueno;
    int hrInt,suenoInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHR = findViewById(R.id.tvHR);
        tvSueno = findViewById(R.id.tvSueno);
        tvMensajeAlerta = findViewById(R.id.tvMensajeAlerta);
        linearLayout = findViewById(R.id.linearLayout);

        cargardatos();


        if(hrInt < 40 ){
            if(suenoInt < 7){
                tvMensajeAlerta.setText("Ten cuidado, Tus pulsaciones medias son mas bajas que la media (40/50)y has dormido poco.\n   Si experimenta alguna molestia, acuda a un doctor.");
                linearLayout.setBackgroundColor(getResources().getColor(R.color.rojo));
            }else{
                tvMensajeAlerta.setText("Ten cuidado, Tus pulsaciones medias son mas bajas que la media (40/50)\n Si experimenta alguna molestia, acuda a un doctor.");
                linearLayout.setBackgroundColor(getResources().getColor(R.color.naranja));
            }

        }else if(hrInt > 50 ){
            if(suenoInt < 7){
                tvMensajeAlerta.setText("Ten cuidado, Tus pulsaciones medias son mas altas que la media (40/50) y has dormido poco.\n Si experimenta alguna molestia, acuda a un doctor.");
                linearLayout.setBackgroundColor(getResources().getColor(R.color.rojo));
            }else{
                tvMensajeAlerta.setText("Ten cuidado, Tus pulsaciones medias son mas altas que la media (40/50).\n  Si experimenta alguna molestia, acuda a un doctor.");
                linearLayout.setBackgroundColor(getResources().getColor(R.color.naranja));
            }

        }else{
            if(suenoInt < 7){
                tvMensajeAlerta.setText("Tus pulsaciones estan dentro de la media, pero has dormido poco. \n Intenta irte a dormir pronto.");
                linearLayout.setBackgroundColor(getResources().getColor(R.color.naranja));
            }else{
                tvMensajeAlerta.setText("!Genial! \n Tus pulsaciones y horas de sueño estan dentro de la media ;)");
                linearLayout.setBackgroundColor(getResources().getColor(R.color.verde));
            }

        }


    }


    private void cargardatos(){
        datosdiarios = getSharedPreferences("datosdiarios", Context.MODE_PRIVATE);
        hr = datosdiarios.getString("HR","no hay info");
        sueno = datosdiarios.getString("sueno","no hay info");

        hrInt =  Integer.valueOf(hr);
        suenoInt =  Integer.valueOf(sueno);

        tvHR.setText(String.valueOf(hrInt));
        tvSueno.setText(String.valueOf(suenoInt));



       // tvHR.setText(datosdiarios.getString("HR","no hay info"));
       // tvSueno.setText(datosdiarios.getString("sueno","no hay info"));
    }
}