package org.sayco.sirem.electronicbill.service;

import java.util.Locale;

public interface I18nService {
    enum MessageCode{
        ERR_001,
        ERR_002,
        ERR_003,
        ERR_004,
        ERR_005,
        ERR_006,
        ERR_007
    };

    /**
     * Obtener mensaje por medio de una llave y un parametro
     *
     * @param key   llave del mensaje
     * @param params    Parametro del mensaje
     * @return  Retorna el mensaje objetino por medio de la llave y el parametro
     */
    String getMessage(MessageCode key, Object ... params);

    /**
     * Obtener mensaje por medio de una llave, un parametro y un local
     *
     * @param key   llave del mensaje
     * @param params    Parametro del mensaje
     * @param locale local del mensaje
     * @return  Retorna el mensaje objetino por medio de la llave, del parametro y del local
     */
    String getMessage(Locale locale, MessageCode key, Object ... params );
}
