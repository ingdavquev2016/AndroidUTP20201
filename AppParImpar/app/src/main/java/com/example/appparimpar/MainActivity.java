package com.example.appparimpar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvRpta;
    EditText etNumero;
    Button btnParImpar, btnLimpiar, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRpta = (TextView) findViewById(R.id.tvRpta);
        etNumero = (EditText) findViewById(R.id.etNumero);
        btnParImpar = (Button) findViewById(R.id.btnParImpar);
        btnLimpiar = (Button) findViewById(R.id.btnLimpar);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        btnParImpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(etNumero.getText().toString());

                //logica de mi prg
                if (num % 2 == 0){
                    tvRpta.setText("El numero "+num+" es PAR!!!");
                }
                else{
                    tvRpta.setText("El numero "+num+" es IMPAR!!!");
                }

                //aqui determino con un Toast
                if (num >= 10){
                    Toast.makeText(getApplicationContext(), "Numero >= 10", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Numero < 10", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumero.setText("");
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
                //finish();
            }
        });

    }
}
