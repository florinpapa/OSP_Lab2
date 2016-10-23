package com.example.fpapa.lab2_florinpapa_sric2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final TextView t1 = (TextView) findViewById(R.id.textView2);
        final Intent i = getIntent();
        ListView lv = (ListView) findViewById(R.id.listView1);
        t1.setText(i.getStringExtra("mykey"));

        /* Task 2 */
//        List<MyMenuItem> items = new ArrayList<MyMenuItem>();
//        items.add(new MyMenuItem("Coffee", 6, "Simple black coffee"));
//        items.add(new MyMenuItem("Caffe latte", 7, "Coffee with milk"));
//        items.add(new MyMenuItem("Espresso", 7, "Simple espresso"));
//        items.add(new MyMenuItem("Caffe macchiatto", 8, "Espresso with foamed milk"));

//        MenuAdapter adapter = new MenuAdapter(this, items);
//        lv.setAdapter(adapter);

        /* Task 3 */
        List<MyMenuItem> items = new ArrayList<MyMenuItem>();

        Uri uri = Uri.parse(ItemsProvider.tableUri);
        String proj[] = {"name", "desc", "price"};
        String sel = null;
        String selArgs[] = {};
        String sortOrder = null;

        Cursor cursor = getContentResolver().query(uri, proj, sel, selArgs, sortOrder);
        if (cursor != null && cursor.getCount() >= 1) {
            while (cursor.moveToNext()) {
                items.add(new MyMenuItem(cursor.getString(0), cursor.getInt(2), cursor.getString(1)));
            }
        }

        MenuAdapter adapter = new MenuAdapter(this, items);
        lv.setAdapter(adapter);
    }
}
