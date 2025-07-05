package mx.gob.sev.api.LineaEducativaCiudadana.Contacto.Models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_contactoSolicitud")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContacto;

    @Column(name = "folio")
    private String folio;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefonoFijo")
    private String telefonoFijo;

    @Column(name = "telefonoCelular")
    private String telefonoCelular;

    @Column(name = "created_at")
    private LocalDateTime  created_at;

    @Column(name = "updated_at")
    private LocalDateTime  updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime  deleted_at;

    public Contacto() {
    }

    public Contacto(Long idContacto, String folio, String correo, String telefonoFijo, String telefonoCelular,
            LocalDateTime created_at, LocalDateTime updated_at, LocalDateTime deleted_at) {
        this.idContacto = idContacto;
        this.folio = folio;
        this.correo = correo;
        this.telefonoFijo = telefonoFijo;
        this.telefonoCelular = telefonoCelular;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public Long getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Long idContacto) {
        this.idContacto = idContacto;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
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
