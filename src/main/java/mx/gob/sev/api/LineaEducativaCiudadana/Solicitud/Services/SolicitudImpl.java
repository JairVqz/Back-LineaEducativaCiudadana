package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud.VistaSolicitud;
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

    @Override
    public List<VistaSolicitud> findCoincidenciasSolicitud(String nombreSolicitante, String apellidoPaternoSolicitante,
            String apellidoMaternoSolicitante) {

        List<Object[]> resultados = solicitudRepository.findCoincidenciasSolicitud(
                nombreSolicitante,
                apellidoPaternoSolicitante,
                apellidoMaternoSolicitante);

        List<VistaSolicitud> lista = new ArrayList<>();

        for (Object[] fila : resultados) {

            Long idSolicitud = fila[0] != null ? ((Number) fila[0]).longValue() : null;
            String folio = (String) fila[1];
            String nombre = (String) fila[2];
            String apellidoPaterno = (String) fila[3];
            String apellidoMaterno = (String) fila[4];
            String descripcion = (String) fila[5];
            String diasTranscurridos = (String) fila[6];
            Long idDirectorio = fila[7] != null ? ((Number) fila[7]).longValue() : null;
            String responsable = (String) fila[8];
            String correo = (String) fila[9];
            String telefonoFijo = (String) fila[10];
            String telefonoCelular = (String) fila[11];

            // ✅ Conversión segura de fechas y horas
            java.sql.Date fechaSql = (java.sql.Date) fila[12];
            LocalDate fecha = fechaSql != null ? fechaSql.toLocalDate() : null;

            java.sql.Time horaInicioSql = (java.sql.Time) fila[13];
            LocalTime horaInicio = horaInicioSql != null ? horaInicioSql.toLocalTime() : null;

            java.sql.Time horaTerminoSql = (java.sql.Time) fila[14];
            LocalTime horaTermino = horaTerminoSql != null ? horaTerminoSql.toLocalTime() : null;

            String duracionMinutos = (String) fila[15];
            String cct = (String) fila[16];
            String nombrePlantel = (String) fila[17];
            String nivelEducativo = (String) fila[18];
            String sostenimiento = (String) fila[19];
            String municipio = (String) fila[20];
            String localidad = (String) fila[21];
            String tipoEducacion = (String) fila[22];

            Long idArea = fila[23] != null ? ((Number) fila[23]).longValue() : null;
            String area = (String) fila[24];

            Long idTramite = fila[25] != null ? ((Number) fila[25]).longValue() : null;
            String tramite = (String) fila[26];

            Long idExtension = fila[27] != null ? ((Number) fila[27]).longValue() : null;
            String extension = (String) fila[28];

            Long idEstatus = fila[29] != null ? ((Number) fila[29]).longValue() : null;
            String estatus = (String) fila[30];

            Long idUsuario = fila[31] != null ? ((Number) fila[31]).longValue() : null;
            String nombreUsuario = (String) fila[32];
            String curpUsuario = (String) fila[33];
            String emailUsuario = (String) fila[34];

            int solicitudActiva = fila[35] != null ? ((Number) fila[35]).intValue() : 0;

            VistaSolicitud vista = new VistaSolicitud(
                    idSolicitud,
                    folio,
                    nombre,
                    apellidoPaterno,
                    apellidoMaterno,
                    descripcion,
                    diasTranscurridos,
                    idDirectorio,
                    responsable,
                    correo,
                    telefonoFijo,
                    telefonoCelular,
                    fecha,
                    horaInicio,
                    horaTermino,
                    duracionMinutos,
                    cct,
                    nombrePlantel,
                    nivelEducativo,
                    sostenimiento,
                    municipio,
                    localidad,
                    tipoEducacion,
                    idArea,
                    area,
                    idTramite,
                    tramite,
                    idExtension,
                    extension,
                    idEstatus,
                    estatus,
                    idUsuario,
                    nombreUsuario,
                    curpUsuario,
                    emailUsuario,
                    solicitudActiva);

            lista.add(vista);
        }

        return lista;
    }

}
