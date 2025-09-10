package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_directorio")
public class Directorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDirectorio;

    @ManyToOne
    @JoinColumn(name = "idEstructura")
    private EstructuraSev estructurasev;

    @ManyToOne
    @JoinColumn(name = "idAreaTramite")
    private CatalogoTramite areaTramite;

    @ManyToOne
    @JoinColumn(name = "idExtension")
    private CatalogoExtension extension;

    @Column(name = "activo")
    private int activo;
    
}
