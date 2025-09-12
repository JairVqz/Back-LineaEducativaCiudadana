package mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Models;

import java.time.LocalDateTime;

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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_seguimientoSolicitud")
public class SeguimientoSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguimiento;

    @Column(name = "folio")
    private String folio;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "idUsuario")
    private Long idUsuario;

    @ManyToOne
    @JoinColumn(name = "idDirectorio")
    private Directorio directorio;

    @Column(name = "activo")
    private int activo;
    
}
