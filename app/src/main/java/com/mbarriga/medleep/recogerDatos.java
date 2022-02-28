package com.mbarriga.medleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class recogerDatos extends AppCompatActivity {

    private EditText edtHR,edtSueno;
    Button enviar;
    SharedPreferences.Editor editor;
    SharedPreferences datosdiarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoger_datos);
        edtHR = findViewById(R.id.edtHR);
        edtSueno = findViewById(R.id.edtSueno);
        enviar = findViewById(R.id.enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recogerDatos();
                Intent intent = new Intent(recogerDatos.this, Main.class);
                startActivity(intent);
            }
        });



    }

    public void recogerDatos(){
        datosdiarios = getSharedPreferences("datosdiarios", Context.MODE_PRIVATE);
        editor = datosdiarios.edit();
        editor.putString("HR", edtHR.getText().toString());
        editor.putString("sueno", edtSueno.getText().toString());
        editor.commit();
    }
}