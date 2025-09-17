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
    @JoinColumn(name = "idArea")
    private CatalogoArea catalogoArea;

    @ManyToOne
    @JoinColumn(name = "idTramite")
    private CatalogoTramite catalogoTramite;

    @ManyToOne
    @JoinColumn(name = "idExtension")
    private CatalogoExtension catalogoExtension;

    @Column(name = "activo")
    private int activo;
    
}
