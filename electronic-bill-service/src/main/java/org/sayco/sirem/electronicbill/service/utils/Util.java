package org.sayco.sirem.electronicbill.service.utils;

import java.util.Collection;

/**
 * Esta clase se encarga de validar los datos
 *
 */
public class Util {

    /**
     * Este metodo estatico se encarga de validar si el parametro de entrada es null retorna true, si no es null, valida
     * si es de tipo de dato como String, una array de objetos o una coleccion, si estos objetos contiene algun valor
     * el metodo retornara false queriendo decir que el parametro de entrada que ingreso no es null
     *
     * @param object
     * @return boolean
     */
    public static boolean isNull(Object object) {
        if (object != null) {
            if ((object instanceof String) && "".equals(object))
                return true;
            else if (((object instanceof Object[])) && ((Object[]) object).length <= 0)
                return true;
            else if (((object instanceof Collection)) && ((Collection<?>) object).isEmpty())
                return true;
            return false;
        }

        return true;
    }
}
