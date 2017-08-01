package com.we_are_mea.gvapplication;

/**
 * Created by MEA Mobile on 2/17/2017.
 */

import android.content.Context;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public MovieDetails[] movieDetails= null;
    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
        //new MyAsync().execute();
    }
    public ImageAdapter(Context c,String[] arr) {
        mContext = c;
        movieDetails =new MovieDetails[arr.length];
        for(int i=0;i<arr.length;i++){
            movieDetails[i] = new MovieDetails(arr[i]);
            //movieDetails[i].imageUrl = arr[i];
        }
        //new MyAsync().execute();
    }

    public int getCount() {
        return 20;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(230, 230));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        String string=movieDetails[position].imageUrl;
        MovieDetails movieDetailsLocal= new MovieDetails(string);

//        imageView.setImageResource(movieDetailsLocal);
        Log.d("Ayy lmao",movieDetails[position].toString());

//        Picasso
//                .with(mContext)
//                .load(movieDetails[position].toString()).into(imageView);
        Picasso.with(mContext).load(string).into(imageView);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.silenceofthelambs,R.drawable.fightclub,R.drawable.thehangover,R.drawable.themartian
    };
}