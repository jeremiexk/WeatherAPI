package Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by jeremie kipeleka on 06/03/2017.
 */


public class City implements Parcelable {

    @SerializedName("city")
    @Expose
    private City_ city;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private double message;
    @SerializedName("cnt")
    @Expose
    private int cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<City.List> list = null;

    public City_ getCity() {
        return city;
    }

    public void setCity(City_ city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public java.util.List<City.List> getList() {
        return list;
    }

    public void setList(java.util.List<City.List> list) {
        this.list = list;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.city, flags);
        dest.writeString(this.cod);
        dest.writeDouble(this.message);
        dest.writeInt(this.cnt);
        dest.writeList(this.list);
    }

    public City() {
    }

    protected City(Parcel in) {
        this.city = in.readParcelable(City_.class.getClassLoader());
        this.cod = in.readString();
        this.message = in.readDouble();
        this.cnt = in.readInt();
        this.list = new ArrayList<City.List>();
        in.readList(this.list, City.List.class.getClassLoader());
    }

    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };



    public class City_ implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coord")
    @Expose
    private Coord coord;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("population")
    @Expose
    private int population;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeParcelable(this.coord, flags);
        dest.writeString(this.country);
        dest.writeInt(this.population);
    }

    public City_() {
    }

    protected City_(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.coord = in.readParcelable(Coord.class.getClassLoader());
        this.country = in.readString();
        this.population = in.readInt();
    }

    public  final Parcelable.Creator<City_> CREATOR = new Parcelable.Creator<City_>() {
        @Override
        public City_ createFromParcel(Parcel source) {
            return new City_(source);
        }

        @Override
        public City_[] newArray(int size) {
            return new City_[size];
        }
    };
}

    public class Coord implements Parcelable {

    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("lat")
    @Expose
    private double lat;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeDouble(this.lon);
         dest.writeDouble(this.lat);
     }

     public Coord() {
     }

     protected Coord(Parcel in) {
         this.lon = in.readDouble();
         this.lat = in.readDouble();
     }

     public final Parcelable.Creator<Coord> CREATOR = new Parcelable.Creator<Coord>() {
         @Override
         public Coord createFromParcel(Parcel source) {
             return new Coord(source);
         }

         @Override
         public Coord[] newArray(int size) {
             return new Coord[size];
         }
     };
 }

    public class List implements Parcelable {

    @SerializedName("dt")
    @Expose
    private int dt;
    @SerializedName("temp")
    @Expose
    private Temp temp;
    @SerializedName("pressure")
    @Expose
    private double pressure;
    @SerializedName("humidity")
    @Expose
    private int humidity;
    @SerializedName("weather")
    @Expose
    private java.util.List<Weather> weather = null;
    @SerializedName("speed")
    @Expose
    private double speed;
    @SerializedName("deg")
    @Expose
    private int deg;
    @SerializedName("clouds")
    @Expose
    private int clouds;
    @SerializedName("rain")
    @Expose
    private double rain;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeInt(this.dt);
         dest.writeParcelable(this.temp, flags);
         dest.writeDouble(this.pressure);
         dest.writeInt(this.humidity);
         dest.writeList(this.weather);
         dest.writeDouble(this.speed);
         dest.writeInt(this.deg);
         dest.writeInt(this.clouds);
         dest.writeDouble(this.rain);
     }

     public List() {
     }

     protected List(Parcel in) {
         this.dt = in.readInt();
         this.temp = in.readParcelable(Temp.class.getClassLoader());
         this.pressure = in.readDouble();
         this.humidity = in.readInt();
         this.weather = new ArrayList<Weather>();
         in.readList(this.weather, Weather.class.getClassLoader());
         this.speed = in.readDouble();
         this.deg = in.readInt();
         this.clouds = in.readInt();
         this.rain = in.readDouble();
     }

     public  final Parcelable.Creator<List> CREATOR = new Parcelable.Creator<List>() {
         @Override
         public List createFromParcel(Parcel source) {
             return new List(source);
         }

         @Override
         public List[] newArray(int size) {
             return new List[size];
         }
     };
 }

    public class Temp implements Parcelable {

    @SerializedName("day")
    @Expose
    private double day;
    @SerializedName("min")
    @Expose
    private double min;
    @SerializedName("max")
    @Expose
    private double max;
    @SerializedName("night")
    @Expose
    private double night;
    @SerializedName("eve")
    @Expose
    private double eve;
    @SerializedName("morn")
    @Expose
    private double morn;

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeDouble(this.day);
         dest.writeDouble(this.min);
         dest.writeDouble(this.max);
         dest.writeDouble(this.night);
         dest.writeDouble(this.eve);
         dest.writeDouble(this.morn);
     }

     public Temp() {
     }

     protected Temp(Parcel in) {
         this.day = in.readDouble();
         this.min = in.readDouble();
         this.max = in.readDouble();
         this.night = in.readDouble();
         this.eve = in.readDouble();
         this.morn = in.readDouble();
     }

     public  final Parcelable.Creator<Temp> CREATOR = new Parcelable.Creator<Temp>() {
         @Override
         public Temp createFromParcel(Parcel source) {
             return new Temp(source);
         }

         @Override
         public Temp[] newArray(int size) {
             return new Temp[size];
         }
     };
 }

    public class Weather {

     @SerializedName("id")
     @Expose
     private int id;
     @SerializedName("main")
     @Expose
     private String main;
     @SerializedName("description")
     @Expose
     private String description;
     @SerializedName("icon")
     @Expose
     private String icon;

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getMain() {
         return main;
     }

     public void setMain(String main) {
         this.main = main;
     }

     public String getDescription() {
         return description;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public String getIcon() {
         return icon;
     }

     public void setIcon(String icon) {
         this.icon = icon;
     }
 }
}
