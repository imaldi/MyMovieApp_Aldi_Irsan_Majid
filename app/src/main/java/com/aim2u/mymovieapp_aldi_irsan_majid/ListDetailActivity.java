package com.aim2u.mymovieapp_aldi_irsan_majid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ListDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tvTitle, tvDesc;
    ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvDesc = findViewById(R.id.tvDesc);
        ivPoster = findViewById(R.id.ivMovie);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        tvTitle.setText(movie.getTitle());
        tvDesc.setText(movie.getDescription());
        ivPoster.setImageResource(movie.getPoster());
    }
}
