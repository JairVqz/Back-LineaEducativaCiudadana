package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models;

import jakarta.persistence.*;
import lombok.*;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoArea;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoTramite;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_relacionAcceso")
public class RelacionAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcceso;

    @ManyToOne
    @JoinColumn(name = "idArea")
    private CatalogoArea catalogoArea;

    @ManyToOne
    @JoinColumn(name = "idTramite")
    private CatalogoTramite catalogoTramite;

    @Column(name = "activo")
    private int activo;
    
}
