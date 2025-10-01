package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.FolioSecuencia;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
    name = "tbl_folioSecuencia",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"anioMes"})
    }
)
public class FolioSecuencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSecuencia;

    @Column(nullable = false)
    private String anioMes;

    @Column(nullable = false)
    private int consecutivo;

}