package com.dminc.lloydshackathon2.Objects;

/**
 * @author Lewie Mortier
 */
public class Car {

    private String mMake;
    private String mImageUrl;
    private String mPrice;

    public Car(String make, String imageUrl, String price) {
        this.mMake = make;
        this.mImageUrl = imageUrl;
        this.mPrice = price;
    }

    public String getmMake() {
        return mMake;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmPrice() {
        return mPrice;
    }

}
