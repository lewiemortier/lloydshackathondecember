package com.dminc.lloydshackathon2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dminc.lloydshackathon2.Objects.Car;
import com.dminc.lloydshackathon2.R;
import com.dminc.lloydshackathon2.Utils.Utils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author Lewie Mortier
 */
public class CarAdapter extends BaseAdapter {

    private List<Car> mCars;
    private Context mContext;

    public CarAdapter(Context ctx, List<Car> cars) {
        mCars = cars;
        mContext = ctx;
    }

    public void setCars(List<Car> cars) {
        mCars = cars;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mCars.size();
    }

    @Override
    public Car getItem(int position) {
        return mCars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CarViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new CarViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.view_car, parent, false);
            viewHolder.price = (TextView) convertView.findViewById(R.id.car_price);
            viewHolder.make = (TextView) convertView.findViewById(R.id.car_make);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.car_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CarViewHolder) convertView.getTag();
        }

        Car car = mCars.get(position);
        viewHolder.make.setText(car.getmMake());
        viewHolder.price.setText(Utils.formatPrice(Integer.valueOf(car.getmPrice())));

        Picasso.with(mContext)
                .load(car.getmImageUrl())
                .resize(650, 450)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .centerCrop()
                .into(viewHolder.image, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {

                    }
                });

        return convertView;
    }

    private static class CarViewHolder {
        TextView make;
        ImageView image;
        TextView price;
    }
}
