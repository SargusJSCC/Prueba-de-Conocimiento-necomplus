package com.necomplus.mvvm.lastfm.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.necomplus.mvvm.lastfm.R;
import com.necomplus.mvvm.lastfm.model.Top.Artist;
import com.necomplus.mvvm.lastfm.view.TrackActivity;

import java.util.ArrayList;

public class ArtitsAdapter extends RecyclerView.Adapter<ArtitsAdapter.ViewHolder> {

    private Context context;
    ArrayList<Artist> articleArrayList;

    public ArtitsAdapter(Context context, ArrayList<Artist> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ArtitsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.artits_list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtitsAdapter.ViewHolder viewHolder, int i) {
        Artist artist=articleArrayList.get(i);
        viewHolder.tvname.setText(artist.getName());
        viewHolder.tvplaycount.setText(artist.getListeners());
        viewHolder.tvurl.setText(artist.getUrl());

        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("onBindViewHolder", artist.getName());
                Intent intent = new Intent(context, TrackActivity.class);
                intent.putExtra("name",artist.getName());
                intent.putExtra("playcount",artist.getListeners());
                intent.putExtra("url",artist.getUrl());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvname;
        private final TextView tvplaycount;
        private final TextView tvurl;
        private final Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvname=(TextView) itemView.findViewById(R.id.tvname);
            tvplaycount=(TextView) itemView.findViewById(R.id.tvplaycount);
            tvurl=(TextView) itemView.findViewById(R.id.tvurl);
            button=(Button) itemView.findViewById(R.id.btn_view_post);

        }
    }
}
