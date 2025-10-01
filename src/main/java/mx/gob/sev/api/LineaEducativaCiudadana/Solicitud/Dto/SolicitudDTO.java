package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudDTO {

    // Contacto
    private String correo;
    private String telefonoFijo;
    private String telefonoCelular;

    // Llamada
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaTermino;
    private String duracionMinutos;

    // Ubicacion
    private String cct;
    private String nombrePlantel;
    private String nivelEducativo;
    private String sostenimiento;
    private String municipio;
    private String localidad;
    private String tipoEducacion;

    // Solicitud
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String descripcion;
    private String diasTranscurridos;
    private Long idDirectorio;
    private String responsable;
    private Long idEstatus;
    private Long idContacto;
    private Long idLlamada;
    private Long idUbicacion;
    private Long idUsuario;

}
