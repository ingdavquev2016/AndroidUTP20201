package com.example.appcrudbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Acceso_ok extends AppCompatActivity {

    EditText txtCodigo,txtNombre,txtCelular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso_ok);

        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtCodigo = (EditText)findViewById(R.id.txtCodigo);
        txtCelular = (EditText)findViewById(R.id.txtCelular);
    }

    public void Registrar(View view) {

        dbHelper helper = new dbHelper(this,"contactos.sqllite",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();

        String valorCodigo = txtCodigo.getText().toString();
        String valorNombre = txtNombre.getText().toString();
        String valorCelular = txtCelular.getText().toString();

        if(!valorCodigo.isEmpty() && !valorNombre.isEmpty()  && !valorCelular.isEmpty() ){
            ContentValues registro = new ContentValues();
            registro.put("codigo",valorCodigo);
            registro.put("nombre",valorNombre);
            registro.put("celular",valorCelular);
            db.insert("contactos",null,registro);
            Toast.makeText(getApplicationContext(),"Registro exitoso",Toast.LENGTH_LONG).show();
            db.close();

            txtCodigo.setText("");
            txtNombre.setText("");
            txtCelular.setText("");
            txtCodigo.requestFocus();
        }
        else{
            Toast.makeText(getApplicationContext(),"Se debe ingresar todos los datos",Toast.LENGTH_LONG).show();
        }
    }

    public void Eliminar(View view)
    {
        dbHelper helper = new dbHelper(this,"contactos.sqllite",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();

        String valorCodigo = txtCodigo.getText().toString();
        if(!valorCodigo.isEmpty()  ){
            int cant = db.delete("contactos","codigo="+valorCodigo,null);
            db.close();

            txtCodigo.setText("");
            txtNombre.setText("");
            txtCelular.setText("");
            txtCodigo.requestFocus();

            if(cant==1) {
                Toast.makeText(getApplicationContext(), "Se elimino exitosamente", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "No existe la persona", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Debe ingresar el codigo de la persona", Toast.LENGTH_LONG).show();
        }
    }

    public void Buscar(View view) {
        dbHelper helper = new dbHelper(this,"contactos.sqllite",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();

        String valorCodigo = txtCodigo.getText().toString();
        if(!valorCodigo.isEmpty()  ) {
            Cursor fila = db.rawQuery ("select nombre,celular from contactos where codigo="+ valorCodigo,null);

            if(fila.moveToFirst())
            {
                txtNombre.setText(fila.getString(0));
                txtCelular.setText(fila.getString(1));
                db.close();
            }
            else{
                Toast.makeText(getApplicationContext(), "No existe la persona", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Debe ingresar el codigo de la persona", Toast.LENGTH_LONG).show();
        }
    }

    public void Modificar (View view)
    {
        dbHelper helper = new dbHelper(this,"contactos.sqllite",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();

        String valorCodigo = txtCodigo.getText().toString();
        String valorNombre = txtNombre.getText().toString();
        String valorCelular = txtCelular.getText().toString();

        if(!valorCodigo.isEmpty() && !valorNombre.isEmpty()  && !valorCelular.isEmpty() ){
            ContentValues registro = new ContentValues();
            registro.put("codigo",valorCodigo);
            registro.put("nombre",valorNombre);
            registro.put("celular",valorCelular);
            int cant = db.update ("contactos",registro,"codigo="+ valorCodigo,null);
            db.close();

            if(cant==1) {
                Toast.makeText(getApplicationContext(), "Se modifico exitosamente", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "No existe la persona", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"Se debe ingresar todos los datos",Toast.LENGTH_LONG).show();
        }
    }
}
