package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_solicitudesGeneral")
public class SolicitudGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "folio")
    private String folio;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;

    @Column(name = "idEstatus")
    private int idEstatus;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "diasTranscurridos")
    private String diasTranscurridos;

    @Column(name = "idDirectorio")
    private int idDirectorio;

    @Column(name = "idUbicacion")
    private int idUbicacion;

    @Column(name = "idContacto")
    private int idContacto;

    @Column(name = "idLlamada")
    private int idLlamada;

    @Column(name = "idUsuario")
    private int idUsuario;

    @Column(name = "activo")
    private int activo;
    
}
