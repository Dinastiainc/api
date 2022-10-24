package org.sayco.sirem.electronicbill.service.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Esta clase se encarga de formatear las fechas o de realizar un convert a los datos que manejan las fechas
 */
public class DateUtil {

    /**
     * variable global estatica que tiene un formato de fecha yyyy-MM-dd
     */
    public static final String FORMAT = "dd/MM/yyyy";

    /**
     * Este metodo es el encargado de convertir el dato tipo Date con el formato 'yyyy-MM-dd' en tipo de dato String
     * para ser retornado
     * @return String
     */
    public static String getDateToString(Date date) {
        return getDateToString(FORMAT, date);
    }

    /**
     * Este metodo es el encargado de convertir el dato tipo Date con el formato que viene en el parametro de entrada
     * format en String pero antes el parametro de entrada date se debe de validar si no es null
     * @param format
     * @param date
     * @return String
     */
    public static String getDateToString(String format, Date date) {
        if (!Util.isNull(date)) {
            return format(getDateFormat(format), date);
        }

        return null;
    }

    /**
     * Este metodo se encarga de convertir el parametro de entrada format a DateFormat y ese tipo de dato es retornado
     * @param format
     * @return DateFormat
     */
    public static DateFormat getDateFormat(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * Este metodo se encarga de convertir el parametro  de entrada date con ayuda del parametro de entrada dateFormat
     * y convertirlo en tipo de dato String para ser retornado
     * @param dateFormat
     * @param date
     * @return String
     */
    public static String format(DateFormat dateFormat, Date date) {
        return dateFormat.format(date);
    }
}
