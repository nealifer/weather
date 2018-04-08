package com.example.weather.Controllers;

import com.example.weather.Services.ForcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class Forcast {

    @Autowired
    public ForcastService ForcastService;

    public String forcast (String city) throws IOException {

       return ForcastService.fiveDay(city);

    }
}
