package com.necomplus.mvvm.lastfm.repository;

import androidx.lifecycle.MutableLiveData;
import com.necomplus.mvvm.lastfm.model.Top.Artist;
import com.necomplus.mvvm.lastfm.model.Top.Artists;
import com.necomplus.mvvm.lastfm.retrofit.ApiRequest;
import com.necomplus.mvvm.lastfm.retrofit.RetrofitRequest;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistsRepository {
    private static final String TAG = ArtistsRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public ArtistsRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public MutableLiveData<List<Artist>> getTopArtists(String method, String country, String api_key, String format, Integer limit) {
        final MutableLiveData<List<Artist>> data = new MutableLiveData<>();

        apiRequest.getTopArtists(method, country, api_key, format, limit   )
                .enqueue(new Callback<Artists>() {

                    @Override
                    public void onResponse(Call<Artists> call, Response<Artists> response) {
                        if (response.body() != null) {
                            data.setValue(response.body().getTopartists().getArtist());
                        }
                    }
                    @Override
                    public void onFailure(Call<Artists> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
