package com.example.mohitkumar.simpledatabase.util;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohitkumar.simpledatabase.R;

/**
 * Created by mohitkumar on 15/08/16.
 */
public class addata extends Activity {

    Context context = this;
    SQLiteDatabase sqLiteDatabase;
    EditText name;
    EditText mobile;
    EditText email;
    Button save;
    UserDbhelper userDbhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data);
        name = (EditText) findViewById(R.id.name);
        mobile = (EditText)findViewById(R.id.Mobile);
        email = (EditText)findViewById(R.id.email);
        save = (Button)findViewById(R.id.save);
    }

    public void addone(View view)
    {
        String cname = name.getText().toString();
        String cmob = mobile.getText().toString();
        String cmail = email.getText().toString();
        userDbhelper = new UserDbhelper(context);
        sqLiteDatabase = userDbhelper.getWritableDatabase();
        userDbhelper.addinformation(cname,cmob,cmail,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"DAta SAved",Toast.LENGTH_SHORT).show();
        userDbhelper.close();
        finish();
    }
}
