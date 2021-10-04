package com.example.playlistyoutube;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieYoutubeAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<MovieYoutube> movieYoutubeList;


    public MovieYoutubeAdapter(Context context, int layout, List<MovieYoutube> movieYoutubeList) {
        this.context = context;
        this.layout = layout;
        this.movieYoutubeList = movieYoutubeList;
    }

    @Override
    public int getCount() {
        return movieYoutubeList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView  imgThumbnails;
        TextView txtNameMovie;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null)
        {
            holder= new ViewHolder();
            LayoutInflater inflater;
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.imgThumbnails=view.findViewById(R.id.imgThumbnails);
            holder.txtNameMovie=view.findViewById(R.id.txtTenPhim);
            view.setTag(holder);
        }
        else{
            holder= (ViewHolder) view.getTag();
        }
        MovieYoutube movieYoutube= movieYoutubeList.get(i);
        holder.txtNameMovie.setText(movieYoutube.getTitle());
        //holder.imgThumbnails.setText();
        //Picasso.get (). Load (movieYoutube.getThumbnail()) .into (holder.imgThumbnails);
        Picasso.get().load(movieYoutube.getThumbnail()).into(holder.imgThumbnails);

        return view;
    }
}
