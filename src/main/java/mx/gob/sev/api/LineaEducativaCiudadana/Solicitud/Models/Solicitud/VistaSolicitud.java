package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VistaSolicitud {

    private Long idSolicitud;
    private String folio;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String descripcion;
    private String diasTranscurridos;
    private Long idDirectorio;
    private String responsable;
    private String correo;
    private String telefonoFijo;
    private String telefonoCelular;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaTermino;
    private String duracionMinutos;
    private String cct;
    private String nombrePlantel;
    private String nivelEducativo;
    private String sostenimiento;
    private String municipio;
    private String localidad;
    private String tipoEducacion;
    private Long idAreaSolicitud;
    private String areaSolicitud;
    private Long idTramite;
    private String tramite;
    private Long idExtension;
    private String extension;
    private Long idEstatus;
    private String estatus;
    private Long idUsuario;
    private String nombreUsuario;
    private String curpUsuario;
    private String emailUsuario;
    private int solicitudActiva;
    
}
