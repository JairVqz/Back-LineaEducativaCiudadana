package mx.gob.sev.api.LineaEducativaCiudadana.Ubicacion.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_ubicacionSolicitud")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbicacion;

    @Column(name = "folio")
    private String folio;

    @Column(name = "cct")
    private int nivelCct;

    @Column(name = "nombrePlantel", columnDefinition = "TEXT")
    private String nombrePlantel;

    @Column(name = "nombreDirector")
    private String nombreDirector;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "direccionCct", columnDefinition = "TEXT")
    private String direccionCct;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    public Ubicacion() {
    }   

    public Ubicacion(Long idUbicacion, String folio, int nivelCct, String nombrePlantel, String nombreDirector,
            String municipio, String localidad, String direccionCct, LocalDateTime created_at,
            LocalDateTime updated_at, LocalDateTime deleted_at) {
        this.idUbicacion = idUbicacion;
        this.folio = folio;
        this.nivelCct = nivelCct;
        this.nombrePlantel = nombrePlantel;
        this.nombreDirector = nombreDirector;
        this.municipio = municipio;
        this.localidad = localidad;
        this.direccionCct = direccionCct;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public Long getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Long idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getNivelCct() {
        return nivelCct;
    }

    public void setNivelCct(int nivelCct) {
        this.nivelCct = nivelCct;
    }

    public String getNombrePlantel() {
        return nombrePlantel;
    }

    public void setNombrePlantel(String nombrePlantel) {
        this.nombrePlantel = nombrePlantel;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccionCct() {
        return direccionCct;
    }

    public void setDireccionCct(String direccionCct) {
        this.direccionCct = direccionCct;
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
