package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_catalogoExtensiones")
public class CatalogoExtension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExtension;

    @Column(name = "extension")
    private String extension;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "activo")
    private int activo;
    
}
