package com.dvx.formatter;

import com.dvx.pojo.Role;
import com.dvx.pojo.Route;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


public class RoleFormatter implements Formatter<Role> {

    @Override
    public String print(Role obj, Locale locale) {
        return String.valueOf(obj.getId());
    }

    @Override
    public Role parse(String text, Locale locale)
            throws ParseException {
        Role c = new Role();
        c.setId(Integer.parseInt(text));
        return c;
    }
}
