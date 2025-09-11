package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_catalogoAreas")
public class CatalogoArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nivel")
    private int nivel;

    @Column(name = "idInterno")
    private Long idInterno;

    @Column(name = "oficial")
    private int oficial;

    @Column(name = "externa")
    private int externa;

    @Column(name = "activo")
    private int activo;

}