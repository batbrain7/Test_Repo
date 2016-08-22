package com.example.mohitkumar.simpledatabase.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mohitkumar.simpledatabase.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohitkumar on 15/08/16.
 */
public class listadapter extends ArrayAdapter{

    List list = new ArrayList();

    public listadapter(Context context, int resource) {
        super(context, resource);
    }

    static class Layouthandler
    {
        TextView NAME,MOBILE,EMAIL;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        Layouthandler layouthandler;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.customlayout,parent,false);
            layouthandler = new Layouthandler();
            layouthandler.NAME = (TextView) row.findViewById(R.id.name1);
            layouthandler.EMAIL = (TextView) row.findViewById(R.id.email1);
            layouthandler.MOBILE = (TextView) row.findViewById(R.id.mob1);
            row.setTag(layouthandler);
        }
        else
        {
            layouthandler = (Layouthandler) row.getTag();

        }
        Dataprovider dataprovider = (Dataprovider) this.getItem(position);
        layouthandler.NAME.setText(dataprovider.getName().toString());
        layouthandler.EMAIL.setText(dataprovider.getEmail().toString());
        layouthandler.MOBILE.setText(dataprovider.getMobile().toString());
        return row;
    }
}
