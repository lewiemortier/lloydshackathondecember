package com.dminc.lloydshackathon2.Objects;

/**
 * @author Lewie Mortier
 */
public class Car {

    private String mMake;
    private String mImageUrl;

    public Car(String make, String imageUrl) {
        this.mMake = make;
        this.mImageUrl = imageUrl;
    }

    public String getmMake() {
        return mMake;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }
}
