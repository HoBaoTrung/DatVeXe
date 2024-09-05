package com.dvx.formatter;

import com.dvx.pojo.Route;
import com.dvx.pojo.Types;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


public class TypeFormatter implements Formatter<Types> {

    @Override
    public String print(Types obj, Locale locale) {
        return String.valueOf(obj.getId());
    }

    @Override
    public Types parse(String text, Locale locale)
            throws ParseException {
        Types c = new Types();
        c.setId(Long.parseLong(text));
        return c;
    }
}
