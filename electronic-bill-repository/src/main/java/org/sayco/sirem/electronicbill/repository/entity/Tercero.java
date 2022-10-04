package org.sayco.sirem.electronicbill.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Clase que est relacionada con la tabla MTPROCLI que es para el proceso de terceros que integra al ERP los valores
 * contenidos en los campos que se detallan a continuacion
 */

@NoArgsConstructor
@Entity
@Data
@Table(name = "mtprocli")
public class Tercero {

    /**
     * Número de identificación de terceros
     */
    @Id
    @Column(name = "nit")
    String nit;

    /**
     * Detalle
     */
    @Column(name = "detalle")
    String detalle;

    /**
     * Nombre del banco
     */
    @Column(name = "bancocli")
    String nombreBanco;

    /**
     * email cartera
     */
    @Column(name = "emailcar")
    String emailCartera;

    /**
     * email factura electronica
     */
    @Column(name = "emailfec")
    String emailFacturaElectronica;

    /**
     *
     */
    @Column(name = "nitexterio")
    String nitExterio;

    /**
     * Coódigo unico que identifica la entidad en SGS
     */
    @Column(name = "entidad")
    String entidad;

    @Column(name = "clavepago")
     String clavePago;//3

    @Column(name = "cdusocfdi")
     String  cdusocfdi; //10

    @Column(name = "complecfdi")
     String complecfdi; //250

    @Column(name = "emailcxp")
     String emailCxp; //250

    @Column(name = "habilprov")
     int habilProv; //1

    @Column(name = "plazojusto")
     int plazoJusto; //1

    @Column(name = "regtrsimp")
     int regtrsimp; //1

    @Column(name = "codregfis")
     String codRegFis; //5

    @Column(name = "comelectro")
     int comelectro; // 1



     @Column(name = "medpag")
    String medPag; //5


}
