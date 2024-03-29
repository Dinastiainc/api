package org.sayco.sirem.electronicbill.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "CLIERESPFISCAL")
public class ClieRespFiscal implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name="idclierespfiscal", columnDefinition="uniqueidentifier")
    private String IdClieRespFiscal;

    /**
     * Codigo de responsibilidad fiscal del empresario/cliente
     */
    @Column(name = "CODRESP")
    private String CodResp;

    /**
     * Campo que representa la identificacion de la persona (Recaudador, Empresario)
     */
    @Column(name = "NIT")
    private String nit;
}
