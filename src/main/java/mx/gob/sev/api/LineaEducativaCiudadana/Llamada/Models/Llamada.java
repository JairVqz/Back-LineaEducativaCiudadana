package mx.gob.sev.api.LineaEducativaCiudadana.Llamada.Models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_llamadaSolicitud")
public class Llamada {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLlamada;

    @Column(name = "folio")
    private String folio;

    @Column(name = "horaInicio")
    private LocalDateTime horaInicio;

    @Column(name = "horaTermino")
    private LocalDateTime horaTermino;

    @Column(name = "duracionMinutos")
    private String duracionMinutos;

    @Column(name = "created_at")
    private LocalDateTime  created_at;

    @Column(name = "updated_at")
    private LocalDateTime  updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime  deleted_at;

    public Llamada(){
    }

    public Llamada(Long idLlamada, String folio, LocalDateTime horaInicio, LocalDateTime horaTermino,
            String duracionMinutos, LocalDateTime created_at, LocalDateTime updated_at, LocalDateTime deleted_at) {
        this.idLlamada = idLlamada;
        this.folio = folio;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.duracionMinutos = duracionMinutos;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public Long getIdLlamada() {
        return idLlamada;
    }

    public void setIdLlamada(Long idLlamada) {
        this.idLlamada = idLlamada;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(LocalDateTime horaTermino) {
        this.horaTermino = horaTermino;
    }

    public String getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(String duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
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
