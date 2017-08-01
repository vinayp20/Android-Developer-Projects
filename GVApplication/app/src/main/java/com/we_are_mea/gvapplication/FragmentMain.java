package com.we_are_mea.gvapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.Arrays;

/**
 * Created by MEA Mobile on 2/27/2017.
 */

public class FragmentMain extends Fragment {
    private ArrayAdapter arrayAdapter;
    public MovieDetails[] movieDetails={
            new MovieDetails("http://image.tmdb.org/t/p/w185//wnVHDbGz7RvDAHFAsVVT88FxhrP.jpg"),
            new MovieDetails("http://image.tmdb.org/t/p/w185//bbxtz5V0vvnTDA2qWbiiRC77Ok9.jpg"),
            new MovieDetails("http://image.tmdb.org/t/p/w185//jjBgi2r5cRt36xF6iNUEhzscEcb.jpg"),
            new MovieDetails("http://image.tmdb.org/t/p/w185//4PiiNGXj1KENTmCBHeN6Mskj2Fq.jpg")

    };
    public FragmentMain(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_main, container, false);
        arrayAdapter =new ArrayAdapter(getActivity(), Arrays.asList(movieDetails));
        GridView gridViewVar=(GridView) rootView.findViewById(R.id.gridview);
        gridViewVar.setAdapter(arrayAdapter);
        return rootView;
    }
}
