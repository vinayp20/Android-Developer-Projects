package com.we_are_mea.gvapplication;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by MEA Mobile on 2/27/2017.
 */


public class ArrayAdapter extends android.widget.ArrayAdapter {


    private Context mContext;
    private ImageView mImageView;

    public ArrayAdapter(Activity activity, List<MovieDetails> movieDetailses) {
//mContext=activity;
        super(activity, 0, movieDetailses);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      ImageView imageView=new ImageView(mContext);

//        imageView.setImageResource();
        return convertView;
    }
}
