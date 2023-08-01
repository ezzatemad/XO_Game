package com.example.xogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btn_go = findViewById(R.id.btn_go);
        EditText et_name1 = findViewById(R.id.et_name1);
        EditText et_name2 = findViewById(R.id.et_name2);




        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this , MainActivity.class);
                intent.putExtra("name1",et_name1.getText().toString());
                intent.putExtra("name2",et_name2.getText().toString());
                startActivity(intent);
            }
        });
    }
}