package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_solicitudesGeneral")
public class Solicitud {

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

    @Column(name = "idTipoSolicitud")
    private int idTipoSolicitud;

    @Column(name = "idPrioridad")
    private int idPrioridad;

    @Column(name = "idEstatus")
    private int idEstatus;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "diasTranscurridos")
    private String diasTranscurridos;

    @Column(name = "curp_usuario")
    private String curpUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "idExtensionSolicitud")
    private int idExtensionSolicitud;

    @Column(name = "idUbicacion")
    private int idUbicacion;

    @Column(name = "idContacto")
    private int idContacto;

    @Column(name = "idLlamada")
    private int idLlamada;

    @Column(name = "created_at")
    private LocalDateTime  created_at;

    @Column(name = "updated_at")
    private LocalDateTime  updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime  deleted_at;

    public Solicitud() {
    }

    public Solicitud(Long id, String folio, String nombre, String apellidoPaterno, String apellidoMaterno, int idTipoSolicitud, int idPrioridad, int idEstatus, String descripcion, String diasTranscurridos, String curpUsuario, String nombreUsuario, int idExtensionSolicitud, int idUbicacion, int idContacto, int idLlamada, LocalDateTime created_at, LocalDateTime updated_at, LocalDateTime deleted_at) {
        this.id = id;
        this.folio = folio;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.idTipoSolicitud = idTipoSolicitud;
        this.idPrioridad = idPrioridad;
        this.idEstatus = idEstatus;
        this.descripcion = descripcion;
        this.diasTranscurridos = diasTranscurridos;
        this.curpUsuario = curpUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idExtensionSolicitud = idExtensionSolicitud;
        this.idUbicacion = idUbicacion;
        this.idContacto = idContacto;
        this.idLlamada = idLlamada;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(int idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public int getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(int idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDiasTranscurridos() {
        return diasTranscurridos;
    }

    public void setDiasTranscurridos(String diasTranscurridos) {
        this.diasTranscurridos = diasTranscurridos;
    }

    public String getCurpUsuario() {
        return curpUsuario;
    }

    public void setCurpUsuario(String curpUsuario) {
        this.curpUsuario = curpUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdExtensionSolicitud() {
        return idExtensionSolicitud;
    }

    public void setIdExtensionSolicitud(int idExtensionSolicitud) {
        this.idExtensionSolicitud = idExtensionSolicitud;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getIdLlamada() {
        return idLlamada;
    }

    public void setIdLlamada(int idLlamada) {
        this.idLlamada = idLlamada;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }
    
}
