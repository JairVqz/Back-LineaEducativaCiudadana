package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_catalogoTramites")
public class CatalogoTramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTramite;

    @Column(name = "tramite")
    private String tramite;

    @ManyToOne
    @JoinColumn(name = "idArea")
    private CatalogoArea catalogoArea;
    
    @Column(name = "activo")
    private int activo;
    
}
