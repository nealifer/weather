package com.example.weather.Controllers;

import com.example.weather.Services.ForcastService;
import com.example.weather.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class Weather {

    @Autowired
    public WeatherService WeatherService;
    @Autowired
    public ForcastService ForcastService;



    public String Weather (String city) throws IOException {



       return  WeatherService.weather(city);
    }

    public String Forcast (String city) throws IOException {

        return ForcastService.fiveDay(city);
    }


}
