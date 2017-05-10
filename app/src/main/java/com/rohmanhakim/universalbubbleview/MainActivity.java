package com.rohmanhakim.universalbubbleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UniversalBubbleView universalBubbleView = new UniversalBubbleView(this)
                        .setIncoming(true);

        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
        container.addView(universalBubbleView);
    }
}
