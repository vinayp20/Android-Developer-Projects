package com.we_are_mea.gvapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DestinationActivity extends AppCompatActivity {
 ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        mImageView=(ImageView)findViewById(R.id.destination_image) ;
        Intent incomingIntent=getIntent();
        Log.d(DestinationActivity.class.getSimpleName(),"Outside Incoming intent");
        if(incomingIntent!=null) {
            Log.d(DestinationActivity.class.getSimpleName(),"Inside Incoming intent");

            String imageUri = incomingIntent.getStringExtra("imageUri");
            if(imageUri==null){
                Log.d(DestinationActivity.class.getSimpleName(),"image Uri null inco");
            }
            if(imageUri!=null) {
                Log.d(DestinationActivity.class.getSimpleName(), imageUri);
Log.d(DestinationActivity.class.getSimpleName(),"Before Picasso call");

                Picasso.with(this).load(imageUri).into(mImageView);

            }
        }


//        String action=incomingIntent.getAction();
//        String type=incomingIntent.getType();
//        if(Intent.ACTION_SEND.equals(action)&& type!=null){
////            Log.d();
//            if(type.startsWith("image/")){
//                handleSendImage(incomingIntent);
//            }
//        }

    }
    void handleSendImage(Intent incomingIntent){
        Uri imageUri=(Uri) incomingIntent.getParcelableExtra(Intent.EXTRA_STREAM);
        if(imageUri!=null){
//mImageView=(ImageView) findViewById(R.id.destination_image_display);
            Log.d("Whatever",imageUri.toString());
//            mImageView.setImageURI(imageUri);
            Picasso.with(this).load(imageUri).into(mImageView);
        }
    }


}
