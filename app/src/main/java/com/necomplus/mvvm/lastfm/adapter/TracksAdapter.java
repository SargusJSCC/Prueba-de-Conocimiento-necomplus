package com.necomplus.mvvm.lastfm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.necomplus.mvvm.lastfm.R;
import com.necomplus.mvvm.lastfm.model.Top.Artist;
import com.necomplus.mvvm.lastfm.model.track.Toptracks;
import com.necomplus.mvvm.lastfm.model.track.Track;

import java.util.ArrayList;

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolder> {

    private Context context;
    ArrayList<Track> tracksArrayList;

    public TracksAdapter(Context context, ArrayList<Track> articleArrayList) {
        this.context = context;
        this.tracksArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public TracksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.track_list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TracksAdapter.ViewHolder viewHolder, int i) {
        Track track=tracksArrayList.get(i);
        viewHolder.tvtrack.setText(track.getName());
    }

    @Override
    public int getItemCount() {
        return tracksArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvtrack;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvtrack=(TextView) itemView.findViewById(R.id.tvtrack);
        }
    }
}
