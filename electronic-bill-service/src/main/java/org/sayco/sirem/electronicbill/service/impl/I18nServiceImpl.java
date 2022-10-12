package org.sayco.sirem.electronicbill.service.impl;

import org.sayco.sirem.electronicbill.service.I18nService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 *
 */
@Service
public class I18nServiceImpl implements I18nService {

    public static Locale locale = new Locale("es", "CO");

    /**
     * Fuente de mensajes
     */
    final MessageSource messageSource;

    public I18nServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Obtener mensaje por medio de una llave y un parametro
     *
     * @param key   llave del mensaje
     * @param params    Parametro del mensaje
     * @return  Retorna el mensaje objetino por medio de la llave y el parametro
     */
    @Override
    public String getMessage(MessageCode key, Object ... params) {
        return messageSource.getMessage(key.name(), params, locale);
    }

    /**
     * Obtener mensaje por medio de una llave, un parametro y un local
     *
     * @param key   llave del mensaje
     * @param params    Parametro del mensaje
     * @param locale local del mensaje
     * @return  Retorna el mensaje objetino por medio de la llave, del parametro y del local
     */
    @Override
    public String getMessage(Locale locale, MessageCode key, Object ... params) {
        return messageSource.getMessage(key.name(), params, locale);
    }
}
