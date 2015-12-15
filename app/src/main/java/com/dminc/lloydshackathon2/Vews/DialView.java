package com.dminc.lloydshackathon2.Vews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

import com.dminc.lloydshackathon2.R;

import javax.xml.transform.Transformer;

/**
 * @author Lewie Mortier
 */
public class DialView extends RelativeLayout {

    private static final int MAX_ROTATION  = 180;

    private float mCurrentRotation = 0.0f;

    private float mBaseX;

    private float mBaseY;

    private View mDial;

    public DialView(Context context) {
        super(context);
        init();
    }

    public DialView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DialView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setValue(float value) {
        // Rotate dial depending on value
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(new Exception("Please use a value between 0 and 100!"));
        }

        float rotation = MAX_ROTATION * (value / 100);
        RotateAnimation am = new RotateAnimation(mCurrentRotation, rotation,
                Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF,
                0.5f);
        am.setDuration(750);
        am.setRepeatCount(0);
        am.setFillAfter(true);

        mDial.startAnimation(am);
        mCurrentRotation = rotation;
    }

    private void init() {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.view_dial, this, true);
        mDial = rootView.findViewById(R.id.dial);
    }


}
