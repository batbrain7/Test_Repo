package com.example.mohitkumar.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohitkumar on 09/08/16.
 */

public class Movieadapter extends ArrayAdapter {

    List list = new ArrayList();

    public Movieadapter(Context context, int resource) {
        super(context, resource);
    }

    static class data
    {
        ImageView poster;
        TextView movie;
        TextView rating;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        data d;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.customlayout,parent,false);
            d = new data();
            d.poster = (ImageView) row.findViewById(R.id.img);
            d.movie = (TextView) row.findViewById(R.id.title1);
            d.rating = (TextView)row.findViewById(R.id.rating);
            row.setTag(d);
        }
        else {
            d = (data)row.getTag();
        }

        Moviedata moviedata = (Moviedata) this.getItem(position);
        d.poster.setImageResource(moviedata.getMovieposter());
        d.movie.setText(moviedata.getMovie_title());
        d.rating.setText(moviedata.getMovie_rating());
        return row;
    }
}