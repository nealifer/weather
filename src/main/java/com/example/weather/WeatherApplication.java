package com.example.weather;

import com.example.weather.Controllers.Forcast;
import com.example.weather.Controllers.Weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import javax.swing.table.TableColumn;
import java.io.IOException;

@SpringBootApplication
public class WeatherApplication {

    public static void main(String[] args) throws IOException {
            ApplicationContext cat =SpringApplication.run(WeatherApplication.class, args);

            //String city = "Boston";
            String city = args[0];
            System.out.println(cat.getBean(Weather.class).Weather(city));
        //System.out.println(cat.getBean(Weather.class).Forcast(city));
            //System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
    }
}
