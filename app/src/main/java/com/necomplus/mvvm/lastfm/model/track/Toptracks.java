package com.necomplus.mvvm.lastfm.model.track;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Toptracks {

    @SerializedName("track")
    @Expose
    private List<Track> track = null;
    public List<Track> getTrack() {
        return track;
    }
    public void setTrack(List<Track> track) {
        this.track = track;
    }

}
