package com.necomplus.mvvm.lastfm.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.necomplus.mvvm.lastfm.R;
import com.necomplus.mvvm.lastfm.adapter.TracksAdapter;
import com.necomplus.mvvm.lastfm.model.track.Track;
import com.necomplus.mvvm.lastfm.view_model.TracksViewModel;

import java.util.ArrayList;
import java.util.List;

public class TrackActivity extends AppCompatActivity {

    private static final String TAG = TrackActivity.class.getSimpleName();
    private RecyclerView my_recycler_view;
    private ProgressBar progress_circular_movie_article;
    private LinearLayoutManager layoutManager;
    private TracksAdapter adapter;
    private String nameArtist = "";
    private ArrayList<Track> tracksArrayList = new ArrayList<Track>();
    TracksViewModel tracksViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracks_main);
        intent();
        initialization();
        getTracks();
    }

    private void intent(){
        Intent intent = getIntent();

        nameArtist    = intent.getStringExtra("name");
        String tvplaycount   = intent.getStringExtra("playcount");
        String tvurl  = intent.getStringExtra("url");

        TextView tv_name = findViewById(R.id.tvname);
        TextView tv_playcount = findViewById(R.id.tvplaycount);
        TextView tv_url = findViewById(R.id.tvurl);

        tv_name.setText(nameArtist);
        tv_playcount.setText(tvplaycount);
        tv_url.setText(tvurl);
    }

    private void initialization() {
        progress_circular_movie_article = (ProgressBar) findViewById(R.id.progress_circular_movie_article);
        my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(TrackActivity.this);
        my_recycler_view.setLayoutManager(layoutManager);
        my_recycler_view.setHasFixedSize(true);
        adapter = new TracksAdapter(TrackActivity.this, tracksArrayList);
        my_recycler_view.setAdapter(adapter);
        tracksViewModel = ViewModelProviders.of(this).get(TracksViewModel.class);
    }

    private void getTracks() {

        tracksViewModel.getTrackResponseLiveData(nameArtist).observe(this, tracksResponse -> {
            if (tracksResponse != null) {
                progress_circular_movie_article.setVisibility(View.GONE);
                List<Track> tracks =  tracksResponse;
                tracksArrayList.addAll(tracks);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
