package com.app.jeremiekipeleka.wforweather;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;

import android.support.annotation.Nullable;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
/**
 * Created by jeremie kipeleka on 05/03/2017.
 */

public class FetchWeatherDetails extends Service {
    //Binder initialisation Methods
    //my local binder object to be returned
    public MyLocalBinder myLocalBinder = new MyLocalBinder();

    // the onBind() should never return null
    // so we are creating a local binder to return an instance of binder obj

    public class MyLocalBinder extends Binder {
        FetchWeatherDetails getService() {
            return FetchWeatherDetails.this;

        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myLocalBinder;
    }

    // ----------------------------------------------------------------------------------

    // Initialising Variables and methods for calling and using the service

    String l = "shii";

    public String GetL() {
        return this.l;
    }

    final static String OPEN_WEATHER_MAP_URL =
            "http://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&units=metric";
    String Path = "http://api.openweathermap.org/data/2.5/forecast/daily?id=524901&APPID=9bd6d5d91c8c2e9c52168f0f447e7eeb";
    final static String OPEN_WEATHER_MAP_API = "9bd6d5d91c8c2e9c52168f0f447e7eeb";

    private JSONObject CurentLocationDetails;

    public JSONObject getCurentLocationForecast() {

        //Method to return user current location weather information

        return CurentLocationDetails;
    }




        String charset = "UTF-8";
        HttpURLConnection conn;
        DataOutputStream wr;
        StringBuilder result;
        URL urlObj;
        JSONObject jObj = null;
        JSONArray jAry = null;
        StringBuilder sbParams;
        String paramsString;

        public JSONObject makeHttpRequest(String url, String method, HashMap<String, String> params) {

            sbParams = new StringBuilder();
            int i = 0;
            for (String key : params.keySet()) {
                try {
                    if (i != 0) {
                        sbParams.append("&");
                    }
                    sbParams.append(key).append("=")
                            .append(URLEncoder.encode(params.get(key), charset));

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                i++;
            }

            if (method.equals("POST")) {
                try {
                    urlObj = new URL(url);
                    conn = (HttpURLConnection) urlObj.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Accept-Charset", charset);
                    conn.setReadTimeout(10000);
                    conn.setConnectTimeout(15000);
                    conn.connect();
                    paramsString = sbParams.toString();
                    wr = new DataOutputStream(conn.getOutputStream());
                    wr.writeBytes(paramsString);
                    wr.flush();
                    wr.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (method.equals("GET")) {
                if (sbParams.length() != 0) {
                    url += "?" + sbParams.toString();
                }

                Log.d("URL", url);
                try {
                    urlObj = new URL(url);
                    conn = (HttpURLConnection) urlObj.openConnection();
                    conn.setDoOutput(false);
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept-Charset", charset);
                    conn.setConnectTimeout(15000);
                    conn.connect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                InputStream in = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                Log.d("JSON Parser", "result: " + result.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }

            conn.disconnect();

            try {
                jObj = new JSONObject(result.toString());
            } catch (JSONException e) {
                Log.e("JSON Parser", "Error parsing data " + e.toString());
            }

            return jObj;
        }








}//end of class
