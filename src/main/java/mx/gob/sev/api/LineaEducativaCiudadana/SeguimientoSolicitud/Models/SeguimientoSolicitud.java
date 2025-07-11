package mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Models;

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
@Table(name = "tbl_users")
public class SeguimientoSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguimiento;

    @Column(name = "folio")
    private String folio;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "idDirectorio") 
    private Long idDirectorio;

    @Column(name = "activo")
    private int activo;
    
}
