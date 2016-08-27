package com.example.mohitkumar.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int[] moviesposter = {R.drawable.ridealong,R.drawable.deadpool,R.drawable.bvs,R.drawable.jbook,
                            R.drawable.civilwar,R.drawable.xmen,R.drawable.suicide
    ,R.drawable.drstrange,R.drawable.starwars};
    String[] movie_titles;
    String[] movie_ratings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        movie_titles = getResources().getStringArray(R.array.movies);
        movie_ratings = getResources().getStringArray(R.array.RATINGS);
        Movieadapter movieadapter = new Movieadapter(getApplicationContext(),R.layout.customlayout);
        listView.setAdapter(movieadapter);
        for(int i=0;i<moviesposter.length;i++)
        {
            Moviedata moviedata = new Moviedata(moviesposter[i],movie_titles[i],movie_ratings[i]);
            movieadapter.add(moviedata);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
