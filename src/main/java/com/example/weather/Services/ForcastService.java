package com.example.weather.Services;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Service
public class ForcastService {


    public String fiveDay (String city) throws IOException {



            String page = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&APPID=f5796476946b43073aed364938f4dfd1";


            URL url = new URL(page);
            System.out.println(page);
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
            return json.get("list").toString();

    }
}
