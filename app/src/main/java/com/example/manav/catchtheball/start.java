package com.example.manav.catchtheball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class start extends AppCompatActivity {


    private InterstitialAd interstitial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        MobileAds.initialize(this, "ca-app-pub-5094514784921639~8614293715");




        // Create the interstitial ad
        interstitial = new InterstitialAd(this);



        interstitial.setAdUnitId("ca-app-pub-5094514784921639/1773553198");

        //Create request
        AdRequest adRequest = new AdRequest.Builder().build();

        //Start loading...

         interstitial.loadAd(adRequest);

         //Display add
        interstitial.setAdListener(new AdListener() {
             public void onAdLoaded() {
                 displayInterstitial();
             }
        });


    }



     public void displayInterstitial() {
        if (interstitial.isLoaded()) {
            interstitial.show();

        }

     }


    public void startGame(View view){
        startActivity(new Intent(getApplicationContext(), Main.class));

    }

    //Disable return button
    @Override
    public boolean dispatchKeyEvent(KeyEvent event){

        if (event.getAction() == KeyEvent.ACTION_DOWN ) {
            switch (event.getKeyCode()){
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);

    }


}
