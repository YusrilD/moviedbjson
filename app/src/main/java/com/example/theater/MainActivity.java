package com.example.theater;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.theater.utilities.NetworkUtils;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.indeterminateBar)
    ProgressBar progressBar;
    String popularMoviesURL;
    String topRatedMoviesURL;
    GridView mGridView;

    ArrayList<Movies> mPopularList;
    ArrayList<Movies> mTopTopRatedList;

    final String myApiKey = "da3a044ca912fa768bd44195da7299f2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGridView = findViewById(R.id.pop_movies_grid);

        ButterKnife.bind(this);
        progressBar.setVisibility(View.INVISIBLE);
        new FetchMovies().execute();
    }

    public class FetchMovies extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {


            popularMoviesURL = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=" + myApiKey;
            topRatedMoviesURL = "http://api.themoviedb.org/3/discover/movie?sort_by=vote_average.desc&api_key=" + myApiKey;

            mPopularList = new ArrayList<>();
            mTopTopRatedList = new ArrayList<>();

            try {
                if (NetworkUtils.networkStatus(MainActivity.this)) {
                    mPopularList = NetworkUtils.fetchData(popularMoviesURL); //Get popular movies
                    mTopTopRatedList = NetworkUtils.fetchData(topRatedMoviesURL); //Get top rated movies
                } else {
                    Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.pop_movies) {
            refreshList(mPopularList);
        }
        if (id == R.id.top_movies) {
            refreshList(mTopTopRatedList);
        }
        return super.onOptionsItemSelected(item);
    }

    private void refreshList(ArrayList<Movies> list) {
        MovieAdapter adapter = new MovieAdapter(MainActivity.this, list);
        mGridView.invalidateViews();
        mGridView.setAdapter(adapter);
    }
}
