package com.example.buttonzoomapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView cameraButton = findViewById(R.id.buttonn);
        Button startButton = findViewById(R.id.startButton);

        // Add an overlay view
        final View overlayView = findViewById(R.id.overlayView);
        overlayView.setVisibility(View.INVISIBLE);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_in);
                cameraButton.startAnimation(animation);

                // Delay for 1.5 seconds (adjust as needed)
                int delayMillis = 1000; // 1500 milliseconds = 1.5 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Apply fade-out effect to overlay view
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                        alphaAnimation.setDuration(1500); // Adjust the duration as needed
                        overlayView.startAnimation(alphaAnimation);
                        overlayView.setVisibility(View.INVISIBLE); // Hide the overlay when the animation is done

                        // Start the second activity after the delay
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }
                }, delayMillis);

                // Make the overlay visible with a fade-in effect (optional)
                overlayView.setVisibility(View.VISIBLE);
                AlphaAnimation fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
                fadeInAnimation.setDuration(1500); // Adjust the duration as needed
                overlayView.startAnimation(fadeInAnimation);
            }
        });
    }
}
