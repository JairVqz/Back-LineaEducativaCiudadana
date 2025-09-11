package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_catalogoTramite")
public class CatalogoTramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTramite;

    @Column(name = "tramite")
    private String tramite;

    @ManyToOne
    @JoinColumn(name = "idEstructura")
    private CatalogoArea catalogoArea;

    @Column(name = "publico")
    private int publico;

    @Column(name = "activo")
    private int activo;
    
}
