package com.dvx.formatter;

import com.dvx.pojo.Route;
import com.dvx.pojo.Station;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


public class StationFormatter implements Formatter<Station> {

    @Override
    public String print(Station obj, Locale locale) {
        return String.valueOf(obj.getId());
    }

    @Override
    public Station parse(String text, Locale locale)
            throws ParseException {
        Station c = new Station();
        c.setId(Long.parseLong(text));
        return c;
    }
}
