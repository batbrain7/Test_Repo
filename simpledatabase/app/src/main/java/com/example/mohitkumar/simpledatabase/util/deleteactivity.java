package com.example.mohitkumar.simpledatabase.util;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohitkumar.simpledatabase.R;

public class deleteactivity extends AppCompatActivity {

    EditText editText;
    Button button;
    UserDbhelper userDbhelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteactivity);
        editText = (EditText)findViewById(R.id.nameZZ);
        button = (Button)findViewById(R.id.dele);
    }

    public void deleted(View view)
    {
        String name = editText.getText().toString();
        userDbhelper = new UserDbhelper(getApplicationContext());
        sqLiteDatabase = userDbhelper.getReadableDatabase();
        userDbhelper.deleteinfo(name,sqLiteDatabase);
        Toast.makeText(getBaseContext(),name + "'s data deleted",Toast.LENGTH_SHORT).show();
        finish();
    }
}
