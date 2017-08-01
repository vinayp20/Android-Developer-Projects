package com.we_are_mea.gvapplication;

import android.app.Activity;
import android.content.Context;

import java.util.List;

/**
 * Created by MEA Mobile on 2/28/2017.
 */

public class CustomAdapter extends ArrayAdapter {
    Context context;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the List is the data we want
     * to populate into the lists
     *
     * @param activity
     * @param movieDetailses
     */
    public CustomAdapter(Activity activity, List<MovieDetails> movieDetailses) {

        super(activity, movieDetailses);
    }

}
