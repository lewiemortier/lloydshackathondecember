package com.dminc.lloydshackathon2.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dminc.lloydshackathon2.R;
import com.dminc.lloydshackathon2.Vews.SlidingBar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Lewie Mortier
 */
public class BuyFragment extends Fragment {

    @Bind(R.id.slider_credits)
    SlidingBar mCreditsSlider;
    @Bind(R.id.slider_deposit)
    SlidingBar mDepositSlider;
    @Bind(R.id.slider_term)
    SlidingBar mTermSlider;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_buy, container, false);
        ButterKnife.bind(v, getActivity());

        if (savedInstanceState != null) {
            mDepositSlider.setEnabled(false);
        }

        return v;
    }
}
