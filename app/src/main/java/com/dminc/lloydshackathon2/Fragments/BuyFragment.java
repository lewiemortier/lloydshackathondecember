package com.dminc.lloydshackathon2.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SeekBar;

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

    private static List<Car> fancy_cars = new ArrayList<>();
    private static List<Car> medium_cars = new ArrayList<>();
    private static List<Car> cheap_cars = new ArrayList<>();

    static {
        fancy_cars.add(new Car("McClaren 675LT", "http://fancy_cars.mclaren.com/files/live/sites/mclaren/files/fancy_cars-mclaren-com-Main/McLaren%20Model%20Section/675LT/Design/Shot05_675LT_Profile-resize1500x937.jpg"));
        fancy_cars.add(new Car("Batmobile", "http://www.ci.lancaster.ma.us/Pages/LancasterMA_Events/S02157D9F-02157DD0.0/8632768_1.jpg"));
        fancy_cars.add(new Car("Maserati Ghibli", "http://www.maserati.co.uk/mediaObject/redesign/new-model-menu/resized%2080/QP_GTS/resolutions/res-l427x1000/QP_GTS.jpg"));
        fancy_cars.add(new Car("Lamborghini Aventador", "http://o.aolcdn.com/commerce/autodata/images/USC30LGC041A021001.jpg"));
        fancy_cars.add(new Car("Ferrari 488 GTB", "http://488gtb.ferrari.com/img/carHome.png"));

        medium_cars.add(new Car("Bigfoot truck", "http://www.muralsforkids.com/product_images/t/058/bigfoot__36366_zoom.jpg"));
        medium_cars.add(new Car("BMW 5", "http://cdn2.autoexpress.co.uk/sites/autoexpressuk/files/bmw_5.jpg"));
        medium_cars.add(new Car("Mercedes Modelle", "http://www.mercedes-benz.de/content/media_library/hq/hq_mpc_reference_site/passenger_cars_ng/new_cars/models/e-class/_w212/model_navigation_library/mercedes-benz_e-class_w212_model_navigation_960x298_12-2012_jpg.object-Single-MEDIA.tmp/mercedes-benz_e-class_w212_model_navigation_960x298_12-2012.jpg"));
        medium_cars.add(new Car("Lexus RX", "http://bestsellingcarsblog.com/wp-content/uploads/2012/09/Lexus-RX-Taiwan-August-2012.jpg"));
        medium_cars.add(new Car("Audi R6 Avant", "http://www.audi.com.au/content/dam/ngw/au/drop_down_model_images/drop_down_0002_rs_6_avant.png"));

        cheap_cars.add(new Car("Robin Reliant", "http://s3.caradvice.com.au/wp-content/uploads/2011/06/reliant-robin-top-gear.jpg"));
        cheap_cars.add(new Car("Skoda", "http://farm4.static.flickr.com/3080/3163917405_dea6433ba3_b.jpg"));
        cheap_cars.add(new Car("Ford Escort", "http://www.aronline.co.uk/blogs/wp-content/uploads/2011/08/xr3i.jpg"));
        cheap_cars.add(new Car("Rust Bucket", "http://thumbs.dreamstime.com/x/antique-rusty-old-car-11957574.jpg"));
        cheap_cars.add(new Car("Model T", "http://www.duetsblog.com/files/2014/05/modelT.jpeg"));

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_buy, container, false);
        ButterKnife.bind(this, v);

        CarAdapter carAdapter = new CarAdapter(getActivity(), fancy_cars);
        mListCars.setAdapter(carAdapter);

        if (savedInstanceState != null) {
            mDepositSlider.setEnabled(false);
        }

        mCreditsSlider.setOnSeekListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCreditsSlider.setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateValues();
            }
        });

        mDepositSlider.setOnSeekListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mDepositSlider.setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateValues();
            }
        });

        mTermSlider.setOnSeekListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTermSlider.setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateValues();
            }
        });

        return v;
    }

    private void updateValues() {

        int totalValue = mCreditsSlider.getValue() + mDepositSlider.getValue();

        // TODO update dial

        //Update list
        List<Car> selectedCars;
        if(totalValue < 5000) {
            selectedCars = cheap_cars;
        } else if (totalValue >= 5000 && totalValue < 50000){
            selectedCars = medium_cars;
        } else {
            selectedCars = fancy_cars;
        }

        ((CarAdapter) mListCars.getAdapter()).setCars(selectedCars);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
