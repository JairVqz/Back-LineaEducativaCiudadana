package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models;

import jakarta.persistence.*;
import lombok.*;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoTramite;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.EstructuraSev;

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
    @JoinColumn(name = "idEstructura")
    private EstructuraSev estructuraSev;

    @ManyToOne
    @JoinColumn(name = "idAreaTramite")
    private CatalogoTramite areaTramite;

    @Column(name = "activo")
    private int activo;
    
}
