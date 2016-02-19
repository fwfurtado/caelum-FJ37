package br.com.casadocodigo.loja.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Nando on 19/02/16.
 */
@FacesConverter(forClass = Calendar.class)
public class CalendarHtml5Converter implements Converter {

    private static DateTimeConverter dateTimeConverter = new DateTimeConverter();

    static {
        dateTimeConverter.setPattern("yyyy-MM-dd");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Date data = (Date) dateTimeConverter.getAsObject(context, component, value);
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(data);

        return calendar;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Calendar calendar = (Calendar) value;

        return dateTimeConverter.getAsString(context,component, calendar.getTime());
    }

}
