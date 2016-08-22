package com.example.mohitkumar.simpledatabase.util;

import android.content.ContentValues;
import android.content.Context;
import android.content.SyncRequest;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mohitkumar on 15/08/16.
 */
public class UserDbhelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION  = 1;
    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final String CREATE_QUERY = "CREATE TABLE " + Usercontract.newinfo.TABLENAME + "("+ Usercontract.newinfo.USERNAME +
            " TEXT,"+Usercontract.newinfo.MOBILE + " TEXT," + Usercontract.newinfo.EMAIL + " TEXT);";

    public UserDbhelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Database created/opened...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Database added");

    }

    public void addinformation(String name,String mob,String email,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Usercontract.newinfo.USERNAME,name);
        contentValues.put(Usercontract.newinfo.MOBILE,mob);
        contentValues.put(Usercontract.newinfo.EMAIL,email);
        db.insert(Usercontract.newinfo.TABLENAME,null,contentValues);
        Log.e("DATABASE OPERATIONS","One row is inserted");
    }

    public Cursor retrievecusrsor(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projection = {Usercontract.newinfo.USERNAME,Usercontract.newinfo.MOBILE,Usercontract.newinfo.EMAIL};

        cursor =  db.query(Usercontract.newinfo.TABLENAME,projection,null,null,null,null,null);
        return cursor;
    }

    public Cursor search(String user_name,SQLiteDatabase db)
    {
        String[] projection = {Usercontract.newinfo.MOBILE,Usercontract.newinfo.EMAIL};
        String selection = Usercontract.newinfo.USERNAME + " LIKE ?";
        String[] selection_args = {user_name};
        Cursor cursor = db.query(Usercontract.newinfo.TABLENAME,projection,selection,selection_args,null,null,null);
        return cursor;
    }

    public void deleteinfo(String user_name,SQLiteDatabase db)
    {
        String selection = Usercontract.newinfo.USERNAME + " LIKE ?";
        String[] projection = {Usercontract.newinfo.USERNAME,Usercontract.newinfo.MOBILE,Usercontract.newinfo.EMAIL};
        String[] selection_args = {user_name};
        db.delete(Usercontract.newinfo.TABLENAME,selection,selection_args);
    }

    public int updateinfo(String old_name,String new_n,String new_m,String new_e,SQLiteDatabase db)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(Usercontract.newinfo.USERNAME,new_n);
        contentvalues.put(Usercontract.newinfo.MOBILE,new_m);
        contentvalues.put(Usercontract.newinfo.EMAIL,new_e);
        String selection = Usercontract.newinfo.USERNAME + " LIKE ?";
        String[] selection_args = {old_name};
        int n = db.update(Usercontract.newinfo.TABLENAME,contentvalues,selection,selection_args);
        return n;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
