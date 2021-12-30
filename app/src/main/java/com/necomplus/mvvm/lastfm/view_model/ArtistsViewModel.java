package com.necomplus.mvvm.lastfm.view_model;

import static com.necomplus.mvvm.lastfm.constants.AppConstant.API_KEY;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.necomplus.mvvm.lastfm.model.Top.Artist;
import com.necomplus.mvvm.lastfm.model.Top.Artists;
import com.necomplus.mvvm.lastfm.model.Top.Topartists;
import com.necomplus.mvvm.lastfm.repository.ArtistsRepository;

import java.util.List;

public class ArtistsViewModel extends AndroidViewModel {

    private ArtistsRepository artistsRepository;
    private MutableLiveData<List<Artist>> articleResponseLiveData;

    public ArtistsViewModel(@NonNull Application application) {
        super(application);

        artistsRepository = new ArtistsRepository();
        this.articleResponseLiveData = artistsRepository.getTopArtists(
                "geo.gettopartists",
                "colombia",
                API_KEY,
                "json",
                10
        );
    }

    public LiveData<List<Artist>> getArtistResponseLiveData() {
        return articleResponseLiveData;
    }
}
