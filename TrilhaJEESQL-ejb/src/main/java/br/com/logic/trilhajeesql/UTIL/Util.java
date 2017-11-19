package br.com.logic.trilhajeesql.UTIL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ricardo Vanni
 */
public abstract class Util {

    public String validarData(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(Boolean.FALSE);

        try {
            Date dt = sdf.parse(data);
            return data;

        } catch (ParseException e) {
            throw new ParseException("Data Invalida!", 0);
        }
    }
}
