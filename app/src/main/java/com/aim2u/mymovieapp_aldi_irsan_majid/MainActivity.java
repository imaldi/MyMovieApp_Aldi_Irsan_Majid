package com.aim2u.mymovieapp_aldi_irsan_majid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] judulFilm; /*= {"Iron Man","Black Panther","Doctor Strange", "Ant Man","Thor","Guardian of Galaxy"};*/
    private String[] deskripsiFilm;
    private TypedArray dataPoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,judulFilm);
        adapter = new MovieAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, movies.get(i).getTitle(),Toast.LENGTH_SHORT).show();
                Movie movie = new Movie();
                movie.setTitle(movies.get(i).getTitle());
                movie.setDescription(movies.get(i).getDescription());
                movie.setPoster(movies.get(i).getPoster());

                Intent moveToDetail = new Intent(MainActivity.this,ListDetailActivity.class);
                moveToDetail.putExtra(ListDetailActivity.EXTRA_MOVIE,movie);
                startActivity(moveToDetail);
            }
        });
    }

    private void addItem() {
        movies = new ArrayList<>();

        for(int i = 0; i<judulFilm.length;i++){
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i,-1));
            movie.setTitle(judulFilm[i]);
            movie.setDescription(deskripsiFilm[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }

    private void prepare() {
        judulFilm = getResources().getStringArray(R.array.judul_film);
        deskripsiFilm = getResources().getStringArray(R.array.deskripsi_film);
        dataPoster = getResources().obtainTypedArray(R.array.data_photo);
    }
}
