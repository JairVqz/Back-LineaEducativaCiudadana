package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_relacionDirectorio")
public class RelacionDirectorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDirectorio;

    @Column(name = "idEstructura")
    private Long idEstructura;

    @Column(name = "idCatalogoAreaTramite")
    private Long idCatalogoAreaTramite;

    @Column(name = "idCatalogoExtension")
    private Long idCatalogoExtension;

    @Column(name = "activo")
    private int activo;
    
}
