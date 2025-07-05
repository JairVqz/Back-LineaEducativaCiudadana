package mx.gob.sev.api.LineaEducativaCiudadana.TipoSolicitud.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import mx.gob.sev.api.LineaEducativaCiudadana.Area.Models.Area;
import mx.gob.sev.api.LineaEducativaCiudadana.Prioridad.Models.Prioridad;

@Entity
@Table(name = "tbl_tipoSolicitud")
public class TipoSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoSolicitud;

    @Column(name = "tipoSolicitud")
    private String tipoSolicitud;

    @ManyToOne
    @JoinColumn(name = "idArea", nullable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "idPrioridad", nullable = false)
    private Prioridad prioridad;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    public TipoSolicitud() {
    }

    public TipoSolicitud(Long idTipoSolicitud, String tipoSolicitud, Area area, Prioridad prioridad,
            LocalDateTime created_at, LocalDateTime updated_at, LocalDateTime deleted_at) {
        this.idTipoSolicitud = idTipoSolicitud;
        this.tipoSolicitud = tipoSolicitud;
        this.area = area;
        this.prioridad = prioridad;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public Long getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(Long idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
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
