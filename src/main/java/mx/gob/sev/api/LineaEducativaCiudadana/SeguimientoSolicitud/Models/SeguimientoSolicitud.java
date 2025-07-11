package mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Models;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "curpUsuario")
    private String curpUsuario;

    @Column(name = "idRelacionDirectorio") 
    private Long idRelacionDirectorio;

    @Column(name = "activo")
    private int activo;
    
}
