package com.hsenidmobile.romeosierra.chefu.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.google.gson.Gson;
import com.hsenidmobile.romeosierra.chefu.model.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by kanchana on 4/28/17.
 */

public class FoodItemFetchClient {
    private URL url;
    private HttpURLConnection con;
    private Gson gson;

    public Object fetchData(String url, Context context) {
        Food food = null;
        try{
            this.url = new URL(url);
            gson = new Gson();
            this.con = (HttpURLConnection) this.url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);

            ConnectivityManager cm = (ConnectivityManager)context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            WifiManager wm = (WifiManager)context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            Class cmClass = Class.forName(cm.getClass().getName());
            Method methodGetMobileDataEnabled = cmClass.getDeclaredMethod("getMobileDataEnabled");
            methodGetMobileDataEnabled.setAccessible(true);
            if(!((Boolean)methodGetMobileDataEnabled.invoke(cm) || wm.isWifiEnabled())){
                throw new Exception("Internet connection is not found. Please check your Internet settings!");
            }
            con.connect();

            BufferedReader buf = new BufferedReader(new InputStreamReader(this.con.getInputStream()));
            food = gson.fromJson(buf, Food.class);
        }
        catch (IOException e){
            Log.e("ERROR", e.getMessage());
            return "Error! " + e.getMessage();
        }
        catch (Exception e){
            Log.e("ERROR", e.getMessage());
            return "Error! " + e.getMessage();
        }
        return food;
    }
}
