package com.dminc.lloydshackathon2.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dminc.lloydshackathon2.Adapters.CarAdapter;
import com.dminc.lloydshackathon2.Objects.Car;
import com.dminc.lloydshackathon2.R;
import com.dminc.lloydshackathon2.Vews.SlidingBar;

import java.util.ArrayList;
import java.util.List;

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
    @Bind(R.id.search_results)
    ListView mListCars;

    private static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("BMW 5", "http://cdn2.autoexpress.co.uk/sites/autoexpressuk/files/bmw_5.jpg"));
        cars.add(new Car("BMW 5", "http://cdn2.autoexpress.co.uk/sites/autoexpressuk/files/bmw_5.jpg"));
        cars.add(new Car("BMW 5", "http://cdn2.autoexpress.co.uk/sites/autoexpressuk/files/bmw_5.jpg"));
        cars.add(new Car("BMW 5", "http://cdn2.autoexpress.co.uk/sites/autoexpressuk/files/bmw_5.jpg"));
        cars.add(new Car("BMW 5", "http://cdn2.autoexpress.co.uk/sites/autoexpressuk/files/bmw_5.jpg"));
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_buy, container, false);
        ButterKnife.bind(this, v);

        CarAdapter carAdapter = new CarAdapter(getActivity(), cars);
        mListCars.setAdapter(carAdapter);

        if (savedInstanceState != null) {
            mDepositSlider.setEnabled(false);
        }

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
