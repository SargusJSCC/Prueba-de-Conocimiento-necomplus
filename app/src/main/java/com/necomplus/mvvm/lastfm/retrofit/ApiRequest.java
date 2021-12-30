package com.necomplus.mvvm.lastfm.retrofit;

import com.necomplus.mvvm.lastfm.constants.AppConstant;
import com.necomplus.mvvm.lastfm.model.Top.Artists;
import com.necomplus.mvvm.lastfm.model.track.Tracks;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {

    @POST(AppConstant.VERSION)
    Call<Artists> getTopArtists(
            @Query("method") String method,
            @Query("country") String country,
            @Query("api_key") String api_key,
            @Query("format") String format,
            @Query("limit") Integer limit
    );

    @POST(AppConstant.VERSION)
    Call<Tracks> getTopTracks(
            @Query("method") String method,
            @Query("artist") String artist,
            @Query("api_key") String api_key,
            @Query("format") String format,
            @Query("limit") Integer limit
    );

}
