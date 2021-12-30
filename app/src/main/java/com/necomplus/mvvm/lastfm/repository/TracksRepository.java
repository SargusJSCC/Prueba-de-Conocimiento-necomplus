package com.necomplus.mvvm.lastfm.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import com.necomplus.mvvm.lastfm.model.track.Track;
import com.necomplus.mvvm.lastfm.model.track.Tracks;
import com.necomplus.mvvm.lastfm.retrofit.ApiRequest;
import com.necomplus.mvvm.lastfm.retrofit.RetrofitRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TracksRepository {
    private static final String TAG = TracksRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public TracksRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public MutableLiveData<List<Track> > getTracks(String method, String artist, String api_key, String format, Integer limit) {
        final MutableLiveData<List<Track>> data = new MutableLiveData<>();

        apiRequest.getTopTracks(method, artist, api_key, format, limit   )
                .enqueue(new Callback<Tracks>() {

                    @Override
                    public void onResponse(Call<Tracks> call, Response<Tracks> response) {
                        if (response.body() != null) {
                            data.setValue(response.body().getToptracks().getTrack());
                        }
                    }
                    @Override
                    public void onFailure(Call<Tracks> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }


}
