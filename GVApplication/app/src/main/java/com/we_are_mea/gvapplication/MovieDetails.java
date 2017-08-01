package com.we_are_mea.gvapplication;

import android.widget.TextView;

import java.util.*;

/**
 * Created by MEA Mobile on 2/27/2017.
 */

public class MovieDetails {
// String movieTitle;
  // int imageId;
//    TextView textView;
//    int userRating;
//    Date date;
    String imageUrl;
    String rating;
    String description;
    String title;
    String releasedate;
    String idForTrailer;
  public  MovieDetails(String imageUrl){
        this.imageUrl=imageUrl;
  }
    public  MovieDetails(String imageUrl,String rating,String description,String title,String releasedate,String idForTrailer){
        this.imageUrl=imageUrl;
        this.rating=rating;
        this.description=description;
        this.title = title;
        this.releasedate = releasedate;
        this.idForTrailer = idForTrailer;
    }
}

