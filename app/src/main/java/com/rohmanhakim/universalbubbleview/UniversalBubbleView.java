package com.rohmanhakim.universalbubbleview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class UniversalBubbleView extends View {

    Context context;

    public UniversalBubbleView(Context context) {
        super(context);
        this.context = context;
    }

    public UniversalBubbleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UniversalBubbleView setIncoming(boolean incoming){

        Drawable background;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        if (incoming) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                background = context.getDrawable(R.drawable.rounded_background_incoming);
            } else {
                background = context.getResources().getDrawable(R.drawable.rounded_background_incoming);
            }

            layoutParams.setMargins(
                    dpToPixel(8),
                    dpToPixel(8),
                    dpToPixel(100),
                    dpToPixel(0)
            );
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                background = context.getDrawable(R.drawable.rounded_background_outgoing);
            } else {
                background = context.getResources().getDrawable(R.drawable.rounded_background_outgoing);
            }

            layoutParams.setMargins(
                    dpToPixel(100),
                    dpToPixel(8),
                    dpToPixel(8),
                    dpToPixel(0)
            );
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.setBackground(background);
        } else {
            this.setBackgroundDrawable(background);
        }
        return this;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private int dpToPixel(int dp){
        Resources resources = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                resources.getDisplayMetrics()
        );
    }
}