package org.sayco.sirem.electronicbill.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sayco.sirem.electronicbill.model.*;
import org.sayco.sirem.electronicbill.repository.*;
import org.sayco.sirem.electronicbill.repository.entity.*;
import org.sayco.sirem.electronicbill.service.ElectronicBillService;
import org.sayco.sirem.electronicbill.service.I18nService;
import org.sayco.sirem.electronicbill.service.exception.ServiceException;
import org.sayco.sirem.electronicbill.service.impl.mappers.CiudadMappers;
import org.sayco.sirem.electronicbill.service.impl.mappers.EmpresarioMappers;
import org.sayco.sirem.electronicbill.service.impl.mappers.RecaudadorMappers;
import org.sayco.sirem.electronicbill.service.utils.Constantes;
import org.sayco.sirem.electronicbill.service.utils.DateUtil;
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
     * Variable global que se encarga de inyectar el repository RecaudadorRepository para interactuar con el
     * modulo repository con ayuda de constructor
     */
    private final RecaudadorRepository recaudadorRepository;

    /**
     * Esta variable es la encargada de mapear el objeto Recaudador a RecaudadorDTO y viceversa
     */
    private final RecaudadorMappers recaudadorMappers;

    /**
     * Variable global que se encarga de inyectar el repository RecaudadorRepository para interactuar con el
     * modulo repository con ayuda de constructor
     */
    private final CuentasRepository cuentasRepository;


    /**
     * Variable global que se encarga de inyectar el repository VendenRepository para interactuar con el
     * modulo repository con ayuda de constructor
     */
    private final VendenRepository vendenRepository;

    /**
     * Variable global que se encarga de inyectar el repository MtMerciaRepository para interactuar con el
     * modulo repository con ayuda de constructor
     */
    private final MtMerciaRepository mtMerciaRepository;

    /**
     * El constructor donde hace el proceso de inyectar las variable globales de de esta clase
     * @param empresarioRepository
     * @param empresarioMappers
     * @param ciudadMappers
     * @param ciudadRepository
     * @param i18nService
     * @param tradeRepository
     * @param mvTradeRepository
     * @param recaudadorRepository
     * @param recaudadorMappers
     * @param cuentasRepository
     * @param vendenRepository
     * @param mtMerciaRepository
     */
    public ElectronicBillServiceImpl(EmpresarioRepository empresarioRepository, EmpresarioMappers empresarioMappers,
                                     CiudadMappers ciudadMappers, CiudadRepository ciudadRepository,
                                     I18nService i18nService, TradeRepository tradeRepository,
                                     MvTradeRepository mvTradeRepository, RecaudadorRepository recaudadorRepository,
                                     RecaudadorMappers recaudadorMappers, CuentasRepository cuentasRepository, VendenRepository vendenRepository, MtMerciaRepository mtMerciaRepository) {
        this.empresarioRepository = empresarioRepository;
        this.empresarioMappers = empresarioMappers;
        this.ciudadMappers = ciudadMappers;
        this.ciudadRepository = ciudadRepository;
        this.i18nService = i18nService;
        this.tradeRepository = tradeRepository;
        this.mvTradeRepository = mvTradeRepository;
        this.recaudadorRepository = recaudadorRepository;
        this.recaudadorMappers = recaudadorMappers;
        this.cuentasRepository = cuentasRepository;
        this.vendenRepository = vendenRepository;
        this.mtMerciaRepository = mtMerciaRepository;
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
        CiudadDTO ciudad = findCityByName(electronicBillDTO.getEmpresario().getCiudadPrv());
        electronicBillDTO.getEmpresario().setCiudad(ciudad != null ? ciudad.getCod() : "0");
        EmpresarioDTO empresario = saveEmpresario(electronicBillDTO.getEmpresario());

        saveFactura(electronicBillDTO);

        return electronicBillDTO;
    }


    /**
     * Metodo que llama al repositorio para que le devuelva una lista de ciudades que se busca por el nombre
     * @return
     */
    private CiudadDTO findCityByName (String nombreCiudad) {
        if(nombreCiudad.isEmpty())
            return null;
        
        List<Ciudad> ciudades = ciudadRepository.findByNombre(nombreCiudad);
        if (ciudades.isEmpty())
            return null;

        return ciudadMappers.toDTO(ciudades.get(0));
    }

    /**
     * Metodo que se encarga de llamar el modulo de repositorio para que se pueda guardar Empresario
     */
    private EmpresarioDTO saveEmpresario(EmpresarioDTO empresario) {
            if (empresario.getIdentificacion().isEmpty())
                throw new ServiceException(i18nService.getMessage(I18nService.MessageCode.ERR_003));
            Empresario empresarioTmp = empresarioMappers.toEntity(empresario);
            Optional<Empresario> empresarioOld = empresarioRepository.findById(empresario.getIdentificacion());
            empresarioTmp.setTipoIdentificacion(empresario.getTipoIdentificacion());
            if(empresarioOld.isPresent()) {
                empresarioTmp.setFechaModificacion(new Date());
                empresarioTmp.setFechaRegistroCliente(empresarioOld.get().getFechaRegistroCliente());
                empresarioTmp.setFechaIngreso(empresarioOld.get().getFechaIngreso());
            } else {
                empresarioTmp.setFechaRegistroCliente(new Date());
                empresarioTmp.setFechaIngreso(new Date());
            }
            if(empresarioTmp.getEmail() == null)
                throw new ServiceException(i18nService.getMessage(I18nService.MessageCode.ERR_004));
            empresarioTmp.setEmailCartera(empresarioTmp.getEmail());
            empresarioTmp.setEmailCuentaPorPagar(empresarioTmp.getEmail());
            empresarioTmp.setEmailProveedor(empresarioTmp.getEmail());
            empresarioTmp.setEmailReseccionFacElec(empresarioTmp.getEmail());
            empresarioTmp.setNombre(empresarioTmp.getNombre());
            return empresarioMappers.toDTO(empresarioRepository.save(empresarioTmp));
    }


    /**
     * Este metodo es el encargado de guardar la factura
     * @param electronicBillDTO
     * @return
     */
    @Transactional
    public FacturaDTO saveFactura(ElectronicBillDTO electronicBillDTO) {
        Trade tradeTmp = saveTrade(electronicBillDTO);
        if (electronicBillDTO.getRecaudador() != null)
            saveRecaudador(electronicBillDTO.getRecaudador());
        saveMvTrade(electronicBillDTO, tradeTmp);
        return null;
    }

    /**
     * Metodo que se encarga de llamar la capa de repositorio donde se maneja el objeto TRADE que es la cabecera
     * del recaudo
     * @param electronicBillDTO Objeto de esta los atributos que necesita el objeto Trade
     */
    private Trade saveTrade(ElectronicBillDTO electronicBillDTO) {
        Trade tradeTmp = new Trade();
        TradePk tradePkTmp = new TradePk(electronicBillDTO.getFactura().getNumeroDeFactura(), electronicBillDTO.getFactura().getOrigen(), electronicBillDTO.getFactura().getTipoDcto());
        tradeTmp.setId(tradePkTmp);
        tradeTmp.setNit(empresarioMappers.toEntity(electronicBillDTO.getEmpresario()));
        tradeTmp.setBruto(electronicBillDTO.getFactura().getValorDeLicencia());
        tradeTmp.setCorrelatid(electronicBillDTO.getFactura().getNumeroDeFactura());
        tradeTmp.setFecha(electronicBillDTO.getFactura().getFechaFactura());
        tradeTmp.setFechaIng(electronicBillDTO.getFactura().getFechaFactura());
        tradeTmp.setFechaMod(electronicBillDTO.getFactura().getFechaFactura());
        tradeTmp.setFecIng(electronicBillDTO.getFactura().getFechaFactura());
        tradeTmp.setFecMod(electronicBillDTO.getFactura().getFechaFactura());
        tradeTmp.setFecha1(electronicBillDTO.getFactura().getFechaPago());
        tradeTmp.setFecha2(electronicBillDTO.getFactura().getFechaPago());
        tradeTmp.setFecha3(electronicBillDTO.getFactura().getFechaPago());
        tradeTmp.setCodCc(electronicBillDTO.getRecaudador() != null ? electronicBillDTO.getRecaudador().getCentroDeCostos() : "0");
        tradeTmp.setMeVersion(Constantes.MEVERSION);
        Cuentas cuentasTmp = cuentasRepository.findById(electronicBillDTO.getFactura().getCuentaContable())
                .orElseGet(() -> {
                    throw new ServiceException(i18nService.getMessage(I18nService.MessageCode.ERR_005, electronicBillDTO.getFactura().getCuentaContable()));
                });
        tradeTmp.setCodigoCta(cuentasTmp.getCodigoCuenta());
        Venden vendenTmp = vendenRepository.findById(electronicBillDTO.getFactura().getRecaudador())
                .orElseGet(() -> {
                    throw new ServiceException(i18nService.getMessage(I18nService.MessageCode.ERR_006, electronicBillDTO.getFactura().getRecaudador()));
                });
        tradeTmp.setCodRecaudador(vendenTmp.getRecaudador());
        tradeTmp.setCiudadCli(electronicBillDTO.getFactura().getCiudad());
        tradeTmp.setCodigoDeIntegracion(electronicBillDTO.getFactura().getCodigoDeIntegracion());
        tradeTmp.setModalidadDeUso(electronicBillDTO.getFactura().getModalidadDeUso());
        tradeTmp.setUsuario(electronicBillDTO.getFactura().getUsuario());
        tradeTmp.setDireccionEmpresario(electronicBillDTO.getEmpresario().getDireccion());
        tradeTmp.setTipoPer(Constantes.TIPOPER);
        tradeTmp.setFecCaja(DateUtil.getDateFromString(Constantes.DEFAULT_DATE));
        tradeTmp.setFhAutoriza(DateUtil.getDateFromString(Constantes.DEFAULT_DATE));
        tradeTmp.setFisrl(DateUtil.getDateFromString(Constantes.DEFAULT_DATE));
        tradeTmp.setFiva(DateUtil.getDateFromString(Constantes.DEFAULT_DATE));
        tradeTmp.setFLlamada(DateUtil.getDateFromString(Constantes.DEFAULT_DATE));
        tradeTmp.setFRecaudo(DateUtil.getDateFromString(Constantes.DEFAULT_DATE));
        tradeTmp.setConsFecha(DateUtil.getDateFromString(Constantes.DEFAULT_DATE));
        tradeTmp.setMeFechat(DateUtil.getDateFromString(Constantes.DEFAULT_DATE));
        tradeTmp.setFechaNif(electronicBillDTO.getFactura().getFechaFactura());

        return tradeRepository.save(tradeTmp);
    }

    /**
     * Metodo que se encarga de llamar la capa de repositorio donde se maneja el objeto MVTRADE que es el cuerpo
     * del recaudo
     * @param electronicBillDTO Objeto de esta los atributos que necesita el objeto MvTrade
     * @param trade Objeto que relaciona MVTRADE con TRADE
     */
    private MvTrade saveMvTrade(ElectronicBillDTO electronicBillDTO, Trade trade) {
        MvTrade mvTradeTmp = new MvTrade();
        mvTradeTmp.setNit(empresarioMappers.toEntity(electronicBillDTO.getEmpresario()));
        mvTradeTmp.setNombre(electronicBillDTO.getFactura().getNombreDelEvento());
        mvTradeTmp.setNota(electronicBillDTO.getFactura().getNombreDelEvento());
        mvTradeTmp.setDetalle(electronicBillDTO.getFactura().getEstablecimiento());
        mvTradeTmp.setValorUnit(electronicBillDTO.getFactura().getValorDeLicencia());
        mvTradeTmp.setVlrVenta(electronicBillDTO.getFactura().getValorDeLicencia());
        mvTradeTmp.setNOrden(electronicBillDTO.getFactura().getNumeroDeLicencia());
        mvTradeTmp.setFhCompra(electronicBillDTO.getFactura().getFechaEvento());
        mvTradeTmp.setFeCent(electronicBillDTO.getFactura().getFechaFactura());
        mvTradeTmp.setFecha(electronicBillDTO.getFactura().getFechaFactura());
        mvTradeTmp.setFecIng(electronicBillDTO.getFactura().getFechaFactura());
        mvTradeTmp.setCodCc(electronicBillDTO.getRecaudador() != null ? electronicBillDTO.getRecaudador().getCentroDeCostos() : "0");
        mvTradeTmp.setTrade(trade);
        mvTradeTmp.setBodega(Constantes.BODEGA);
        Venden vendenTmp = vendenRepository.findById(electronicBillDTO.getFactura().getRecaudador())
                .orElseGet(() -> {
                    throw new ServiceException(i18nService.getMessage(I18nService.MessageCode.ERR_006, electronicBillDTO.getFactura().getRecaudador()));
                });
        mvTradeTmp.setCodRecaudador(vendenTmp.getRecaudador());
        mvTradeTmp.setTipo(electronicBillDTO.getFactura().getTipo());
        mvTradeTmp.setCantidad(Constantes.CANTIDAD);
        mvTradeTmp.setNotados(DateUtil.getDateToString(electronicBillDTO.getFactura().getFechaFactura()));
        MtMercia mtMerciaTmp = mtMerciaRepository.findById(electronicBillDTO.getFactura().getCuentaContable())
                .orElseThrow(() -> {
                    throw new ServiceException(i18nService.getMessage(I18nService.MessageCode.ERR_007, electronicBillDTO.getFactura().getCuentaContable()));
                });
        mvTradeTmp.setProducto(mtMerciaTmp.getCodigo());
        Cuentas cuentasTmp = cuentasRepository.findById(electronicBillDTO.getFactura().getCuentaContable())
                .orElseGet(() -> {
                    throw new ServiceException(i18nService.getMessage(I18nService.MessageCode.ERR_005, electronicBillDTO.getFactura().getCuentaContable()));
                });
        mvTradeTmp.setCodigoCta(cuentasTmp.getCodigoCuenta());
        mvTradeTmp.setUsuario(electronicBillDTO.getFactura().getUsuario());
        return mvTradeRepository.save(mvTradeTmp);
    }

    /**
     * Metodo que se encarga de llamar la capa de repositorio donde se maneja el objeto VENDEN que es la información
     * del recaudador
     * @param recaudador El recaudadore que se va a guardar
     * @return El recaudador ya guardado
     */
    private Recaudador saveRecaudador(RecaudadorDTO recaudador) {
        return recaudadorRepository.save(recaudadorMappers.toEntity(recaudador));
    }
}

