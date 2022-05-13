package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText name, password;
    Button button, update, remove;
    dbfirebase dbfirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);
        update = findViewById(R.id.update);
        remove = findViewById(R.id.remove);
        dbfirebase = new dbfirebase();
        button.setOnClickListener(v -> {
            Register r = new Register(name.getText().toString(), password.getText().toString());
            dbfirebase.add(r).addOnSuccessListener(suc -> {
                Toast.makeText(this, "Record inserted successfully", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, "Sorry" + er.getMessage(), Toast.LENGTH_SHORT).show();
            });

        });
        update.setOnClickListener(v -> {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("name", name.getText().toString());
            hashMap.put("password", password.getText().toString());
            dbfirebase.update("-My6FxXExLKoXzr7qaOt", hashMap).addOnSuccessListener(suc -> {
                Toast.makeText(this, "Record Updated successfully", Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er -> {
                Toast.makeText(this, "Not updated" + er.getMessage(), Toast.LENGTH_SHORT).show();

            });
        });

        remove.setOnClickListener(v -> {

            dbfirebase.remove("-My6FxXExLKoXzr7qaOt").addOnSuccessListener(suc -> {
                Toast.makeText(this, "Record Deleted successfully", Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er -> {
                Toast.makeText(this, "Not deleted" + er.getMessage(), Toast.LENGTH_SHORT).show();

            });
        });
    }
}