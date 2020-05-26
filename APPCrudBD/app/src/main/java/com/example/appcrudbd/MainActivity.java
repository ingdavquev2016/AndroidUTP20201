package com.example.appcrudbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;
    EditText txtUsuario, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtPass = (EditText) findViewById(R.id.txtPass);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = txtUsuario.getText().toString();
                String pass = txtPass.getText().toString();

                if(usuario.equals("utp") && pass.equals("123"))
                {
                    Toast.makeText(getApplication(),"Acceso permitido", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getApplicationContext(),Acceso_ok.class);
                    startActivity(intent1);
                }
                else
                {
                    Toast.makeText(getApplication(),"Acceso denegado", Toast.LENGTH_LONG).show();
                    txtUsuario.setText("");
                    txtPass.setText("");
                    txtUsuario.requestFocus();
                }
            }
        });
    }
}
