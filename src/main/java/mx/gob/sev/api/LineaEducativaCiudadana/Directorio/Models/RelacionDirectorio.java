package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_directorio")
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
