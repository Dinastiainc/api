package org.sayco.sirem.electronicbill.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * El proceso de recaudo integra al ERP los valores contenidos en los campos que se detallan a continuación.  Los
 * documentos (Ordenes de liquidación,  Facturas, Facturas electronicas, Notas debito, Notas debito electronicas, Notas
 * Credito, Notas Creditos Electronicas) estan estruturado por un encabesado y el cuerpo. La tabla TRADE es donde se
 * guarda la información del encabezado del documento.
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "TRADE")
public class Trade {

    /**
     * Identificador
     */
    @EmbeddedId
    @Id
    private TradePk id;

    /**
     * Campo que representa la identificacion de la persona (Recaudador, Empresario)
     */
    @ManyToOne
    @JoinColumn(name = "NIT", referencedColumnName = "NIT")
    private Empresario nit;

    /**
     * campo que representa el valor de la liencia
     */
    @Column(name = "BRUTO")
    private BigDecimal bruto;

    /**
     * campo que representa el número de la factura
     */
    @Column(name = "CORRELATID")
    private String correlatid;

    /**
     * Campo que representa fecha de la factura
     */
    @Column(name = "FECHA")
    private Date fecha;

    /**
     * Campo que representa fecha de la factura
     */
    @Column(name = "FECHAING")
    private Date fechaIng;

    /**
     * Campo que representa fecha de la factura
     */
    @Column(name = "FECHAMOD")
    private Date fechaMod;

    /**
     * Campo que representa fecha de la factura
     */
    @Column(name = "FECING")
    private Date fecIng;

    /**
     * Campo que representa fecha de la factura
     */
    @Column(name = "FECMOD")
    private Date fecMod;

    /**
     * Campo que representa fecha de pago
     */
    @Column(name = "FECHA1")
    private Date fecha1;

    /**
     * Campo que representa fecha de pago
     */
    @Column(name = "FECHA2")
    private Date fecha2;

    /**
     * Campo que representa fecha de pago
     */
    @Column(name = "FECHA3")
    private Date fecha3;

    /**
     * Campo que representa centro de costos
     */
    @Column(name = "CODCC")
    private String codCc;

    @Column(name = "MEVERSION")
    private String meVersion;

    @Column(name = "CODIGOCTA")
    private String codigoDeIntegracion;


}
