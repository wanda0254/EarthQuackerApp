package xyz.fatahillah.earthquackerapp.model;

/**
 * Created by LENOVO on 17/01/2017.
 */

public class Earthquake {
    //magnitude
    private double mMagnitude;

    //url website
    private String mUrl;

    //location
    private String mLocation;

    //date
    private long mTimeMilliseconds;

    public Earthquake(double magnitude, String location, long timeMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeMilliseconds = timeMilliseconds;
        mUrl = url;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public long getmTimeMilliseconds() {
        return mTimeMilliseconds;
    }

    public void setmTimeMilliseconds(long mTimeMilliseconds) {
        this.mTimeMilliseconds = mTimeMilliseconds;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
