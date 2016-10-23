package com.example.fpapa.lab2_florinpapa_sric2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText t1 = (EditText) findViewById(R.id.editText);
        final Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtra("mykey", t1.getText().toString());
                startActivity(i);
            }
        });

        final Button b2 = (Button) findViewById(R.id.button2);
        final EditText name = (EditText) findViewById(R.id.editText2);
        final EditText desc = (EditText) findViewById(R.id.editText3);
        final EditText price = (EditText) findViewById(R.id.editText4);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("name", name.getText().toString());
                cv.put("desc", desc.getText().toString());
                cv.put("price", Integer.parseInt(price.getText().toString()));

                Uri uri = getContentResolver().insert(Uri.parse(ItemsProvider.tableUri), cv);
                Log.d("[ndk][lab2]","Result of adding new item: " + uri.toString());
            }
        });
    }
}
