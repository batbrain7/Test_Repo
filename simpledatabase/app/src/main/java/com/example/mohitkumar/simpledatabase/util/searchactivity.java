package com.example.mohitkumar.simpledatabase.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mohitkumar.simpledatabase.R;

public class searchactivity extends AppCompatActivity {

    EditText searchit;
    Button button;
    TextView dispmob;
    TextView dispemail;
    SQLiteDatabase sqLiteDatabase;
    UserDbhelper userDbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchactivity);
        searchit = (EditText)findViewById(R.id.searchname);
        dispmob = (TextView)findViewById(R.id.search_mobile);
        dispemail = (TextView)findViewById(R.id.search_email);
        button = (Button)findViewById(R.id.search_but);
        dispmob.setVisibility(View.GONE);
        dispemail.setVisibility(View.GONE);
    }

    public void searchcontact(View view)
    {
        String searchname = searchit.getText().toString();
        userDbhelper = new UserDbhelper(getApplicationContext());
        sqLiteDatabase = userDbhelper.getReadableDatabase();
        Cursor cursor = userDbhelper.search(searchname,sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            String mobile = cursor.getString(0);
            String email = cursor.getString(1);
            dispmob.setText(mobile);
            dispemail.setText(email);
            dispmob.setVisibility(View.VISIBLE);
            dispemail.setVisibility(View.VISIBLE);
        }

    }

}
