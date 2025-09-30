package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Contacto;

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
@Table(name = "tbl_contactoSolicitud")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContacto;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefonoFijo")
    private String telefonoFijo;

    @Column(name = "telefonoCelular")
    private String telefonoCelular;

    @Column(name = "activo")
    private int activo;
    
}
