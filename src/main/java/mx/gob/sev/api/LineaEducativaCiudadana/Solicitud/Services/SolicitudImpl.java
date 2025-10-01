package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.DirectorioRepository;
import mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Repositories.EstatusRepository;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Dto.SolicitudDTO;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Contacto.Contacto;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.FolioSecuencia.FolioSecuencia;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Llamada.Llamada;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud.SolicitudGeneral;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Ubicacion.Ubicacion;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.Contacto.ContactoRepository;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.FolioSecuencia.FolioSecuenciaRepository;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.Llamada.LlamadaRepository;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.Solicitud.SolicitudGeneralRepository;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.Ubicacion.UbicacionRepository;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Repositories.UsuarioRepository;

@Service
public class SolicitudImpl implements SolicitudService {

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private LlamadaRepository llamadaRepository;

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Autowired
    private SolicitudGeneralRepository solicitudRepository;

    @Autowired
    private DirectorioRepository directorioRepository;

    @Autowired
    private EstatusRepository estatusRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FolioSecuenciaRepository folioSecuenciaRepository;

    @Transactional
    public SolicitudGeneral guardarSolicitud(SolicitudDTO dto) {

        // Contacto
        Contacto contacto = new Contacto();
        contacto.setCorreo(dto.getCorreo());
        contacto.setTelefonoFijo(dto.getTelefonoFijo());
        contacto.setTelefonoCelular(dto.getTelefonoCelular());
        contacto.setActivo(1);
        contacto = contactoRepository.save(contacto);

        // Llamada
        Llamada llamada = new Llamada();
        llamada.setFecha(dto.getFecha());
        llamada.setHoraInicio(dto.getHoraInicio());
        llamada.setHoraTermino(dto.getHoraTermino());
        llamada.setDuracionMinutos(dto.getDuracionMinutos());
        llamada.setActivo(1);
        llamada = llamadaRepository.save(llamada);

        // Ubicación
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setCct(dto.getCct());
        ubicacion.setNombrePlantel(dto.getNombrePlantel());
        ubicacion.setNivelEducativo(dto.getNivelEducativo());
        ubicacion.setSostenimiento(dto.getSostenimiento());
        ubicacion.setMunicipio(dto.getMunicipio());
        ubicacion.setLocalidad(dto.getLocalidad());
        ubicacion.setTipoEducacion(dto.getTipoEducacion());
        ubicacion.setActivo(1);
        ubicacion = ubicacionRepository.save(ubicacion);

        // Crear y guardar SolicitudGeneral
        SolicitudGeneral solicitud = new SolicitudGeneral();
        solicitud.setFolio(generarFolio());
        solicitud.setNombre(dto.getNombre());
        solicitud.setApellidoPaterno(dto.getApellidoPaterno());
        solicitud.setApellidoMaterno(dto.getApellidoMaterno());
        solicitud.setDescripcion(dto.getDescripcion());
        solicitud.setDiasTranscurridos("0");
        solicitud.setActivo(1);
        solicitud.setResponsable(dto.getResponsable());
        solicitud.setContacto(contacto);
        solicitud.setLlamada(llamada);
        solicitud.setUbicacion(ubicacion);

        /*
         * Directorio directorio = directorioRepository.findById(dto.getIdDirectorio())
         * .orElseThrow(() -> new RuntimeException("Directorio no encontrado"));
         */

        solicitud.setDirectorio(
                directorioRepository.findById(dto.getIdDirectorio()).orElse(null));
        solicitud.setEstatus(
                estatusRepository.findById(dto.getIdEstatus()).orElse(null));
        solicitud.setUsuario(
                usuarioRepository.findById(dto.getIdUsuario()).orElse(null));

        return solicitudRepository.save(solicitud);
    }

    @Transactional
    private String generarFolio() {
        LocalDate fechaActual = LocalDate.now();
        String anioMes = String.format("%04d%02d", fechaActual.getYear(), fechaActual.getMonthValue());

        Optional<FolioSecuencia> optionalSecuencia = folioSecuenciaRepository.findByAnioMesForUpdate(anioMes);

        FolioSecuencia secuencia;
        if (optionalSecuencia.isPresent()) {
            secuencia = optionalSecuencia.get();
        } else {
            secuencia = new FolioSecuencia();
            secuencia.setAnioMes(anioMes);
            secuencia.setConsecutivo(0);
            secuencia = folioSecuenciaRepository.save(secuencia);
        }

        int nuevoConsecutivo = secuencia.getConsecutivo() + 1;
        secuencia.setConsecutivo(nuevoConsecutivo);
        folioSecuenciaRepository.save(secuencia);

        String folioCompleto = anioMes + String.format("%05d", nuevoConsecutivo);

        System.out.println("Folio completo generado: " + folioCompleto);

        return folioCompleto;
    }

    public List<SolicitudGeneral> findAll() {
        return (List<SolicitudGeneral>) this.solicitudRepository.findAll();
    }

    public List<SolicitudGeneral> findAllActive() {
        return (List<SolicitudGeneral>) this.solicitudRepository.findAllActive();
    }

}
