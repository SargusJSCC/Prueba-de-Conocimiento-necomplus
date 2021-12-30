package com.necomplus.mvvm.lastfm.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.necomplus.mvvm.lastfm.R;
import com.necomplus.mvvm.lastfm.adapter.ArtitsAdapter;
import com.necomplus.mvvm.lastfm.model.Top.Artist;
import com.necomplus.mvvm.lastfm.view_model.ArtistsViewModel;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress_circular_movie_article;
    private ArtitsAdapter adapter;
    private ArrayList<Artist> artistsArrayList = new ArrayList<Artist>();
    ArtistsViewModel artistsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        getArtists();
    }

    private void initialization() {
        progress_circular_movie_article = (ProgressBar) findViewById(R.id.progress_circular_movie_article);
        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        my_recycler_view.setLayoutManager(layoutManager);
        my_recycler_view.setHasFixedSize(true);
        adapter = new ArtitsAdapter(MainActivity.this, artistsArrayList);
        my_recycler_view.setAdapter(adapter);
        artistsViewModel = ViewModelProviders.of(this).get(ArtistsViewModel.class);
    }

    private void getArtists() {

        artistsViewModel.getArtistResponseLiveData().observe(this, artistsResponse -> {
            if (artistsResponse != null) {
                progress_circular_movie_article.setVisibility(View.GONE);
                artistsArrayList.addAll(artistsResponse);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
