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
    private String codigoCta;

    @Column(name = "CODINT")
    private BigDecimal codigoDeIntegracion;

    /**
     * Campo que representa el codigo del vendedor
     */
    @Column(name = "CODVEN")
    private String codRecaudador;

    /**
     * Campo que represnta la ciudad
     */
    @Column(name = "CIUDADCLI")
    private String ciudadCli;

    /**
     *  Campo que representa la nota
     */
    @Column(name = "NOTA")
    private String modalidadDeUso;

    /**
     *  Campo que representa el usuario
     */
    @Column(name = "PASSWORDIN")
    private String usuario;

    /**
     *  Campo que representa el usuario
     */
    @Column(name = "DIR")
    private String direccionEmpresario;

    /**
     *  Campo que representa
     */
    @Column(name = "TIPOPER")
    private String tipoPer;

    /**
     *  Campo que representa ...
     */
    @Column(name = "FECCAJA")
    private Date fecCaja;

    /**
     *  Campo que representa ...
     */
    @Column(name = "FHAUTORIZA")
    private Date fhAutoriza;

    /**
     *  Campo que representa ...
     */
    @Column(name = "FISRL")
    private Date fisrl;

    /**
     *  Campo que representa ...
     */
    @Column(name = "FIVA")
    private Date fiva;

    /**
     *  Campo que representa ...
     */
    @Column(name = "FLLAMADA")
    private Date fLlamada;

    /**
     *  Campo que representa ...
     */
    @Column(name = "FRECAUDO")
    private Date fRecaudo;

    /**
     *  Campo que representa ...
     */
    @Column(name = "CONSFECHA")
    private Date consFecha;

    /**
     *  Campo que representa ...
     */
    @Column(name = "MEFECHAT")
    private Date meFechat;

    /**
     *  Campo que representa ...
     */
    @Column(name = "FECHANIF")
    private Date fechaNif;

    /** es necesario hacer un ajuste en el campo  CAJAREG, este campo debe llegar TRADE con valor vacío o Null
     * Julian Andres Miranda - Feb 7 2023 */
    @Column(name = "CAJAREG")
    private String cajaReg = '';
}
