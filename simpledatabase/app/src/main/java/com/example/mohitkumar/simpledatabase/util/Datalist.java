package com.example.mohitkumar.simpledatabase.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mohitkumar.simpledatabase.R;

public class Datalist extends AppCompatActivity {

    ListView listView;
    UserDbhelper userDbhelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    listadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datalist);
        listView = (ListView)findViewById(R.id.list1);
        adapter = new listadapter(getApplicationContext(),R.layout.customlayout);
        listView.setAdapter(adapter);
        userDbhelper = new UserDbhelper(getApplicationContext());
        sqLiteDatabase = userDbhelper.getReadableDatabase();
        cursor = userDbhelper.retrievecusrsor(sqLiteDatabase);
        if (cursor.moveToFirst())
        {
            do{
                String name = cursor.getString(0);
                String mobile = cursor.getString(1);
                String email = cursor.getString(2);
                Dataprovider dataprovider = new Dataprovider(name,mobile,email);
                adapter.add(dataprovider);

            }while (cursor.moveToNext());
        }

    }
}
