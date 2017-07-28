package com.app.jeremiekipeleka.wforweather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Model.City;

import services.MyServices;
import utils.NetworkHelper;


public class HomeActivity extends AppCompatActivity  {

    private boolean networkOk;
    boolean isBound = false;
    EditText UserInput;
    TextView Icebreaker;
    //Weather Details about now
    TextView CurrentCity;
    TextView Time;
    TextView Date_Year_Day;
    TextView Humidity;
    TextView Celsius;
    TextView Description;
    TextView NetworkStats;
    TextView Outputmsg;

    //WeatherDetails about Tomorrow
    TextView TmrDate;
    TextView TmrCelsius;
    TextView TmrDescription;

    //WeatherDetails about TheDay after Tomorrow
    TextView AfterTmrDate;
    TextView AFterTmrCelcius;
    TextView AfterTmrDescription;

    //WeatherDetails about 4 days from now
    TextView Day4Date;
    TextView Day4Celcius;
    TextView Day4Description;

    String mKey = "9bd6d5d91c8c2e9c52168f0f447e7eeb";
    String mUrl = "http://api.openweathermap.org/data/2.5/forecast/daily?q=Birmingham,uk&units=metric&APPID=";
    String ImgUrl = "http://openweathermap.org/img/w/";
    String FullUrl = mUrl + mKey;

    // our bound object that we will use to interact with our weather service
    private FetchWeatherDetails fetchWeatherDetails;



    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
//            String message =
//                    intent.getStringExtra(MyServices.MY_SERVICE_PAYLOAD);
//            Outputmsg.append(message + "\n");

            City DataItems = intent.getParcelableExtra(MyServices.MY_SERVICE_PAYLOAD);
           // City dataItems = intent.getParcelableArrayExtra(MyServices.MY_SERVICE_PAYLOAD);
            String ImgUrl = "http://openweathermap.org/img/w/";
            Model.City extract = new Model.City();

            //Get The objects from Our DataItems

            List<City.List> _forecastInfo=  DataItems.getList();
            //Extracting today forecast information
            City.List extractedTodayForecastDetails = _forecastInfo.get(0);

            //Extracting today's Weather Info
            List< City.Weather> extractedTodayWeatherInfo = extractedTodayForecastDetails.getWeather();
            City.Weather ExtratedTodayWeatherDeatails = extractedTodayWeatherInfo.get(0);

            //Extracting today Temperature Info

            City.Temp extractedTodayTemInfo = (City.Temp) extractedTodayForecastDetails.getTemp();
            String extractedCityName = DataItems.getCity().getName();
            String extractedDesc = ExtratedTodayWeatherDeatails.getDescription();

            int extractedCityHumidity  =  extractedTodayForecastDetails.getHumidity();
            double extractedCityPressure =  extractedTodayForecastDetails.getPressure();
            int extractedCityDegree = extractedTodayForecastDetails.getDeg();
            int extractedCityDayTemp= (int) extractedTodayTemInfo.getDay();

            City.Weather ExtratedCityWDesc = extractedTodayWeatherInfo.get(0);


            CurrentCity.setText("  City: "+ extractedCityName);
//             Time;

            Humidity.setText("Humidity: "+ extractedCityHumidity);
            //  Pressure.setText("Pressure: "+ extractedCityPressure);
//             Wind;
            Celsius.setText(extractedCityDayTemp + " ºC");
            Description.setText(extractedDesc);

            //******************************TOMORROW**********************************************

              //Extracting today forecast information
           City.List extractedTomorrowForecastDetails = _forecastInfo.get(1);
//
//            //Extracting today's Weather Info
            List< City.Weather> extractedTomorrowWeatherInfo = extractedTomorrowForecastDetails.getWeather();
           City.Weather ExtractedTomorrowWeatherDetails = extractedTomorrowWeatherInfo.get(0);
//            //Extracting today Temperature Info
           City.Temp extractedTomorrowTemInfo = (City.Temp) extractedTomorrowForecastDetails.getTemp();
//
            int extractedTomorrowCityDayTemp= (int) extractedTomorrowTemInfo.getDay();
            String extractedTomorrowDesc = ExtractedTomorrowWeatherDetails.getDescription();

            //City.Weather ExtractedTomorrowCityWDesc = extractedTodayWeatherInfo.get(0);

            TmrCelsius.setText(extractedTomorrowCityDayTemp + " ºC");
           TmrDescription.setText(extractedTomorrowDesc);


            //*****************************THE DAY AFTER TOMORROW***********************************

            //Extracting today forecast information
            City.List extractedDayAfterForecastDetails = _forecastInfo.get(2);
//
//            //Extracting The day after tomorrow Weather Info
            List< City.Weather> extractedDayAfterWeatherInfo = extractedDayAfterForecastDetails.getWeather();
            City.Weather ExtractedDayAfterWeatherDetails = extractedDayAfterWeatherInfo.get(0);
//            //Extracting today Temperature Info
            City.Temp extractedDayAfterTemInfo = (City.Temp) extractedDayAfterForecastDetails.getTemp();
//
            int extractedDayAfterCityDayTemp= (int) extractedDayAfterTemInfo.getDay();
            String extractedDayAfterDesc = ExtractedDayAfterWeatherDetails.getDescription();

            //City.Weather ExtractedTomorrowCityWDesc = extractedTodayWeatherInfo.get(0);

            AFterTmrCelcius.setText(extractedDayAfterCityDayTemp + " ºC");
            AfterTmrDescription.setText(extractedDayAfterDesc);


            //*****************************THE 4 Days From Now***********************************

            //Extracting today forecast information
            City.List extractedDay4ForecastDetails = _forecastInfo.get(3);
//
//            //Extracting The day after tomorrow Weather Info
            List< City.Weather> extractedDay4WeatherInfo = extractedDay4ForecastDetails.getWeather();
            City.Weather ExtractedDay4WeatherDetails = extractedDay4WeatherInfo.get(0);
//            //Extracting today Temperature Info
            City.Temp extractedDay4TemInfo = (City.Temp) extractedDay4ForecastDetails.getTemp();
//
            int extractedDay4CityDayTemp= (int) extractedDay4TemInfo.getDay();
            String extractedDay4Desc = ExtractedDay4WeatherDetails.getDescription();

            //City.Weather ExtractedTomorrowCityWDesc = extractedTodayWeatherInfo.get(0);

            Day4Celcius.setText(extractedDay4CityDayTemp + " ºC");
            Day4Description.setText(extractedDay4Desc);


            Icebreaker.setText(SmallTalk(extractedCityName,extractedDesc));


        }



    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // System Message Outputs
        TextView NetStat = (TextView) findViewById(R.id.txtViewNetworkStatus) ;
         NetworkStats = NetStat;

        //User Input

        EditText Mysearch = (EditText) findViewById(R.id.txtSearch) ;
        UserInput = Mysearch;


        TextView lblcity = (TextView) findViewById(R.id.lblCityName);
        TextView lblTime= (TextView) findViewById(R.id.txtTime);
        TextView lbldate_Year_Day= (TextView) findViewById(R.id.lblDateYear);
        TextView lblHumidity= (TextView) findViewById(R.id.txtHumidity);
        TextView lblCelsius= (TextView) findViewById(R.id.txtDegrees);
        TextView lblDescription= (TextView) findViewById(R.id.txtDetails);
        //Tomorrow Controls
        TextView lblTmrDate = (TextView)findViewById(R.id.txtTomorrow);
        TextView lblTmrCelsius =(TextView)findViewById(R.id.txtTomorrowCelsius);
        TextView lblTmrDescription=(TextView)findViewById(R.id.txtTmrDescription);

        TextView ConvoStarter=(TextView)findViewById(R.id.TxtConvoStarter);
        Icebreaker = ConvoStarter;

        //The DayAfter tomorrow DFT

        TextView lblDFTDate = (TextView)findViewById(R.id.txtTheDayAfterTomorrow);
        TextView lblDFTCelsius =(TextView)findViewById(R.id.TheDFTCelsius);
        TextView lblDFTDescription=(TextView)findViewById(R.id.txtDscDFT);

        // 4th Day

        TextView lbl4thDate = (TextView)findViewById(R.id.txt4thDay);
        TextView lbl4thCelsius =(TextView)findViewById(R.id.txt4thDayCelsius);
        TextView lbl4thDescription=(TextView)findViewById(R.id.txt4thDayDesc);

        //Variable that displays Today's Weather forecast

        CurrentCity = lblcity;
        Time = lblTime;
        Date_Year_Day = lbldate_Year_Day;
        Humidity = lblHumidity;
        Celsius = lblCelsius;
        Description = lblDescription;

        //setting up the date and Time

        Date date = new Date();
        Date time = new Date();
        SimpleDateFormat Datef = new SimpleDateFormat("EEEE, dd/MM/yyyy");
        SimpleDateFormat Dayf = new SimpleDateFormat("EEEE");
        SimpleDateFormat Timef = new SimpleDateFormat("hh:mm");
        Date_Year_Day.setText(Datef.format(date));
        Time.setText("Time: " + Timef.format(time));






        //WeatherDetails about Tomorrow
        TmrDate = lblTmrDate;
        TmrCelsius = lblTmrCelsius;
        TmrDescription = lblTmrDescription;

        //WeatherDetails about TheDay after Tomorrow

        AfterTmrDate =lblDFTDate;
        AFterTmrCelcius = lblDFTCelsius;
        AfterTmrDescription = lblDFTDescription;

        //WeatherDetails about 4 days from now
         Day4Date = lbl4thDate;
         Day4Celcius = lbl4thCelsius;
         Day4Description = lbl4thDescription;

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
        TmrDate.setText(Dayf.format(dt));

        Date DayPlus2 = new Date();
        Calendar d = Calendar.getInstance();
        d.setTime(DayPlus2);
        d.add(Calendar.DATE, 2);
        DayPlus2 = d.getTime();
        AfterTmrDate.setText(Dayf.format(DayPlus2));

        Date Day4 = new Date();
        Calendar e = Calendar.getInstance();
        e.setTime(Day4);
        e.add(Calendar.DATE, 3);
        Day4 = e.getTime();
        Day4Date.setText(Dayf.format(Day4));


        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(mBroadcastReceiver,
                        new IntentFilter(MyServices.MY_SERVICE_MESSAGE));

        // checking for Network Access
        networkOk = NetworkHelper.hasNetworkAccess(this);
        //NetworkStats.append("Network ok: " + networkOk);
        NetworkStats.setText("Network ok: " + networkOk);

        if (networkOk) {
            Intent intent = new Intent(this, MyServices.class);
            intent.setData(Uri.parse(FullUrl));
            startService(intent);
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }

    }


    //when the application has started
    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        LocalBroadcastManager.getInstance(getApplicationContext())
                .unregisterReceiver(mBroadcastReceiver);
    }

    public void fetchInformation(View view) {

        String BaseUrl = "http://api.openweathermap.org/data/2.5/forecast/daily?q=";
        String TailUrl = "&units=metric&APPID=";

        String UserLocalSearch = UserInput.getText().toString();

        if (UserLocalSearch.matches("")) {
            Toast.makeText(this, "You did not enter a Location Please Try again", Toast.LENGTH_SHORT).show();
            return;

        }

        else
            {

                // checking for Network Access
                networkOk = NetworkHelper.hasNetworkAccess(this);
                NetworkStats.setText("Network ok: " + networkOk);

                if (networkOk) {

                    String SearchLocation = BaseUrl + UserLocalSearch + TailUrl + mKey;
                    Intent intent = new Intent(this, MyServices.class);
                    intent.setData(Uri.parse(SearchLocation));
                    startService(intent);
                } else {
                    Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
                }

            }



    }

    public String SmallTalk(String Xcity,String WDesciption)
    {
        String Statement = "Im not helping you today! make up your own convo!!";

        if(WDesciption.contains("rain"))
        {
            Statement = " I bet wish you were somewhere Sunny right now?";

        }

        else if(WDesciption.contains("snow"))
        {
            Statement= " As crazy as it may sound let make a snow angel";

        }

        else if(WDesciption.contains("sunny"))
        {
            Statement= Xcity +"!"+ " ohh what a beautiful day";

        }

        else if(WDesciption.contains("cloud"))
        {
            Statement= Xcity +"!"+ " why do you want to rain today?";

        }

        else if(WDesciption.contains("sky is clear"))
        {
            Statement= Xcity +"!"+ " A great weather for flying a Kite don't you think?";

        }

        else {Statement = "Hi There How's it going";}

        return Statement;
    }


}//end of Home Activity
