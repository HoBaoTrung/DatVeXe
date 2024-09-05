package com.dvx.formatter;

import com.dvx.pojo.Route;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


public class RouteFormatter implements Formatter<Route> {

    @Override
    public String print(Route obj, Locale locale) {
        return String.valueOf(obj.getId());
    }

    @Override
    public Route parse(String text, Locale locale)
            throws ParseException {
        Route c = new Route();
        c.setId(Long.parseLong(text));
        return c;
    }
}
