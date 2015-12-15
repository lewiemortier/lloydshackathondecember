package com.dminc.lloydshackathon2.Vews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dminc.lloydshackathon2.R;
import com.dminc.lloydshackathon2.Utils.Utils;

import java.util.zip.Inflater;

/**
 * @author Lewie Mortier
 */
public class SlidingBar extends RelativeLayout {

    private TextView mTitle;
    private SeekBar mSeekbar;
    private boolean mIsMoneyMode;
    private EditText mValue;

    public SlidingBar(Context context) {
        super(context);
        init(null);
    }

    public SlidingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SlidingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.slider, this, true);
        mTitle = (TextView) rootView.findViewById(R.id.slider_title);
        mSeekbar = (SeekBar) rootView.findViewById(R.id.slider_seekbar);
        mValue = (EditText) rootView.findViewById(R.id.slider_value);

        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.Slider);
            mTitle.setText(a.getString(R.styleable.Slider_labelText));
            float value = a.getFloat(R.styleable.Slider_value, 0);
            float maxValue = a.getFloat(R.styleable.Slider_maxValue, 5000);
            mIsMoneyMode = a.getBoolean(R.styleable.Slider_displayMoney, true);

            mSeekbar.setProgress(Math.round(value));
            mValue.setText(mIsMoneyMode ? Utils.formatPrice(value) : Integer.toString((int) Math.floor(value)));
            mSeekbar.setMax((int) Math.ceil(maxValue));
            a.recycle();
        }

        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mValue.setText(Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setOnSeekListener(SeekBar.OnSeekBarChangeListener listener) {
        mSeekbar.setOnSeekBarChangeListener(listener);
    }

    public void setValue(int value) {
        mValue.setText(mIsMoneyMode ? Utils.formatPrice(value) : Integer.toString(value));
    }

    public interface SliderChangedCallback {

        void onSliderChanged(int progress);
    }
}
