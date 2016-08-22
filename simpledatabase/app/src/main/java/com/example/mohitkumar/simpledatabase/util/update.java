package com.example.mohitkumar.simpledatabase.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohitkumar.simpledatabase.R;

public class update extends AppCompatActivity {

    EditText sname,newname,newmob,newmail;
    Button search,update;
    UserDbhelper userDbhelper;
    SQLiteDatabase sqLiteDatabase;
    String new_mobile,new_name,new_email,searchname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        sname = (EditText)findViewById(R.id.sname);
        newname = (EditText)findViewById(R.id.newname1);
        newmob = (EditText)findViewById(R.id.newmobile);
        newmail = (EditText)findViewById(R.id.newemail);
        search = (Button)findViewById(R.id.ss);
        update = (Button)findViewById(R.id.update);
        newname.setVisibility(View.GONE);
        newmob.setVisibility(View.GONE);
        newmail.setVisibility(View.GONE);
        update.setVisibility(View.GONE);
    }

    public void searched(View view)
    {
        searchname = sname.getText().toString();
        userDbhelper = new UserDbhelper(getApplicationContext());
        sqLiteDatabase = userDbhelper.getReadableDatabase();
        Cursor cursor = userDbhelper.search(searchname,sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            new_mobile = cursor.getString(0);
            new_email = cursor.getString(1);
            new_name = searchname;
            newname.setText(new_name);
            newmob.setText(new_mobile);
            newmail.setText(new_email);
            newname.setVisibility(View.VISIBLE);
            newmob.setVisibility(View.VISIBLE);
            newmail.setVisibility(View.VISIBLE);
            update.setVisibility(View.VISIBLE);
        }
    }

    public void updateit(View view)
    {
        userDbhelper = new UserDbhelper(getApplicationContext());
        sqLiteDatabase = userDbhelper.getWritableDatabase();
        String name,email,mobile;
        name = newname.getText().toString();
        mobile = newmob.getText().toString();
        email = newmail.getText().toString();
       int count =  userDbhelper.updateinfo(searchname,name,mobile,email,sqLiteDatabase);
        Toast.makeText(getBaseContext(),count + "contact updated",Toast.LENGTH_SHORT).show();
        finish();
    }
}
