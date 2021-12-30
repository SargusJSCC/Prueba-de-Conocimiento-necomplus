package com.necomplus.mvvm.lastfm.view_model;

import static com.necomplus.mvvm.lastfm.constants.AppConstant.API_KEY;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.necomplus.mvvm.lastfm.model.Top.Artist;
import com.necomplus.mvvm.lastfm.model.track.Toptracks;
import com.necomplus.mvvm.lastfm.model.track.Track;
import com.necomplus.mvvm.lastfm.model.track.Tracks;
import com.necomplus.mvvm.lastfm.repository.ArtistsRepository;
import com.necomplus.mvvm.lastfm.repository.TracksRepository;

import java.util.List;

public class TracksViewModel extends AndroidViewModel {

    private TracksRepository tracksRepository;

    private MutableLiveData<List<Track> > articleResponseLiveData;

    public TracksViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Track> > getTrackResponseLiveData(String artist) {
        tracksRepository = new TracksRepository();
        return  tracksRepository.getTracks(
                "artist.gettoptracks",
                artist,
                API_KEY,
                "json",
                5
        );
    }
}
