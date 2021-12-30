package com.necomplus.mvvm.lastfm.model.track;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tracks {

    @SerializedName("toptracks")
    @Expose
    private Toptracks toptracks;

    public Toptracks getToptracks() {
        return toptracks;
    }

    public void setToptracks(Toptracks toptracks) {
        this.toptracks = toptracks;
    }

}
