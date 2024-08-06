package com.dvx.formatter;

import com.dvx.pojo.Car;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


public class CarFormatter implements Formatter<Car> {

    @Override
    public String print(Car obj, Locale locale) {
        return String.valueOf(obj.getId());
    }

    @Override
    public Car parse(String text, Locale locale)
            throws ParseException {
        Car c = new Car();
        c.setId(Long.parseLong(text));
        return c;
    }
}
