package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "activo")
    private int activo;
    
}
