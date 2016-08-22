package com.example.mohitkumar.simpledatabase.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mohitkumar.simpledatabase.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void adds(View view)
    {
        Intent intent = new Intent(MainActivity.this,addata.class);
        startActivity(intent);
    }

    public void viewlist(View view)
    {
        Intent intent = new Intent(MainActivity.this,Datalist.class);
        startActivity(intent);
    }

    public void searchbyname(View view)
    {
        Intent intent = new Intent(this,searchactivity.class);
        startActivity(intent);
    }

    public void deletecon(View view)
    {
        Intent intent = new Intent(this,deleteactivity.class);
        startActivity(intent);
    }

    public void updation(View view)
    {
        Intent intent = new Intent(this,update.class);
        startActivity(intent);
    }
}
