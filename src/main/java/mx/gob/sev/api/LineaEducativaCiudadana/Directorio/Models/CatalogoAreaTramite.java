package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_catalogoAreaTramite")
public class CatalogoAreaTramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAreaTramite;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "activo")
    private int activo;
    
}
