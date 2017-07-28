package Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

/**
 * Created by jeremie kipeleka on 06/03/2017.
 */

public class CityData implements Parcelable {
    private Integer id;
    private String name;
    private String country;
    private Integer population;
    private Double lon;
    private Double lat;
    private HashMap<String,String> Now;
    private HashMap<String,String> Tomorrow;
    private HashMap<String,String> TwoDays_fromNow;
    private HashMap<String,String> ThreeDays_fromNow;
    private HashMap<String,String> FourDays_fromNow;
    private HashMap<String,String> FiveDays_fromNow;

    public Integer getId() {return id;}

    public void setId(Integer id) { this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getCountry() {return country;}

    public void setCountry(String country) {this.country = country;}

    public Integer getPopulation() {return population;}

    public void setPopulation(Integer population) {this.population = population;}

    public Double getLon() {return lon;}

    public void setLon(Double lon) { this.lon = lon;}

    public Double getLat() {return lat;}

    public void setLat(Double lat) { this.lat = lat;}


    public HashMap<String, String> getNow() {
        return Now;
    }

    public void setNow(HashMap<String, String> now) {
        Now = now;
    }

    public HashMap<String, String> getTomorrow() {
        return Tomorrow;
    }

    public void setTomorrow(HashMap<String, String> tomorrow) {
        Tomorrow = tomorrow;
    }

    public HashMap<String, String> getTwoDays_fromNow() {
        return TwoDays_fromNow;
    }

    public void setTwoDays_fromNow(HashMap<String, String> twoDays_fromNow) {
        TwoDays_fromNow = twoDays_fromNow;
    }

    public HashMap<String, String> getThreeDays_fromNow() {
        return ThreeDays_fromNow;
    }

    public void setThreeDays_fromNow(HashMap<String, String> threeDays_fromNow) {
        ThreeDays_fromNow = threeDays_fromNow;
    }

    public HashMap<String, String> getFourDays_fromNow() {
        return FourDays_fromNow;
    }

    public void setFourDays_fromNow(HashMap<String, String> fourDays_fromNow) {
        FourDays_fromNow = fourDays_fromNow;
    }

    public HashMap<String, String> getFiveDays_fromNow() {
        return FiveDays_fromNow;
    }

    public void setFiveDays_fromNow(HashMap<String, String> fiveDays_fromNow) {
        FiveDays_fromNow = fiveDays_fromNow;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.country);
        dest.writeValue(this.population);
        dest.writeValue(this.lon);
        dest.writeValue(this.lat);
        dest.writeSerializable(this.Now);
        dest.writeSerializable(this.Tomorrow);
        dest.writeSerializable(this.TwoDays_fromNow);
        dest.writeSerializable(this.ThreeDays_fromNow);
        dest.writeSerializable(this.FourDays_fromNow);
        dest.writeSerializable(this.FiveDays_fromNow);
    }

    public CityData() {
    }

    protected CityData(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.country = in.readString();
        this.population = (Integer) in.readValue(Integer.class.getClassLoader());
        this.lon = (Double) in.readValue(Double.class.getClassLoader());
        this.lat = (Double) in.readValue(Double.class.getClassLoader());
        this.Now = (HashMap<String, String>) in.readSerializable();
        this.Tomorrow = (HashMap<String, String>) in.readSerializable();
        this.TwoDays_fromNow = (HashMap<String, String>) in.readSerializable();
        this.ThreeDays_fromNow = (HashMap<String, String>) in.readSerializable();
        this.FourDays_fromNow = (HashMap<String, String>) in.readSerializable();
        this.FiveDays_fromNow = (HashMap<String, String>) in.readSerializable();
    }

    public static final Parcelable.Creator<CityData> CREATOR = new Parcelable.Creator<CityData>() {
        @Override
        public CityData createFromParcel(Parcel source) {
            return new CityData(source);
        }

        @Override
        public CityData[] newArray(int size) {
            return new CityData[size];
        }
    };
}
