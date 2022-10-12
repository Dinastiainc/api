package org.sayco.sirem.electronicbill.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sayco.sirem.electronicbill.model.ElectronicBillDTO;
import org.sayco.sirem.electronicbill.service.ElectronicBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Con esta clase es que se van a comunicar la(s) aplicacion de SIREM para hacer el proceso de factura electronica
 */
@Tag(name = "Factura electrónica")
@RestController
@RequestMapping("/rest/v1/electronicBill")
public class ElectronicBillController {


    /**
     * Variable global que se encarga de inyectar el service userService para interactuar con la capa de
     * service
     */
    @Autowired
    private ElectronicBillService electronicBillService;

    /**
     * Este metodo lo comunica la aplicacion SIREM sistema externo donde le envia la informacion de la factura
     * electronica y desde el controller es enviado al modulo de service
     * @param electronicBillDTO este objeto trae la informacion de la factura electronica que se va a procesar
     * @return el objeto que se almaceno es el objeto que se va a retornar
     */
    @Operation(summary = "Guardar factura electrónica")
    @PostMapping
    public ResponseEntity<ElectronicBillDTO> save(@RequestBody ElectronicBillDTO electronicBillDTO){
        ElectronicBillDTO electronicBillDTOTmp = electronicBillService.save(electronicBillDTO);
        return ResponseEntity.ok(electronicBillDTOTmp);
    }

}
