package com.we_are_mea.gvapplication;

//package com.example.helloworld;

        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Movie;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.app.Activity;
        import android.util.Log;
        import android.view.Menu;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.GridView;
        import java.io.*;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.Arrays;
       import org.json.*;
public class MainActivity extends Activity implements MyAsync.AsyncResponse, View.OnClickListener {
    int pos;
    //JSONObject jsonObject=new JSONObject();
    //HttpURLConnection httpURLConnection=new HttpURLConnection("http://api.themoviedb.org/3/movie/popular?api_key=fc9d78f0f24a254f836dc9a577aec946") {
    GridView gridview = null;

    public static MovieDetails[] stringArray2 = null;
    public static String[] stringArray = null;

    public void someclick(){

    }

    @Override
    public void processFinish(String output) {
        stringArray2 = new MovieDetails[20];
        stringArray =  new String[20];

        String moviepath = null;
        JSONObject info = null;
        String rating = null;
        String description = null;
        String title = null;
        String releasedate = null;
        String idForTrailer = null;
        try {
            info = new JSONObject(output);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray results = null;
        try {
            results = info.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int in = 0; in < results.length(); in++) {
            JSONObject json = null;
            try {
                json = results.getJSONObject(in);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                moviepath = "http://image.tmdb.org/t/p/w185/" + json.getString("poster_path");
                rating =json.getString("vote_average");
                description = json.getString("overview");
                title= json.getString("original_title");
                releasedate= json.getString("release_date");
                idForTrailer= json.getString("id");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            stringArray2[in] = new MovieDetails(moviepath,rating,description,title,releasedate,idForTrailer);
            stringArray[in] = moviepath;
            //Log.d("AAyy", stringArray[in]);
        }


        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this,stringArray));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //new MyAsync(this).execute();
                Intent intent = new Intent(getApplicationContext(), DestinationActivity.class);


                intent.putExtra("imageUri", stringArray2[position].imageUrl);
                intent.putExtra("rating", stringArray2[position].rating);
                intent.putExtra("description", stringArray2[position].description);
                intent.putExtra("title", stringArray2[position].title);
                intent.putExtra("releasedate", stringArray2[position].releasedate);
                intent.putExtra("idForTrailer", stringArray2[position].idForTrailer);

                startActivity(intent);
            }

        });
}

   public static String popularUrl = "http://api.themoviedb.org/3/movie/popular?api_key=fc9d78f0f24a254f836dc9a577aec946";
    public static String toprated = "http://api.themoviedb.org/3/movie/top_rated?api_key=fc9d78f0f24a254f836dc9a577aec946";


    Button topclick =null;
    Button popularclick = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(MainActivity.class.getSimpleName(), "The intent is at least in main here");

        new MyAsync(this,toprated).execute();


        topclick = (Button) findViewById(R.id.top);
        popularclick = (Button) findViewById(R.id.popular);
        topclick.setOnClickListener(this);
        popularclick.setOnClickListener(this);

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top:
                new MyAsync(this,toprated).execute();
                break;
            case R.id.popular:
                new MyAsync(this,popularUrl).execute();
                break;
        }
    }
    /*
    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            new MyAsync(,toprated).execute();
        }
    };
    View.OnClickListener myhandler2 = new View.OnClickListener() {
        public void onClick(View v) {
            new MyAsync(this,popularUrl).execute();
        }
    };*/
}




