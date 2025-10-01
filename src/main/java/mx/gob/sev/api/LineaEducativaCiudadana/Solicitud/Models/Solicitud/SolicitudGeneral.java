package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Models.Estatus;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Contacto.Contacto;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Llamada.Llamada;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Ubicacion.Ubicacion;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Usuario;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_solicitudesGeneral")
public class SolicitudGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitud;

    @Column(name = "folio", unique = true)
    private String folio;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "diasTranscurridos")
    private String diasTranscurridos;

    @ManyToOne
    @JoinColumn(name = "idDirectorio")
    private Directorio directorio;

    @Column(name = "responsable")
    private String responsable;

    @ManyToOne
    @JoinColumn(name = "idEstatus")
    private Estatus estatus;

    @ManyToOne
    @JoinColumn(name = "idContacto")
    private Contacto contacto;

    @ManyToOne
    @JoinColumn(name = "idLlamada")
    private Llamada llamada;

    @ManyToOne
    @JoinColumn(name = "idUbicacion")
    private Ubicacion ubicacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "activo")
    private int activo;
    
}