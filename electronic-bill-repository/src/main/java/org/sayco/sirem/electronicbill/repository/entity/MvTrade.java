package org.sayco.sirem.electronicbill.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * El proceso de recaudo integra al ERP los valores contenidos en los campos que se detallan a continuación.
 * Los documentos (Ordenes de liquidación,  Facturas, Facturas electronicas, Notas debito, Notas debito electronicas)
 * estan estruturado por un encabesado y el cuerpo. La tabla MVTRADE es donde se guarda la información del cuerpo del
 * documento.
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "MVTRADE")
public class MvTrade {

    /**
     * Identificador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDMVTRADE", nullable = false)
    private Long id;

    /**
     * Campo que representa la identificacion de la persona (Recaudador, Empresario)
     */
    @ManyToOne
    @JoinColumn(name = "NIT", referencedColumnName = "NIT")
    private Empresario nit;

    /**
     * campo que representa el nombre del evento
     */
    @Column(name = "NOMBRE")
    private String nombre;

    /**
     * campo que representa las notas del evento
     */
    @Column(name = "NOTAS")
    private String nota;

    /**
     * Campo que representa el establecimiento
     */
    @Column(name = "DETALLE")
    private String detalle;

    /**
     * Campo que representa el valor de licencia
     */
    @Column(name = "VALORUNIT")
    private BigDecimal valorUnit;

    /**
     * Campo que representa el valor de licencia
     */
    @Column(name = "VLRVENTA")
    private BigDecimal vlrVenta;

    /**
     * Campo que representa el numero de la licencia
     */
    @Column(name = "NORDEN")
    private String nOrden;

    /**
     * Campo que representa la fecha de evento
     */
    @Column(name = "FHCOMPRA")
    private Date fhCompra;

    /**
     * Campo que representa la fecha de factura
     */
    @Column(name = "FECENT")
    private Date feCent;

    /**
     * Campo que representa la fecha de factura
     */
    @Column(name = "FECHA")
    private Date fecha;

    /**
     * Campo que representa la fecha de factura
     */
    @Column(name = "FECING")
    private Date fecIng;

    /**
     * Campo que representa el codigo de la integracion y representa la tabla MTMERCIA
     */
    @Column(name = "PRODUCTO")
    private String cuentaContable;

    /**
     * Campo que representa centro de costos
     */
    @Column(name = "CODCC")
    private String codCc;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "NRODCTO", referencedColumnName = "NRODCTO"),
            @JoinColumn(name = "ORIGEN", referencedColumnName = "ORIGEN"),
            @JoinColumn(name = "TIPODCTO", referencedColumnName = "TIPODCTO")
    })
    private Trade trade;

    @Column(name = "BODEGA")
    private String bodega;

    /**
     * Campo que representa el codigo del vendedor
     */
    @Column(name = "VENDEDOR")
    private String codVend;

    /**
     *  Campo que representa la nota
     */
    @Column(name = "NOTA")
    private String tipo;

    /**
     *  Campo que representa la cantidad ...
     */
    @Column(name = "CANTIDAD")
    private int cantidad;

    /**
     *  Campo que representa la cantidad ...
     */
    @Column(name = "NOTADOS")
    private String notados;

}
