package org.sayco.sirem.electronicbill.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sayco.sirem.electronicbill.model.CiudadDTO;
import org.sayco.sirem.electronicbill.model.ElectronicBillDTO;
import org.sayco.sirem.electronicbill.model.FacturaDTO;
import org.sayco.sirem.electronicbill.model.EmpresarioDTO;
import org.sayco.sirem.electronicbill.repository.CiudadRepository;
import org.sayco.sirem.electronicbill.repository.MvTradeRepository;
import org.sayco.sirem.electronicbill.repository.EmpresarioRepository;
import org.sayco.sirem.electronicbill.repository.TradeRepository;
import org.sayco.sirem.electronicbill.repository.entity.*;
import org.sayco.sirem.electronicbill.service.ElectronicBillService;
import org.sayco.sirem.electronicbill.service.I18nService;
import org.sayco.sirem.electronicbill.service.exception.ServiceException;
import org.sayco.sirem.electronicbill.service.impl.mappers.CiudadMappers;
import org.sayco.sirem.electronicbill.service.impl.mappers.EmpresarioMappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Esta clase es la que se comunica con el modulo de repositorio ya sea para consultar, crear, eliminar
 * o alterar registros de la factura electronica
 */
@Slf4j
@Service
public class ElectronicBillServiceImpl implements ElectronicBillService {

    /**
     * Variable global que se encarga de inyectar el repository EmpresarioRepository  para interactuar con el
     * modulo repository
     */
    private final EmpresarioRepository empresarioRepository;

    /**
     * Esta variable es la encargada de mapear el objeto Empresario a EmpresarioDTO y viceversa
     */
    private final EmpresarioMappers empresarioMappers;

    /**
     * Esta variable es la encargada de mapear el objeto Ciudad a CiudadDTO y viceversa
     */
    private final CiudadMappers ciudadMappers;

    /**
     * Variable global que se encarga de inyectar el repository EmpresarioRepository  para interactuar con el
     * modulo repository
     */
    private final CiudadRepository ciudadRepository;

    /**
     * Variable global que se encarga de inyectar la internacionalización de los mensajes para las excepciones
     */
    private final I18nService i18nService;

    /**
     * Variable global que se encarga de inyectar el repository TradeRepository  para interactuar con el
     * modulo repository con ayuda de constructor
     */
    private final TradeRepository tradeRepository;

    /**
     * Variable global que se encarga de inyectar el repository MvTradeRepository para interactuar con el
     * modulo repository con ayuda de constructor
     */
    private final MvTradeRepository mvTradeRepository;

    /**
     * El constructor donde hace el proceso de inyectar las variable globales de de esta clase
     * @param empresarioRepository
     * @param empresarioMappers
     * @param ciudadMappers
     * @param ciudadRepository
     * @param i18nService
     * @param tradeRepository
     * @param mvTradeRepository
     */
    public ElectronicBillServiceImpl(EmpresarioRepository empresarioRepository, EmpresarioMappers empresarioMappers, CiudadMappers ciudadMappers, CiudadRepository ciudadRepository, I18nService i18nService, TradeRepository tradeRepository, MvTradeRepository mvTradeRepository) {
        this.empresarioRepository = empresarioRepository;
        this.empresarioMappers = empresarioMappers;
        this.ciudadMappers = ciudadMappers;
        this.ciudadRepository = ciudadRepository;
        this.i18nService = i18nService;
        this.tradeRepository = tradeRepository;
        this.mvTradeRepository = mvTradeRepository;
    }

    /**
     * Metodo que se encarga de llamar el modulo de repositorio para que se pueda guardar la factura electronica
     *
     * @param electronicBillDTO
     * @return ElectronicBillDTO
     */
    @Transactional
    @Override
    public ElectronicBillDTO save(ElectronicBillDTO electronicBillDTO) {
            List<CiudadDTO> ciudades = findCityByName(electronicBillDTO.getEmpresario().getCiudadPrv());
            electronicBillDTO.getEmpresario().setCiudad(ciudades.get(0).getCod());
            EmpresarioDTO empresario = saveEmpresario(electronicBillDTO.getEmpresario());

            saveFactura(electronicBillDTO.getFactura(), empresario);

            return electronicBillDTO;
    }

    /**
     * Metodo que llama al repositorio para que le devuelva una lista de ciudades que se busca por el nombre
     * @return
     */
    private List<CiudadDTO> findCityByName (String nombreCiudad) {
            if(nombreCiudad.isEmpty())
                throw new ServiceException(i18nService.getMessage(I18nService.MessageCode.ERR_001));
            List<Ciudad> ciudades = ciudadRepository.findByNombre(nombreCiudad);
            if (ciudades.isEmpty())
                throw new ServiceException(i18nService.getMessage(I18nService.MessageCode.ERR_002, nombreCiudad));
            return ciudadMappers.toListDTO(ciudades);
    }

    /**
     * Metodo que se encarga de llamar el modulo de repositorio para que se pueda guardar Empresario
     */
    private EmpresarioDTO saveEmpresario(EmpresarioDTO empresario) {
            if (empresario.getNit().isEmpty())
                throw new ServiceException(i18nService.getMessage(I18nService.MessageCode.ERR_003));
            Empresario empresarioTmp = empresarioMappers.toEntity(empresario);
            Optional<Empresario> empresarioOld = empresarioRepository.findById(empresario.getNit());
            if(empresarioOld.isPresent()) {
                empresarioTmp.setFechaModificacion(new Date());
                empresarioTmp.setFechaRegistroCliente(empresarioOld.get().getFechaRegistroCliente());
                empresarioTmp.setFechaIngreso(empresarioOld.get().getFechaIngreso());
            } else {
                empresarioTmp.setFechaRegistroCliente(new Date());
                empresarioTmp.setFechaIngreso(new Date());
            }
            if(empresarioTmp.getEmail().isEmpty())
                throw new ServiceException(i18nService.getMessage(I18nService.MessageCode.ERR_004));
            empresarioTmp.setEmailCartera(empresarioTmp.getEmail());
            empresarioTmp.setEmailCuentaPorPagar(empresarioTmp.getEmail());
            empresarioTmp.setEmailProveedor(empresarioTmp.getEmail());
            empresarioTmp.setEmailReseccionFacElec(empresarioTmp.getEmail());
            empresarioTmp.setNombre(empresarioTmp.getNombre1().concat(" ").concat(empresarioTmp.getNombre2()));
            return empresarioMappers.toDTO(empresarioRepository.save(empresarioTmp));
    }

    /**
     * Este metodo es el encargado de guardar la factura
     * @param factura
     * @return
     */
    private FacturaDTO saveFactura (FacturaDTO factura, EmpresarioDTO empresario) {
        Trade tradeTmp = saveTrade(factura, empresario);
        saveMvTrade(factura, empresario, tradeTmp);
        return null;
    }

    /**
     * Metodo que se encarga de llamar la capa de repositorio donde se maneja el objeto TRADE que es la cabecera
     * del recaudo
     * @param factura Objeto de esta los atributos que necesita el objeto Trade
     * @param empresario Objeto que representa el usuario de la factura
     */
    private Trade saveTrade (FacturaDTO factura, EmpresarioDTO empresario) {
        Trade tradeTmp = new Trade();
        TradePk tradePkTmp = new TradePk(factura.getNumeroDeFactura(), factura.getOrigen(), factura.getTipoDcto());
        tradeTmp.setId(tradePkTmp);
        tradeTmp.setNit(empresarioMappers.toEntity(empresario));
        tradeTmp.setBruto(factura.getValorDeLicencia());
        tradeTmp.setCorrelatid(factura.getNumeroDeFactura());
        tradeTmp.setFecha(factura.getFechaFactura());
        tradeTmp.setFechaIng(factura.getFechaFactura());
        tradeTmp.setFechaMod(factura.getFechaFactura());
        tradeTmp.setFecIng(factura.getFechaFactura());
        tradeTmp.setFecMod(factura.getFechaFactura());
        tradeTmp.setFecha1(factura.getFechaPago());
        tradeTmp.setFecha2(factura.getFechaPago());
        tradeTmp.setFecha3(factura.getFechaPago());
        tradeTmp.setCodCc(factura.getCentroDeCostos());
        return tradeRepository.save(tradeTmp);
    }

    /**
     * Metodo que se encarga de llamar la capa de repositorio donde se maneja el objeto MVTRADE que es el cuerpo
     * del recaudo
     * @param factura Objeto de esta los atributos que necesita el objeto MvTrade
     * @param empresario Objeto que representa el usuario de la factura
     */
    private MvTrade saveMvTrade(FacturaDTO factura, EmpresarioDTO empresario, Trade trade) {
        MvTrade mvTradeTmp = new MvTrade();
        mvTradeTmp.setNit(empresarioMappers.toEntity(empresario));
        mvTradeTmp.setNombre(factura.getNombreDelEvento());
        mvTradeTmp.setNota(factura.getNombreDelEvento());
        mvTradeTmp.setDetalle(factura.getEstablecimiento());
        mvTradeTmp.setValorUnit(factura.getValorDeLicencia());
        mvTradeTmp.setVlrVenta(factura.getValorDeLicencia());
        mvTradeTmp.setNOrden(factura.getNumeroDeLicencia());
        mvTradeTmp.setFhCompra(factura.getFechaEvento());
        mvTradeTmp.setFeCent(factura.getFechaFactura());
        mvTradeTmp.setFecha(factura.getFechaFactura());
        mvTradeTmp.setFecIng(factura.getFechaFactura());
        mvTradeTmp.setProducto(factura.getProducto());
        mvTradeTmp.setTrade(trade);
        return mvTradeRepository.save(mvTradeTmp);
    }
}

