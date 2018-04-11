package com.example.weather.Services;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class WeatherService {


    public String weather(String city) throws IOException {

        String page = "http://api.openweathermap.org/data/2.5/weather?q=" +
                city + "&APPID=f5796476946b43073aed364938f4dfd1";


        URL url = new URL(page);


        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        String result = content.toString();
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        JSONObject json = null;
        try {
            json = (JSONObject) parser.parse(result);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject more = (JSONObject) json.get("main");
        String location = (String) json.get("name");
        String kelvin = more.get("temp").toString();

        Double k = Double.parseDouble(kelvin);

        Double res =  (((k - 273) * 9/5) + 32);

        return  location + " : " +  Double.toString( Math.round(res));
    }
}
