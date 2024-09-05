package com.dvx.formatter;

import com.dvx.pojo.Route;
import com.dvx.pojo.Types;
import com.dvx.pojo.TypesSeat;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


public class TypeSeatFormatter implements Formatter<TypesSeat> {

    @Override
    public String print(TypesSeat obj, Locale locale) {
        return String.valueOf(obj.getId());
    }

    @Override
    public TypesSeat parse(String text, Locale locale)
            throws ParseException {
        TypesSeat c = new TypesSeat();
        c.setId(Long.parseLong(text));
        return c;
    }
}
